package com.example.Ejercicio2.models;

import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaAmex;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaNara;
import com.example.Ejercicio2.models.estrategiasMarcas.EstrategiaTasaVisa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "marca")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Transient
    private EstrategiasTasa estrategiaTasa;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Tarjeta> tarjetas;


    // Método para configurar la estrategia según su propio nombre
    public void configurarEstrategia() {

        if ("VISA".equals(nombre)) {
            this.estrategiaTasa = new EstrategiaTasaVisa();
        } else if ("NARA".equals(nombre)) {
            this.estrategiaTasa = new EstrategiaTasaNara();
        } else if ("AMEX".equals(nombre)) {
            this.estrategiaTasa = new EstrategiaTasaAmex();
        }

    }

    // Metodo para devolver la tasa segun la estrategia
    public float calcularTasa(){

        if(estrategiaTasa!=null){
            return estrategiaTasa.calcularTasa();
        }
        return 0;

    }

}