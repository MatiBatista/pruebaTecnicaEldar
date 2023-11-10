package com.example.Ejercicio2.services.impl;

import com.example.Ejercicio2.dtos.request.MarcaEImporteRequest;
import com.example.Ejercicio2.dtos.response.OperacionResponse;
import com.example.Ejercicio2.dtos.response.TasaOperacionResponse;
import com.example.Ejercicio2.exceptions.ConsumoExcedidoException;
import com.example.Ejercicio2.exceptions.ResourceNotFoundException;
import com.example.Ejercicio2.models.Marca;
import com.example.Ejercicio2.models.Operacion;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaAmex;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaNara;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaVisa;
import com.example.Ejercicio2.repositories.OperacionRepository;
import com.example.Ejercicio2.services.IOperacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class OperacionServicio implements IOperacionServicio {
    private final OperacionRepository operacionRepository;

    public OperacionResponse getInformacionOperacion(long idOperacion) {

        if(!operacionRepository.existsById(idOperacion)){
            throw new ResourceNotFoundException("Operacion de id "+ idOperacion+" no encontrada");
        }
        Operacion operacion = operacionRepository.findOperacionById(idOperacion);

        final float importeInicial=operacion.getMonto();

        Marca marca= operacion.getTarjeta().getMarca();

        marca.configurarEstrategia();

        final String nombreMarca=marca.getNombre();

        final float tasaMarca=marca.calcularTasa();

        final float montoFinal= operacion.calcularMontoFinal();

        return OperacionResponse.builder().nombreMarcaTarjeta(nombreMarca).importeInicial(importeInicial).importeFinal(montoFinal).tasaServicio(tasaMarca).build();
    }

    @Override
    public TasaOperacionResponse getTasaDeOperacion(MarcaEImporteRequest marcaEImporteRequest) {
        final float importeInicial = marcaEImporteRequest.getMonto();
        final String nombreMarca = marcaEImporteRequest.getNombreMarca();
        if (!Operacion.esValida(importeInicial)) {
            throw new ConsumoExcedidoException("El monto de la operacion no puede superar los $1000");
        }
        Marca marca = crearMarcaSegunNombre(nombreMarca);

        float tasaDeOperacion = calcularTasaDeOperacion(importeInicial, marca);

        return TasaOperacionResponse.builder().tasaDeOperacion(tasaDeOperacion).build();
    }

    private Marca crearMarcaSegunNombre(String nombreMarca) {
        return switch (nombreMarca) {
            case "AMEX" -> new Marca("AMEX", new EstrategiaTasaAmex());
            case "VISA" -> new Marca("VISA", new EstrategiaTasaVisa());
            case "NARA" -> new Marca("NARA", new EstrategiaTasaNara());
            default -> throw new ResourceNotFoundException("Marca de tarjeta '" + nombreMarca + "' no encontrada");
        };
    }

    private float calcularTasaDeOperacion(float importeInicial, Marca marca) {
        float tasaMarca = marca.calcularTasa();
        return tasaMarca / 100.0f * importeInicial;
    }


}
