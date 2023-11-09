package com.example.Ejercicio2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private Tarjeta tarjeta;

    @Column(nullable = false)
    private float monto;


    public float calcularMontoFinal() {

        float tasa = this.getTarjeta().getMarca().calcularTasa();
        float importeInicial = this.getMonto();
        return importeInicial + (tasa / 100.0f * importeInicial);

    }
}
