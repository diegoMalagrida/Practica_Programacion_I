package practica_final_programación_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/**
 *
 * @author diego
 *
 * Clase encargada de leer y procesar la distribución inicial de barcos desde un
 * archivo.
 *
 */
public class DistribucionBarcosLectura {

    //DECLARACIONES
    // Variable para leer el archivo con la distribución de barcos
    private BufferedReader ficheroBarco;

    // Constructor que abre el archivo especifico donde están las posiciones de los barcos
    public DistribucionBarcosLectura(String nombreArchivo) throws Exception {
        // DEPURACION PARA QUE SI SE QUIERE COMPORBAR COSAS DE MANERA FACIL E EFICAZ ESTA LINA DE CODIG
        // NOS DIRA DE DONDE SE HAN CARGADO LOS BARCOS ASI PUES SI SE DESEA SABER BASTA CON DESCOMENTAR LA LINEA.
        //System.out.println("Intentando abrir el archivo: " + nombreArchivo);
        // Abrimos el archivo para leer
        ficheroBarco = new BufferedReader(new FileReader(nombreArchivo));
    }

    // Este método lee el archivo y devuelve un array con los barcos y sus posiciones
    public Barco[] leerDistribucion(int numeroColumnas) throws Exception {
        // Creamos un array para los barcos
        Barco[] barcos = {
            new Barco(5),
            new Barco(4),
            new Barco(3),
            new Barco(3),
            new Barco(2)
        };

        // Array para registrar si ya se configuró la posición inicial de cada barco
        boolean[] barcosConfigurados = new boolean[barcos.length];

        // Empezamos en la primera fila del archivo
        int fila = 0;
        Linea linea;

        // Leemos las primeras 10 líneas del archivo
        while (fila < numeroColumnas) {
            linea = new Linea(ficheroBarco.readLine());
            // Recorremos cada carácter de la línea
            for (int columna = 0; columna < linea.numeroCaracteres(); columna++) {
                char caracter = linea.obtenerCaracter(columna);

                // Si el carácter representa un barco
                if (caracter >= '0' && caracter <= '4') {
                    int indiceBarco = caracter - '0';
                    Barco barco = barcos[indiceBarco];

                    // Si el barco aún no tiene posición inicial, la configuramos
                    if (!barcosConfigurados[indiceBarco]) {
                        boolean esHorizontal = determinarOrientacion(linea, columna, caracter);
                        barco.setPosicion(columna, fila, esHorizontal);
                        barcosConfigurados[indiceBarco] = true;
                    }
                }
            }
            fila++;
        }

        // Cerramos el archivo
        ficheroBarco.close();
        return barcos;
    }

    // Método para determinar la orientación del barco
    private boolean determinarOrientacion(Linea linea, int columna, char caracter) throws Exception {
        // Comprobamos si el barco continúa hacia la derecha o hacia abajo.
        // Si justo a la derecha hay un caracter igual al acutal es horizontal y devolveremos true
        if (columna + 1 < linea.numeroCaracteres() && linea.obtenerCaracter(columna + 1) == caracter) {
            return true;
        }
        // En caso contrario sera vertical y devolveremos false
        return false;
    }

}
