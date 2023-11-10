# Prueba Técnica Eldar - Batista Matías Omar

Este repositorio contiene la solución de los 5 ejercicios propuestos.

## Ejercicio 2

Para el ejercicio 2, se ha creado un Dockerfile para contenerizar la aplicación, la cual ha sido desplegada en un servicio de cloud computing gratuito llamado Render. Puedes acceder a la API REST desde el siguiente enlace:

[**API REST del Ejercicio 2**](https://ejercicio2.onrender.com/)

### Recurso de Obtención de Tasa de una Operacion Mediante el Nombre de la Marca y el Monto

**Endpoint solicitado:**

- **URL:** [https://ejercicio2.onrender.com/operacion/tasaOperacion](https://ejercicio2.onrender.com/operacion/tasaOperacion)
- **Método:** GET

**Respuestas esperadas:**

-`Json enviado:`

```json
{
  "nombreMarca": "AMEX",
  "monto": 100
}
```

-`Json respuesta:` -`Http status:200`

```json
{
  "tasaDeOperacion": 1.1
}
```

-`En caso de que el monto de la operacion supere los $1000:` -`Json enviado:`

```json
{
  "nombreMarca": "AMEX",
  "monto": 1001
}
```

-`Json respuesta:` -`Http stauts:400`

```json
{
  "Mensaje": "El monto de la operacion no puede superar los $1000"
}
```

-`En caso de que se envie el nombre de una marca no existente:` -`Json enviado:`

```json
{
  "nombreMarca": "AR",
  "monto": 100
}
```

-`Json respuesta:` -`Http stauts:404`

```json
{
  "Mensaje": "Marca de tarjeta 'AR' no encontrada"
}
```

### Recurso de Obtención de Información de Operación mediante su ID

Para permitirte probar el recurso solicitado, se han creado las 3 marcas, 3 tarjetas asociadas a cada marca y una operación por tarjeta en una base de datos en memoria llamada H2.

**Endpoint para obtener datos de la operacion mediante su id:**

- **URL:** [https://ejercicio2.onrender.com/operacion/{idOperacion}](https://ejercicio2.onrender.com/operacion/{idOperacion})
- **Método:** GET

**Respuestas esperadas:**

-`idOperacion=1`

```json
{
  "nombreMarcaTarjeta": "NARA",
  "importeInicial": 900.0,
  "importeFinal": 940.5,
  "tasaServicio": 4.5
}
```

-`idOperacion=2`

```json
{
  "nombreMarcaTarjeta": "VISA",
  "importeInicial": 900.0,
  "importeFinal": 918.8182,
  "tasaServicio": 2.090909
}
```

-`idOperacion=3`

```json
{
  "nombreMarcaTarjeta": "AMEX",
  "importeInicial": 900.0,
  "importeFinal": 909.9,
  "tasaServicio": 1.1
}
```

-`Cualquier otro idOperacion`

```json
{
  "Mensaje": "Operacion de id 4 no encontrada"
}
```

## Tecnologías Utilizadas

La API REST se ha desarrollado haciendo uso de las siguientes tecnologías:

- **Lenguaje de Programación:** Java
- **Framework:** Spring Boot
- **ORM (Object-Relational Mapping):** JPA (Java Persistence API)
- **Base de Datos:** H2 (En memoria)
- **Entorno de Desarrollo Integrado (IDE):** IntelliJ IDEA
