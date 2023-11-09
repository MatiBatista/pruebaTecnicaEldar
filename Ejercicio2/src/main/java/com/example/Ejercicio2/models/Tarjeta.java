package com.example.Ejercicio2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Tarjeta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( nullable = false)
    private String numero;

    @Column(nullable = false)
    private String cardHolder;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @ManyToOne(optional = false)
    private Marca marca;

    @OneToMany(mappedBy = "tarjeta",cascade = CascadeType.ALL)
    private List<Operacion> operaciones;


}
