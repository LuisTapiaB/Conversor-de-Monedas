# 💰 Conversor de Monedas en Java 💰

Este proyecto es un conversor de monedas desarrollado en Java como parte de un desafío del curso de programación de Alura y Oracle. El objetivo principal es practicar los conceptos aprendidos en el curso de Programación Orientada a Objetos (POO) con Java.

## Descripción

El conversor permite a los usuarios convertir montos entre diferentes monedas. Utiliza una interfaz de línea de comandos para interactuar con el usuario, solicitando la moneda base, la moneda objetivo y el monto a convertir. La conversión se realiza a través de una API externa que proporciona las tasas de cambio actuales.

## Funcionalidades

- Selección de moneda base.

  ![image](https://github.com/user-attachments/assets/6dbd27a7-ba46-41db-8377-6552a985a9fc)
- Selección de moneda objetivo.
  
  ![image](https://github.com/user-attachments/assets/7dfe1147-1f7a-413e-8294-27c4e2e3d1d4)
- Ingreso del monto a convertir.

  ![image](https://github.com/user-attachments/assets/293fb9a8-b4b3-43f6-9c03-ed9d366fad2d)
- Consulta de tasas de cambio en tiempo real.
  
  ![image](https://github.com/user-attachments/assets/95f096e1-9946-419f-9d7b-d28fd582fdd7)
- Manejo de excepciones para entradas no válidas.
 

## Estructura del Proyecto

- **Principal**: Contiene la clase `Principal` que gestiona la ejecución del programa y la interacción con el usuario.
- **Modelos**: Incluye las clases necesarias para el manejo de monedas y tasas de conversión.
  - `Monedas`: Clase que gestiona las monedas disponibles y sus pares.
  - `ConversionRateRaw`: Clase que representa la tasa de conversión cruda recibida de la API.
  - `ConversionRate`: Clase que encapsula la tasa de conversión y proporciona un formato legible.

## Monededas por defecto

El conversor permite la conversión entre las siguientes monedas:

- ARS - Peso argentino.
- MXN - Peso mexicano.
- COP - Peso colombiano.
- USD - Dólar estadounidense.

## Requisitos

- JDK 8 o superior.
- Conexión a Internet (para la consulta de la API).

## Instalación

1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/LuisTapiaB/Conversor-de-Monedas.git

2. Gracias a Alura y Oracle por proporcionar este curso y a todos los colaboradores que han contribuido a su desarrollo.
