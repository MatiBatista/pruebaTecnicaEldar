package org.example.models.estrategias;

import org.example.models.EstrategiaTasa;

import java.time.LocalDate;

public class EstrategiaTasaVisa implements EstrategiaTasa {
    private final String nombre="VISA";
    // Implementa el cálculo de la tasa para VISA
    @Override
    public float calcularTasa() {
        LocalDate currentDate = LocalDate.now();
        int anio = currentDate.getYear();
        int mes = currentDate.getMonthValue();
        int anioRecortado = anio % 100;
        return (float) anioRecortado /mes;
    }
    public String getNombre(){
        return this.nombre;
    }
}
