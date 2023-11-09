package org.example;

import org.example.exceptions.OperacionInvalidaExcepcion;
import org.example.exceptions.TarjetaInvalidaExcepcion;
import org.example.models.*;
import org.example.models.estrategias.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tarjeta[] tarjetas = new Tarjeta[3];

        tarjetas[0] = crearTarjetaVisa();
        tarjetas[1] = crearTarjetaNara();
        tarjetas[2] = crearTarjetaAmex();

        for (int i = 0; i < tarjetas.length; i++) {
            try {
                String nombreMarca=tarjetas[i].getMarca().getNombre();
                System.out.println("---------------------------------------------------------------TARJETA " +nombreMarca+"---------------------------------------------------------");
                System.out.println("-Informacion tarjeta:" );
                System.out.println(tarjetas[i].informacionTarjeta());
                if (tarjetas[i].esValida()) {
                    System.out.println("-La tarjeta "+nombreMarca+" es valida para operar\n");
                    float montoOperacion = (i + 1) * 400;
                    Operacion operacion = new Operacion(montoOperacion, tarjetas[i]);
                    System.out.println("-Información de la operación a la tarjeta "+nombreMarca+":");
                    System.out.println(operacion.informacionOperacion());

                }
            } catch (OperacionInvalidaExcepcion|TarjetaInvalidaExcepcion e) {
                System.out.println( e.getMessage());
            }
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("COMPARO COMO EJEMPLO SI LA TARJETA VISA ES IGUAL A LA TARJETA NARA:");
        if(tarjetas[0].sonIguales(tarjetas[1])){
            System.out.println("Resultado:Las tarjetas son iguales");
        }
        else{
            System.out.println("Resultado:Las tarjetas son distintas");
        }
        System.out.println();
        System.out.println("COMPARO COMO EJEMPLO SI LA TARJETA VISA ES IGUAL A LA TARJETA VISA:");
        if(tarjetas[0].sonIguales(tarjetas[0])){
            System.out.println("Resultado:Las tarjetas son iguales");
        }
        else{
            System.out.println("Resultado:Las tarjetas son distintas");
        }
    }

    private static Tarjeta crearTarjetaVisa() {
        Marca marcaVisa = new Marca();
        EstrategiaTasa estrategiaTasaVisa = new EstrategiaTasaVisa();
        marcaVisa.setEstrategiaTasa(estrategiaTasaVisa);
        LocalDate fechaVencimientoTarjetaVisa = LocalDate.of(2024, 10, 15);
        return new Tarjeta("123456546766", "Pepito Gonzalez", fechaVencimientoTarjetaVisa, marcaVisa);
    }

    private static Tarjeta crearTarjetaNara() {
        Marca marcaNara = new Marca();
        EstrategiaTasa estrategiaTasaNara = new EstrategiaTasaNara();
        marcaNara.setEstrategiaTasa(estrategiaTasaNara);
        LocalDate fechaVencimientoTarjetaNara = LocalDate.of(2021, 4, 3);
        return new Tarjeta("12345645676", "Matias Batista", fechaVencimientoTarjetaNara, marcaNara);
    }

    private static Tarjeta crearTarjetaAmex() {
        Marca marcaAmex = new Marca();
        EstrategiaTasa estrategiaTasaAmex = new EstrategiaTasaAmex();
        marcaAmex.setEstrategiaTasa(estrategiaTasaAmex);
        LocalDate fechaVencimientoTarjetaAmex = LocalDate.of(2024, 4, 3);
        return new Tarjeta("4554561235465", "Abril Lavigne", fechaVencimientoTarjetaAmex, marcaAmex);
    }
}
