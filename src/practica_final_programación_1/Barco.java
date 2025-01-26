package practica_final_programación_1;

/**
 * @author diego
 *
 * Representa un barco en el juego. Cada barco tiene una longitud, una posición
 * inicial en el tablero, una orientación (horizontal o vertical) y un contador
 * de impactos.
 *
 */
public class Barco {
    // DECLARACIÓN ATRIBUTOS 

    // Longitud del barco
    private int longitud;
    // Posición inicial del barco en el tablero
    private int filaInicio;
    private int columnaInicio;
    // Orientación del barco true = "Horizontal"
    private boolean esHorizontal;
    // Número de impactos recibidos
    private int impactos;

    // Constructor inicializa el barco con una longitud específica
    public Barco(int longitud) {
        this.longitud = longitud;
        this.impactos = 0;
    }

    // METODOS FUNCIONALES
    // Configura la posición inicial y orientación del barco
    public void setPosicion(int columnaInicio, int filaInicio, boolean esHorizontal) {
        this.columnaInicio = columnaInicio;
        this.filaInicio = filaInicio;
        this.esHorizontal = esHorizontal;
    }

    // Verifica si el barco ocupa la posición especificada
    public boolean estaEnPosicion(int fila, int columna) {
        // Si el barco esta en horizontal recorremos las columnas desde el inicio del barco hasta el final
        if (esHorizontal) {
            for (int i = 0; i < longitud; i++) {
                if (filaInicio == fila && (columnaInicio + i) == columna) {
                    // Si la coordenada pasada por parametro coincide con alguna de las posiciones que
                    // ocupa el barco devuelve true
                    return true;
                }
            }
        } else {
            // Recorremos las filas desde el inicio del barco hasta el final
            for (int i = 0; i < longitud; i++) {
                if ((filaInicio + i) == fila && columnaInicio == columna) {
                    // Si la coordenada pasada por parametro coincide con alguna de las posiciones que
                    // ocupa el barco devuelve true
                    return true;
                }
            }
        }
        return false;
    }

    // Registra un impacto al barco
    public void agregarImpacto() {
        impactos++;
    }

    // Comprueba si el barco está hundido
    public boolean estaHundido() {
        return impactos >= longitud;
    }

    // Retorna si el barco es horizontal
    public boolean esHorizontal() {
        return esHorizontal;
    }

    // Obtiene la longitud del barco
    public int getLongitud() {
        return longitud;
    }

    // Obtiene la fila inicial del barco
    public int getFilaInicio() {
        return filaInicio;
    }

    // Obtiene la columna inicial del barco
    public int getColumnaInicio() {
        return columnaInicio;
    }
}
