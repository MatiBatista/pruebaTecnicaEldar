package org.example;

public class Main {
    public static void main(String[] args) {
        // Creo un array de strings
        String[] array = { "FirStWoRd", "SeCondWoRd", "THIRDword" };

        // Verifico si la longitud del arreglo no supera las 10 posiciones
        if (!validarLongitud(array)) {
            System.out.println("Error: La longitud del array  superó el límite permitido.");
            return;
        }
        // Llamo a la función para transformar el array en el resultado que preciso
        String resultado = transformarArray(array);

        // Imprimo el resultado
        System.out.println(resultado);
    }

    // Función para transformar un array de strings en la salida que preciso
    public static String transformarArray(String[] array) {
        // Recorro el arreglo de principio a fin
        for (int i = 0; i < array.length; i++) {
            // Transformo cada palabra a minúscula
            String palabra = array[i].toLowerCase();

            // Valido que cada palabra en el arreglo contenga solo letras y espacios en blanco, y que no esté vacía.
            if (!validarCadena(palabra)) {
                return "Error: Uno o más elementos del array no cumplen con las restricciones.";
            }

            // Actualizo el elemento del arreglo con la versión en minúsculas
            array[i] = palabra;
        }

        // Une todas las palabras con espacios y retorna el resultado
        String respuesta=String.join(" ", array);
        return "RESULTADO: "+"'"+respuesta+"'";
    }

    // Función para validar que la longitud del arreglo no supere las 10 posiciones
    private static boolean validarLongitud(String[] array) {
        return array.length <= 10;
    }

    // Función para validar que una cadena contenga solo letras y espacios en blanco, y que no esté vacía.
    private static boolean validarCadena(String cadena) {
        return cadena.matches("^[a-zA-Z ]+$"); // Verifica que la cadena contiene solo letras y espacios
    }
}