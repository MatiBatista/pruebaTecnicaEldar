package org.example.models;

import org.example.exceptions.OperacionInvalidaExcepcion;

public class Operacion {

    private Tarjeta tarjeta;
    private float monto;

    public Operacion(float monto, Tarjeta tarjeta) throws OperacionInvalidaExcepcion {
        if (monto > 1000) {
            throw new OperacionInvalidaExcepcion("La operación es inválida: No debe superar los $1000");
        }
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public String informacionOperacion() {
        String marca = this.getTarjeta().getMarca().getNombre();
        float tasa = this.getTarjeta().getMarca().calcularTasa() / 100.0f;
        float importeInicial = this.getMonto();
        float importeFinal = importeInicial + (tasa * importeInicial);

        StringBuilder info = new StringBuilder();
        info.append("Marca: ").append(marca).append("\n");
        info.append("Tasa: ").append(String.format("%.2f%%", tasa * 100)).append("\n");
        info.append("Importe inicial: ").append("$").append(importeInicial).append("\n");
        info.append("Importe final: ").append("$").append(importeFinal).append("\n");
        return info.toString();
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }


    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

}

