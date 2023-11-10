package org.example.models.estrategias;

import org.example.models.EstrategiaTasa;

import java.time.LocalDate;

public class EstrategiaTasaNara implements EstrategiaTasa {

    private final String nombre="NARA";
    // Implementa el cálculo de la tasa para NARA
    @Override
    public float calcularTasa() {
        LocalDate currentDate = LocalDate.now();
        int dia = currentDate.getDayOfMonth();
        return dia*0.5F;
    }


    public String getNombre(){
        return this.nombre;
    }
}
