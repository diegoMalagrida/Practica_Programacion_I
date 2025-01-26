package practica_final_programación_1;

/**
 *
 * @author diego
 *
 * Clase que representa una partida en el juego de batalla naval. Contiene
 * información sobre la partida, incluyendo estadísticas como la fecha, hora,
 * nombre del jugador, modo de juego y disparos realizados.
 *
 * Los atributos permiten registrar el estado completo de una partida para su
 * posterior almacenamiento o análisis.
 */
public class Partida {

    // Fecha en la que se jugó la partida
    private String fecha;
    // Hora en la que comenzó la partida
    private String hora;
    // Nombre del jugador 
    private String nombreJugador;
    // Modo de juego utilizado
    private String modoJuego;
    // Tamaño del tablero utilizado
    private String tamañoTablero;
    // Distribución de los barcos en el tablero
    private String distribucionBarcos;
    // Número de disparos que lograron hundir
    private int disparosHundidos;
    // Número de disparos que impactaron barcos pero no hundieron
    private int disparosTocados;
    // Número de disparos que no impactaron
    private int disparosAgua;
    // Número de disparos recibidos por el jugador
    private int disparosRecibidos;
    // Resultado de la partida (ture = "Victoria", false = "Derrota")
    private boolean resultado;

    // Métodos getter y setter para acceder y modificar los atributos.
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(String modoJuego) {
        this.modoJuego = modoJuego;
    }

    public String getTamañoTablero() {
        return tamañoTablero;
    }

    public void setTamañoTablero(String tamañoTablero) {
        this.tamañoTablero = tamañoTablero;
    }

    public String getDistribucionBarcos() {
        return distribucionBarcos;
    }

    public void setDistribucionBarcos(String distribucionBarcos) {
        this.distribucionBarcos = distribucionBarcos;
    }

    public int getDisparosHundidos() {
        return disparosHundidos;
    }

    public void setDisparosHundidos(int disparosHundidos) {
        this.disparosHundidos = disparosHundidos;
    }

    public int getDisparosTocados() {
        return disparosTocados;
    }

    public void setDisparosTocados(int disparosTocados) {
        this.disparosTocados = disparosTocados;
    }

    public int getDisparosAgua() {
        return disparosAgua;
    }

    public void setDisparosAgua(int disparosAgua) {
        this.disparosAgua = disparosAgua;
    }

    public int getDisparosRecibidos() {
        return disparosRecibidos;
    }

    public void setDisparosRecibidos(int disparosRecibidos) {
        this.disparosRecibidos = disparosRecibidos;
    }

    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

}
