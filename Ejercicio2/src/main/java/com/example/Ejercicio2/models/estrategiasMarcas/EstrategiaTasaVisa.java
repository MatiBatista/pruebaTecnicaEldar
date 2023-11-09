package com.example.Ejercicio2.models.estrategiasMarcas;

import com.example.Ejercicio2.models.EstrategiasTasa;


import java.time.LocalDate;

public class EstrategiaTasaVisa implements EstrategiasTasa {

    // Implementa el cálculo de la tasa para VISA
    @Override
    public float calcularTasa() {
        LocalDate currentDate = LocalDate.now();
        int anio = currentDate.getYear();
        int mes = currentDate.getMonthValue();
        int anioRecortado = anio % 100;
        return (float) anioRecortado /mes;
    }

}