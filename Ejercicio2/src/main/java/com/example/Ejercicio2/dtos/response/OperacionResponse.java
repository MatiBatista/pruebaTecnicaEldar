package com.example.Ejercicio2.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OperacionResponse {

    private String nombreMarcaTarjeta;

    private float importeInicial;

    private float importeFinal;

    private float tasaServicio;


}
