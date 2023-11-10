package org.example.models;

import org.example.exceptions.TarjetaInvalidaExcepcion;

import java.time.LocalDate;

public class Tarjeta {
    private String numero;
    private String cardHolder;
    private LocalDate fechaVencimiento;
    private Marca marca;

    public Tarjeta(String numeroTarjeta, String cardHolder, LocalDate fechaVencimiento, Marca marca) {
        this.numero = numeroTarjeta;
        this.cardHolder = cardHolder;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
    }

    public String informacionTarjeta() {
        StringBuilder infoTarjeta = new StringBuilder();
        infoTarjeta.append("Numero de tarjeta: ").append(this.numero).append("\n");
        infoTarjeta.append("CardHolder: ").append(this.cardHolder).append("\n");
        infoTarjeta.append("Fecha de vencimiento: ").append(this.fechaVencimiento).append("\n");
        infoTarjeta.append("Marca: ").append(this.getMarca().getNombre()).append("\n");
        return infoTarjeta.toString();
    }

    public Boolean esValida() throws TarjetaInvalidaExcepcion {
        if (this.fechaVencimiento.isAfter(LocalDate.now())) {
            return true;
        } else {
            throw new TarjetaInvalidaExcepcion("La tarjeta no es válida");
        }
    }


    public Boolean sonIguales(Tarjeta otraTarjeta) {
        return this.numero.equals(otraTarjeta.getNumero()) &&
                this.marca.getNombre().equals(otraTarjeta.getMarca().getNombre()) &&
                this.cardHolder.equals(otraTarjeta.getCardHolder()) &&
                this.fechaVencimiento.equals(otraTarjeta.getFechaVencimiento());
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getter y Setter para 'marca'
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

}
