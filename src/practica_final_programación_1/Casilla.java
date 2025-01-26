package practica_final_programación_1;
/**
 *
 * @author diego
 * 
 *  Clase que representa una casilla del tablero en el juego. Cada
 *  casilla tiene un estado que indica su contenido (vacía, barco, agua, etc.).
 */
public class Casilla {

    // DECLARACIÓN ATRIBUTOS 
    
    // Estados de las casillas
    // Celda vacía
    static final char celdaVacia = '-';
    // Barco que no ha sido tocado
    static final char barco_no_tocado = 'v';
    // Agua, disparo fallado
    static final char agua = 'a';
    // Barco tocado pero no hundido
    static final char tocado = 't';
    // Barco hundido
    static final char hundido = 'x';

    // Variable para almacenar el estado de la casilla
    private char estado;

    // METODOS FUNCIONALES
    // Constructor vacio
    public Casilla() {
    }

    // Constructor que inicializa la casilla con un estado específico.
    public Casilla(char estado) {
        this.estado = estado;
    }
    
    // Método para obtener el estado actual de la casilla
    public char getEstado() {
        return estado;
    }

    // Método para establecer un nuevo estado en la casilla.
    public void setEstado(char estado) {
        this.estado = estado;
    }
}
