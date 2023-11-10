package org.example.models;

public class Marca {
    private EstrategiaTasa estrategiaTasa;
    private String nombre;


    public float calcularTasa(){
        if(estrategiaTasa!=null){
            return estrategiaTasa.calcularTasa();
        }
        return 0;
    }

    public EstrategiaTasa getEstrategiaTasa() {
        return estrategiaTasa;
    }

    public void setEstrategiaTasa(EstrategiaTasa estrategiaTasa) {
        this.estrategiaTasa = estrategiaTasa;
        this.nombre = estrategiaTasa.getNombre();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
