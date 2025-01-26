package practica_final_programación_1;

/**
 *
 * @author diego
 * 
 * Clase que permite leer información de partidas almacenadas en un archivo de texto.
 * Cada partida está representada por una línea en el archivo, con los datos
 * separados por el delimitador `#`.
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class PartidaFicheroLectura {

    //DECLARACIÓN ATRIBUTOS
    // Objeto para leer las líneas de un archivo.
    private BufferedReader fichero;

    //METODOS
    //Metodo constructor
    public PartidaFicheroLectura(String nombreArchivo) throws Exception {
        fichero = new BufferedReader(new FileReader(nombreArchivo));
    }

    //METODOS FUNCIONALES
    //Metodo que lleva a cabo la lecutra de una partida escrita en un fichero
    public Partida lectura() throws Exception {
        //Leemos una linea del archivo, si no hay mas lineas retorna null
        String lineaTexto = fichero.readLine();
        if (lineaTexto == null) {
            return null;
        }

        //Instanciamos un objeto linea que contenga la linea leida del fichero
        Linea linea = new Linea(lineaTexto);
        // Inicializa un array de objetos Linea para almacenar las estadísticas de la partida.
        Linea[] estadisticasPartida = inicializarEstadisticasPartida(11);
        //Establecemos en cada posicon del array la estadistica deseada
        procesarEstadisticas(linea, estadisticasPartida);
        // Crea y retorna un objeto Partida utilizando las estadísticas procesadas.
        return crearPartidaDesdeEstadisticas(estadisticasPartida);
    }

    // Método para inicializar un array de objetos Linea.
    private Linea[] inicializarEstadisticasPartida(int tamaño) throws Exception {
        // Crea un array de Linea con el tamaño especificado.
        Linea[] estadisticas = new Linea[tamaño];
        // Inicializa cada posición del array con un nuevo objeto Linea.
        for (int i = 0; i < tamaño; i++) {
            estadisticas[i] = new Linea();
        }
        return estadisticas;
    }

    // Método para procesar una línea de texto y descomponerla en estadísticas individuales.
    private void procesarEstadisticas(Linea linea, Linea[] estadisticasPartida) throws Exception {
        //indice actual del array de estadisticas
        int estadisticaActual = 0;
        for (int i = 0; i < linea.numeroCaracteres(); i++) {
            char actual = linea.obtenerCaracter(i);
            //Si el caracter acutal leido es el delimitador aumentamos en uno la estadsitica acutal
            //para continuar esribiendo la siguiente estadistica
            //Sino añadimos el carcter actual obtenido a la estadsitica actual
            if (actual == '#') {
                estadisticaActual++;
            } else {
                estadisticasPartida[estadisticaActual].adicionCaracter(actual);
            }
        }
    }

    // Método para crear un objeto Partida utilizando un array de estadísticas.
    private Partida crearPartidaDesdeEstadisticas(Linea[] estadisticasPartida) throws Exception {
        // Crear y rellenar un objeto Partida con los datos leídos
        Partida partida = new Partida();
        partida.setFecha(estadisticasPartida[0].toString());
        partida.setHora(estadisticasPartida[1].toString());
        partida.setNombreJugador(estadisticasPartida[2].toString());
        partida.setModoJuego(estadisticasPartida[3].toString());
        partida.setTamañoTablero(estadisticasPartida[4].toString());
        partida.setDistribucionBarcos(estadisticasPartida[5].toString());
        partida.setDisparosHundidos(Integer.parseInt(estadisticasPartida[6].toString()));
        partida.setDisparosTocados(Integer.parseInt(estadisticasPartida[7].toString()));
        partida.setDisparosAgua(Integer.parseInt(estadisticasPartida[8].toString()));
        partida.setDisparosRecibidos(Integer.parseInt(estadisticasPartida[9].toString()));
        partida.setResultado(Boolean.parseBoolean(estadisticasPartida[10].toString()));
        //Retornamos la partida
        return partida;
    }

    // Método para cerrar el archivo.
    public void cerrar() throws Exception {
        if (fichero != null) {
            fichero.close();
        }
    }
}
