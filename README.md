### Practica_Programacion_I
Práctica final de la asignatura Programación I: Implementación del juego Hundir la Flota en Java.
### Hundir la Flota - Practica_Programacion_I

Práctica final de la asignatura **Programación I**: Implementación del clásico juego de mesa _Hundir la Flota_ en **Java**.

## Descripción
Este proyecto simula el popular juego **Hundir la Flota** con opciones de juego para un solo jugador, contra otro jugador local o contra una CPU. Diseñado en un entorno de **NetBeans** siguiendo principios de programación orientada a objetos (POO), incluye un sistema de registro de partidas y estadísticas personalizadas.

---

## Características
- **Modos de juego:**
  - Jugar solo.
  - Jugar contra otro jugador (local).
  - Jugar contra la CPU (movimientos aleatorios o inteligentes).
- **Registro y estadísticas:**
  - Visualización del historial de partidas.
  - Estadísticas detalladas por jugador y filtros avanzados.
- **Configuración de tablero:**
  - Dimensiones personalizadas (por ejemplo, 10x10).
  - Distribución de barcos personalizada o aleatoria.
- **Persistencia de datos:**
  - Las partidas y estadísticas se guardan automáticamente en `RegistroPartidas.txt`.

---

## Instrucciones de Uso
### Requisitos previos
- Java 8+ instalado.
- NetBeans IDE configurado.

### Ejecución del proyecto
1. Descarga el proyecto desde este repositorio en formato `.zip`.
2. Extrae los archivos descargados en tu computadora.
3. Abre el proyecto en NetBeans.
4. Ejecuta la clase principal `Main.java`.

---

## Menús disponibles
### Menú principal:
```plaintext
***************************************************
                     MENÚ PRINCIPAL
***************************************************
1. JUGAR
2. REGISTRO
s. SALIR


Opciones de juego:
Jugar solo: Competir contra un tablero rival predefinido.
Jugar contra otro jugador: Competir contra otro jugador local.
Jugar contra la CPU: Competir contra una inteligencia artificial con disparos aleatorios.


Configuración del Tablero
Dimensiones del tablero
Convencional: 10x10.
Personalizado: Introducir filas y columnas.
Distribución de barcos
Predeterminada: 5-4-3-3-2.
Personalizada: Introducir una secuencia como 5-4-3-2-1.
Aleatoria: Generada automáticamente.

Registro y Estadísticas
Registro de partidas:
Fecha, modo de juego, disparos realizados y resultados.
Estadísticas por jugador:
Total de partidas jugadas, victorias, disparos acertados y fallidos.
Ejemplo de formato de registro:
2025-01-26 14:00:00#Diego#Solitario#10x10#5-4-3-3-2#17#5#15#true

Estructura del Proyecto
src/: Código fuente en Java.
RegistroPartidas.txt: Archivo de registro y estadísticas.
build.xml: Configuración de NetBeans.
taulers/: Ficheros de distribución inicial del tablero.

Restricciones
Para cumplir con los criterios académicos, este proyecto sigue las siguientes reglas:

Sin uso avanzado de String: El uso de métodos como substring o replace está prohibido.
Procesamiento secuencial: No se permite cargar archivos completos en memoria.

Autor
Diego Malagrida González
Estudiante de Ingeniería Informática en la Universidad de las Islas Baleares (UIB).

