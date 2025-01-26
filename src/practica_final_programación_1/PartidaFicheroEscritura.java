package practica_final_programación_1;

/**
 *
 * @author diego
 * 
 * Clase que permite escribir información de partidas en un archivo de texto.
 * Los datos de cada partida se generan como un array de estadísticas, donde cada
 * elemento representa un atributo de la partida. Estos datos se escriben en el 
 * archivo, separados por el delimitador `#`, para poder ser leídos posteriormente.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PartidaFicheroEscritura {

    //DECLARACIÓN ATRIBUTOS
    // Objeto para escribir datos en un archivo de texto.
    private BufferedWriter ficheroPartida = null;

    //METODOS
    //Metodo constructor
    public PartidaFicheroEscritura(String nombreFichero) throws Exception {
        // Abre un archivo de texto para escritura utilizando el nombre del archivo proporcionado.
        // Si el archivo no existe, se crea. Si existe, se sobrescribirá.
        ficheroPartida = new BufferedWriter(new FileWriter(nombreFichero));
    }

    //Metodo contructor para poder añadir cosas al fichero o sobreescribirlo
    public PartidaFicheroEscritura(String nombreFichero, boolean añadir) throws Exception {
        // Abre un archivo de texto para escritura o para añadir información al final, dependiendo del valor de `añadir`.
        // Si `añadir` es true, el archivo no se sobrescribirá, sino que se agregarán datos al final.
        // Si es false, el archivo se sobrescribirá.
        ficheroPartida = new BufferedWriter(new FileWriter(nombreFichero, añadir));
    }

    //METODOS FUNCIONALES
    // Método principal de escritura
    public void escritura(Partida partida) throws Exception {
        // Genera un array de estadísticas de la partida como objetos Linea.
        Linea[] estadisticasPartida = obtenerEstadisticasPartida(partida);
        // Escribe las estadísticas en el archivo.
        escribirLineas(estadisticasPartida);
    }

    // Método para crear las estadísticas de la partida
    private Linea[] obtenerEstadisticasPartida(Partida partida) throws Exception {
        // Crea y devuelve un array de objetos Linea, donde cada posición corresponde a un atributo de la partida.
        return new Linea[]{
            new Linea(partida.getFecha()),
            new Linea(partida.getHora()),
            new Linea(partida.getNombreJugador()),
            new Linea(partida.getModoJuego()),
            new Linea(partida.getTamañoTablero()),
            new Linea(partida.getDistribucionBarcos()),
            new Linea(Integer.toString(partida.getDisparosHundidos())),
            new Linea(Integer.toString(partida.getDisparosTocados())),
            new Linea(Integer.toString(partida.getDisparosAgua())),
            new Linea(Integer.toString(partida.getDisparosRecibidos())),
            new Linea(Boolean.toString(partida.getResultado()))
        };
    }

    // Método para escribir las líneas en el fichero
    private void escribirLineas(Linea[] estadisticasPartida) throws Exception {
        // Recorre el array de estadísticas y las escribe en el archivo.
        for (int i = 0; i < estadisticasPartida.length; i++) {
            //Escribimos en el fichero cada estadistica
            ficheroPartida.write(estadisticasPartida[i].toString());
            //Despues de cada estadistica escribimos un separador '#'
            if (i < estadisticasPartida.length - 1) {
                ficheroPartida.write('#');
            }
        }
        // Añade un salto de línea al final para separar las partidas en el archivo.
        ficheroPartida.newLine();
    }

    //método que lleva a cabo la escritura de un salto de línea en un fichero
    public void escrituraSaltoDeLinea() throws Exception {
        ficheroPartida.newLine();
    }

    //método que lleva a cabo el cierre del enlace lógico con el fichero físico
    public void cierre() throws Exception {
        ficheroPartida.close();
    }
}
