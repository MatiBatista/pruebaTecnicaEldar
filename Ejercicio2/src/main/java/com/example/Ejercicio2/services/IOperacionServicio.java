package com.example.Ejercicio2.services;

import com.example.Ejercicio2.dtos.request.MarcaEImporteRequest;
import com.example.Ejercicio2.dtos.response.OperacionResponse;
import com.example.Ejercicio2.dtos.response.TasaOperacionResponse;


public interface IOperacionServicio {
    OperacionResponse getInformacionOperacion(long idOperacion);

    TasaOperacionResponse getTasaDeOperacion(MarcaEImporteRequest marcaEImporteRequest);
}
