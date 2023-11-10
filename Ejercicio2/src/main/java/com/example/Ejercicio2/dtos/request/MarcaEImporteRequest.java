package com.example.Ejercicio2.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MarcaEImporteRequest {
    private String nombreMarca;
    private float monto;
}
