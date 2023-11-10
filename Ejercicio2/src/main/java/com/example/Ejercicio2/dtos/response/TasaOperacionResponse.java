package com.example.Ejercicio2.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TasaOperacionResponse {
    private float tasaDeOperacion;

}
