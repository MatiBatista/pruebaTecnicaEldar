package org.example.models.estrategias;

import org.example.models.EstrategiaTasa;

import java.time.LocalDate;

public class EstrategiaTasaAmex implements EstrategiaTasa {
    private final String nombre="AMEX";
    // Implementa el cálculo de la tasa para AMEX
    @Override
    public float calcularTasa() {
        LocalDate currentDate = LocalDate.now();
        int mes = currentDate.getMonthValue();
        return mes*0.1F;
    }
    public String getNombre(){
        return this.nombre;
    }
}
