package com.example.Ejercicio2.services;

import com.example.Ejercicio2.dtos.response.OperacionResponse;


public interface IOperacionServicio {
    OperacionResponse getInformacionOperacion(long idOperacion);
}
