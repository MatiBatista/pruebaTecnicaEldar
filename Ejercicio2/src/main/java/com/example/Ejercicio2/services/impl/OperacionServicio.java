package com.example.Ejercicio2.services.impl;

import com.example.Ejercicio2.dtos.response.OperacionResponse;
import com.example.Ejercicio2.exceptions.ResourceNotFoundException;
import com.example.Ejercicio2.models.Marca;
import com.example.Ejercicio2.models.Operacion;
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
}
