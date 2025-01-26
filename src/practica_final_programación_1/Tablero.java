package practica_final_programación_1;

import java.util.Random;

/**
 * @author diego
 *
 * Clase que representa el tablero del juego.
 *
 */
public class Tablero {
    // DECLARACIÓN ATRIBUTOS 

    // Tamaño predeterminado del tablero
    private static final int TAMAÑO_POR_DEFECTO = 10;
    // Tamaño predeterminado del tablero
    private static final int TAMAÑO_MINIMO = 4;
    // Tamaño predeterminado del tablero
    private static final int TAMAÑO_MAXIMO = 16;

    //numero de filas de el tablero
    private int NUMFILAS;
    //Numero de columnas de el tablero
    private int NUMCOLUMNAS;
    //Instancia de un array bidimenosnal de casillas que hara de tablero
    private Casilla[][] tablero;
    //Array de barcos
    private Barco[] barcos;
    private final char[] letrasColumnas = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    //METODOS CONSTRUCTORES
    //Metodo consturctor de un tablero 10x10 vacio
    public Tablero() throws Exception {
        this.NUMFILAS = TAMAÑO_POR_DEFECTO;
        this.NUMCOLUMNAS = TAMAÑO_POR_DEFECTO;
        tablero = new Casilla[NUMFILAS][NUMCOLUMNAS];
        //metodo para iniciaizar el tablero vacio (con '-')
        inicializarTablero(NUMFILAS, NUMCOLUMNAS);
    }

    //Metodo consturctor de un tablero NxM vacio
    public Tablero(int numFilas, int numColumnas) throws Exception {
        // Ajusta la dimensión si esta fuera de los límites permitidos
        this.NUMFILAS = ajustarDimension(numFilas, TAMAÑO_MINIMO, TAMAÑO_MAXIMO);
        this.NUMCOLUMNAS = ajustarDimension(numColumnas, TAMAÑO_MINIMO, TAMAÑO_MAXIMO);
        tablero = new Casilla[NUMFILAS][NUMCOLUMNAS];
        //metodo para iniciaizar el tablero vacio (con '-')
        inicializarTablero(NUMFILAS, NUMCOLUMNAS);
    }

    //METODOS FUNCIONALES
    // Metodo para ajustar la dimensión si está fuera de los límites permitidos
    private int ajustarDimension(int dimension, int minimo, int maximo) {
        // Si la dimension (numFilas || numColumnas) es menor a al minimo permitido 
        if (dimension < minimo) {
            // Mensaje usuario para saber que se han reajustado correctamente las dimensiones
            System.out.println("Valor menor al mínimo permitido (" + minimo + "). Ajustando a " + minimo + ".");
            return minimo;
        }
        // Si la dimension (numFilas || numColumnas) es mayor a al maximo permitido 
        if (dimension > maximo) {
            // Mensaje usuario para saber que se han reajustado correctamente las dimensiones
            System.out.println("Valor mayor al maximo permitido (" + maximo + "). Ajustando a " + maximo + ".");
            return maximo;
        }
        // Si esta dentro de lo permitido devolvemos la dimension
        return dimension;
    }

    // Metodo para inicializar el tablero con todas las celdas vacias '-'
    private void inicializarTablero(int NUMFILAS, int NUMCOLUMNAS) throws Exception {
        for (int i = 0; i < NUMFILAS; i++) {
            for (int j = 0; j < NUMCOLUMNAS; j++) {
                //Creamos en cada poscion del array bidmensional una estancia de casilla
                tablero[i][j] = new Casilla();
                //Asignamos el valor incial de cada casilla como vacio
                tablero[i][j].setEstado(Casilla.celdaVacia);
            }
        }
    }

    //mostrar tablero NxM
    public void mostrarTablero() throws Exception {
        //espacio inicial para que los numeros este alineados de forma correcta
        System.out.print("   ");
        // Encabezado con los números de las columnas
        for (int i = 0; i < NUMCOLUMNAS; i++) {
            // Números de 1 dígito
            if (i < 9) {
                System.out.print("  " + (i + 1) + "  ");
            } else if (i == 9) {
                // El primer número de dos dígitos
                System.out.print("  " + (i + 1) + "  ");
            } else {
                // El resto de los números de dos dígitos
                System.out.print(" " + (i + 1) + "  ");
            }
        }
        //saltor de linea
        System.out.println();
        for (int i = 0; i < NUMFILAS; i++) {
            //Impresion de las letras que represnetan cada fila (a la izquierda del tablero)
            System.out.print(" " + letrasColumnas[i] + " ");
            for (int j = 0; j < NUMCOLUMNAS; j++) {

                // Obtener el estado de la celda
                char estado = tablero[i][j].getEstado();

                // Asignar color segun el estado de la celda
                String colorBG;
                switch (estado) {
                    case Casilla.barco_no_tocado:
                        colorBG = LT.colorBG(0);
                        // Imprimir un guion en lugar de 'v'
                        estado = '-';
                        break;
                    case Casilla.tocado:
                        // Amarillo
                        colorBG = LT.colorBG(4);
                        break;
                    case Casilla.hundido:
                        // Rojo
                        colorBG = LT.colorBG(2);
                        break;
                    case Casilla.agua:
                        // Cyan
                        colorBG = LT.colorBG(7);
                        break;
                    default:
                        colorBG = LT.colorBG(0);
                        break;
                }

                // Imprimir el estado de la celda
                System.out.print(colorBG + "  " + estado + "  ");
            }
            //Impresion de las letras que representan cada fila (a la derecha del tablero)
            System.out.print(LT.colorFG(0) + LT.colorBG(0) + " " + letrasColumnas[i] + " ");
            //saltar linea
            System.out.println(LT.colorBG(0)); // Resetear color después de la línea
        }
        //espacio inicial para que los numeros este alineados de forma correcta
        System.out.print(LT.colorFG(1) + "   ");
        // Encabezado con los números de las columnas
        for (int i = 0; i < NUMCOLUMNAS; i++) {
            // Números de 1 dígito
            if (i < 9) {
                System.out.print("  " + (i + 1) + "  ");
            } else if (i == 9) {
                // El primer número de dos dígitos
                System.out.print("  " + (i + 1) + "  ");
            } else {
                // El resto de los números de dos dígitos
                System.out.print(" " + (i + 1) + "  ");
            }
        }
        // Salto de linea
        System.out.println();
        System.out.println(LT.colorFG(0));
    }

    // Método para acceder a la posición del tablero seleccionada por el jugador y comprobar el estado de la casilla seleccionada
    public void disparo(char fila, int columna, Partida partida) throws Exception {
        // Restamos la letra que nos pasan por parámetro como fila para obtener el valor en código ASCII que representa la fila indicada
        int filaIndiceTablero = fila - 'A';
        // Las columnas se indican en números naturales, pero internamente utilizamos índices de 0 a (NUMCOLUMNAS-1), por lo que restamos 1.
        int columnaIndiceTablero = columna - 1;

        // Comprobamos el estado de la casilla seleccionada y actuamos según su estado
        switch (tablero[filaIndiceTablero][columnaIndiceTablero].getEstado()) {

            case Casilla.celdaVacia:
                // Si el disparo fue a una celda vacia mostraremos al jugador "Agua"
                tablero[filaIndiceTablero][columnaIndiceTablero].setEstado(Casilla.agua);
                System.out.println("💦 ¡Agua! No has alcanzado nada... Intenta de nuevo. 💦");
                // Actualizar estadísticas partida
                partida.setDisparosAgua(partida.getDisparosAgua() + 1);
                break;

            case Casilla.barco_no_tocado:
                //Si el disapro fue a un barco no tocado lo gestionaremos
                procesarImpacto(filaIndiceTablero, columnaIndiceTablero, partida);
                break;

            // En caso de que repita coordenadas
            case Casilla.agua:
                // El jugador ha disparado a una casilla donde antes ya había agua.
                // Esto indica un disparo repetido sobre la misma posición sin resultado.
                System.out.println("🔄 Ya le diste a esta casilla y era agua. ¡Prueba otra vez! 🔄");
                break;

            case Casilla.tocado:
                // La casilla ya fue impactada previamente y pertenece a un barco dañado pero no hundido aún.
                System.out.println("⚓ Ya le diste a esta casilla y era parte de un barco. ⚓");
                break;

            case Casilla.hundido:
                // La casilla pertenece a un barco que ya está hundido. Disparo redundante.
                System.out.println("☠️ Este barco ya está hundido. Busca otro objetivo. ☠️");
                break;

            default:
                // En caso de que se reciba una coordenada inválida (fuera de los límites del tablero).
                System.out.println("Esa coordenada no se encuentra en el tablero.");
                break;
        }
    }

    private void procesarImpacto(int filaIndiceTablero, int columnaIndiceTablero, Partida partida) throws Exception {
        // Cambiamos el estado de la casilla donde se encuentra el barco a tocado
        tablero[filaIndiceTablero][columnaIndiceTablero].setEstado(Casilla.tocado);
        System.out.println("🔥 ¡Tocado! Has impactado al enemigo. 🔥");
        // Actualizar estadísticas partida
        partida.setDisparosTocados(partida.getDisparosTocados() + 1);
        // Instanciamos un obeto para poder indcar que barco es el que ha sido todacdo y poder aumentar el contador
        // de impatctos de ese barco en especifico para posteriormete comporbar si el barco esta hundido
        Barco barco = obtenerBarcoPorPosicion(filaIndiceTablero, columnaIndiceTablero);
        barco.agregarImpacto();

        // Verificamos si el barco está hundido
        if (barco.estaHundido()) {
            // Si el barco esta hundido 
            System.out.println("💥 💀 ¡Hundido! ¡Un barco enemigo ha sido destruido por completo! 💀 💥");
            partida.setDisparosHundidos(partida.getDisparosHundidos() + 1);
            // Actualizamos todas las casillas del barco hundido
            actualizarEstadoBarco(barco, Casilla.hundido);

            // Verificamos si todos los barcos están hundidos
            if (todosLosBarcosHundidos()) {
                partida.setResultado(true);
                System.out.println("¡Has ganado la partida!");
            }
        }
    }

    // Este método se encarga de actualizar todas las casillas ocupadas por un barco a un nuevo estado.
    // Se utiliza, por ejemplo, cuando un barco pasa de 'tocado' a 'hundido'.
    private void actualizarEstadoBarco(Barco barco, char estado) throws Exception {
        // Cambiamos el estado de todas las casillas del barco a hundido
        for (int i = 0; i < barco.getLongitud(); i++) {
            int filaBarco;
            int columnaBarco;
            // Dependiendo de la orientación del barco, avanzamos en fila o en columna.
            if (barco.esHorizontal()) {
                filaBarco = barco.getFilaInicio();
                columnaBarco = barco.getColumnaInicio() + i;
            } else {
                filaBarco = barco.getFilaInicio() + i;
                columnaBarco = barco.getColumnaInicio();
            }
            // Actualizamos el estado de cada casilla del barco.
            tablero[filaBarco][columnaBarco].setEstado(estado);
        }
    }

    //Metodo que comprueba que barco ocupa la posicon indicada
    private Barco obtenerBarcoPorPosicion(int fila, int columna) throws Exception {
        // Recorre todos los barcos en el tablero
        for (int i = 0; i < barcos.length; i++) {
            Barco barco = barcos[i];
            // Comprueba si el barco ocupa la posición dada
            if (barco.estaEnPosicion(fila, columna)) {
                // Devuelve el barco que ocupa la posición
                return barco;
            }
        }
        // Si ningún barco ocupa la posición devuelve null
        return null;
    }

    // Método para comprobar si todos los barcos están hundidos
    public boolean todosLosBarcosHundidos() throws Exception {
        // Si alguno de los barcos en total que tiene el tablero no esta hundido devolvera false
        for (int i = 0; i < barcos.length; i++) {
            if (!barcos[i].estaHundido()) {
                return false;
            }
        }
        // Si en cambio todos estan hundidos devuelve true
        return true;
    }

    //Metodo para cargar las posiciones de los barcos desde un fichero
    public void caragarBarcosFichero(String rutaBase, String distribucion) throws Exception {
        // Crear la ruta de la carpeta basada en el tamaño del tablero y la distribución
        String nombreCarpeta = rutaBase + "/" + NUMCOLUMNAS + '-' + NUMFILAS + '-' + distribucion;
        Random rand = new Random();
        // Generacion de el num aleatorio (Entre 0 y 99)
        int numeroAleatorio = rand.nextInt(100);

        String archivoSeleccionado = nombreCarpeta + "/" + numeroAleatorio + ".txt";

        DistribucionBarcosLectura distribucionBarcos = new DistribucionBarcosLectura(archivoSeleccionado);
        //Rellenamos el array de barcos
        barcos = distribucionBarcos.leerDistribucion(NUMCOLUMNAS);

        // Colocamos cada barco en el tablero y les asignamos el estado de no tocado
        //cambiar cosas
        for (int i = 0; i < barcos.length; i++) {
            Barco barco = barcos[i];
            actualizarEstadoBarco(barco, Casilla.barco_no_tocado);
        }
    }

    // Metodo dedicado a la colocacion completamente aleatoria de barcos en el tablero sin la intervencion de el
    // usuario
    public void colocacionAleatoriaBarcos(String distribucion) throws Exception {
        // Convertimos la distribución a un array de caracteres
        char[] distribucionArray = distribucion.toCharArray();
        int contadorNumeroBarcos = 0;
        System.out.println("Distribución recibida: " + distribucion);

        // Para construir números de longitud múltiple (como 16)
        int acumulador = 0;

        // Contar el número de barcos basado en la distribución
        for (int i = 0; i < distribucionArray.length; i++) {
            char caracterActual = distribucionArray[i];
            if (caracterActual >= '0' && caracterActual <= '9') {
                // Construimos el número de longitud del barco
                acumulador = acumulador * 10 + (caracterActual - '0');
            } else if (caracterActual == '-') {
                if (acumulador > 0) {
                    contadorNumeroBarcos++;
                }
                acumulador = 0; // Reiniciar el acumulador
            } else {
                System.out.println("Error: Caracter inválido en la distribución.");
                return;
            }
        }

        // Si al final del bucle queda un acumulador, se cuenta como un barco
        if (acumulador > 0) {
            contadorNumeroBarcos++;
        }

        System.out.println("contadorNumeroBarcos: " + contadorNumeroBarcos);

        // Inicializamos el array de barcos con el número de barcos calculado
        barcos = new Barco[contadorNumeroBarcos];

        // Reiniciar acumulador para procesar de nuevo la distribución
        acumulador = 0;
        int barcoActual = 0;

        // Procesar nuevamente la distribución para crear los barcos
        for (int i = 0; i < distribucionArray.length; i++) {
            char caracterActual = distribucionArray[i];
            if (caracterActual >= '0' && caracterActual <= '9') {
                acumulador = acumulador * 10 + (caracterActual - '0');
            } else if (caracterActual == '-') {
                if (acumulador > 0) {
                    // Crear un barco con la longitud calculada
                    barcos[barcoActual] = new Barco(acumulador);
                    System.out.println("Barco creado con longitud: " + acumulador);
                    barcoActual++;
                }
                // Reiniciar el acumulador
                acumulador = 0;
            } else {
                System.out.println("Error: Caracter inválido en la distribución.");
                return;
            }
        }

        // Si queda un acumulador pendiente al final, crear el último barco
        if (acumulador > 0) {
            barcos[barcoActual] = new Barco(acumulador);
            System.out.println("Barco creado con longitud: " + acumulador);
        }

        Random rand = new Random();
        System.out.println("Tamaño del array barcos: " + barcos.length);

        // Iterar sobre los barcos para colocarlos aleatoriamente
        for (int i = 0; i < barcos.length; i++) {
            // Generar posición inicial y orientación aleatoria
            int filaAleatoriaInicio = rand.nextInt(NUMFILAS);
            int columnaAleatoriaInicio = rand.nextInt(NUMCOLUMNAS);
            boolean orientacionAleatoria = rand.nextBoolean();

            Barco barco = barcos[i];
            barco.setPosicion(filaAleatoriaInicio - 1, columnaAleatoriaInicio - 1, orientacionAleatoria);

            // Validar la posición del barco
            while (!validarTamañoBarco(barco.getLongitud(), filaAleatoriaInicio - 1, columnaAleatoriaInicio - 1, orientacionAleatoria)
                    || !validarPosicionBarco(barco)) {
                System.out.println("Dentro del while: Condiciones aún no válidas.");
                filaAleatoriaInicio = rand.nextInt(NUMFILAS);
                columnaAleatoriaInicio = rand.nextInt(NUMCOLUMNAS);
                orientacionAleatoria = rand.nextBoolean();
                barco.setPosicion(filaAleatoriaInicio - 1, columnaAleatoriaInicio - 1, orientacionAleatoria);
            }
            // Depuración para verificar la posición final descomentar si se necestia
            // System.out.println("Colocación final: fila=" + filaAleatoriaInicio + ", columna=" + columnaAleatoriaInicio);
            colocarBarcoEnTablero(barco);
        }
    }

// Método para la colocación manual de los barcos en el tablero
    public void colocacionManualBarcos(String distribucion) throws Exception {
        // Convertimos la distribución en un array de caracteres para procesarla
        char[] distribucionArray = distribucion.toCharArray();
        int contadorNumeroBarcos = 0;

        // Variable acumuladora para manejar números de longitud múltiple (como 16)
        int acumulador = 0;

        // Contar el número de barcos basado en la distribución
        for (int i = 0; i < distribucionArray.length; i++) {
            char caracterActual = distribucionArray[i];
            if (caracterActual >= '0' && caracterActual <= '9') {
                // Construimos el número completo (para barcos de longitud mayor a 1 dígito)
                acumulador = acumulador * 10 + (caracterActual - '0');
            } else if (caracterActual == '-') {
                // Al encontrar un separador, contamos el barco acumulado
                if (acumulador > 0) {
                    contadorNumeroBarcos++;
                }
                // Reiniciamos el acumulador
                acumulador = 0;
            } else {
                // Si encontramos un carácter inválido, mostramos un error y salimos
                System.out.println("Error: Caracter inválido en la distribución.");
                return;
            }
        }

        // Si al final queda un número pendiente en el acumulador, lo contamos como un barco
        if (acumulador > 0) {
            contadorNumeroBarcos++;
        }

        // Inicializamos el array de barcos si aún no está inicializado
        if (barcos == null) {
            barcos = new Barco[contadorNumeroBarcos];
        }

        System.out.println("Introduce las coordenadas iniciales y orientación (H o V) de cada barco según la distribución:");
        // Índice del barco que estamos configurando
        int barcoActual = 0;
        // Reiniciar acumulador para procesar nuevamente la distribución
        acumulador = 0;

        // Recorremos la distribución y colocamos los barcos uno a uno
        for (int i = 0; i < distribucionArray.length && barcoActual < contadorNumeroBarcos; i++) {
            char caracter = distribucionArray[i];

            // Construir la longitud del barco
            if (caracter >= '0' && caracter <= '9') {
                acumulador = acumulador * 10 + (caracter - '0');
            } else if (caracter == '-' || i == distribucionArray.length - 1) {
                // Si encontramos un separador o estamos en el último carácter
                if (caracter != '-' && i == distribucionArray.length - 1) {
                    acumulador = acumulador * 10 + (caracter - '0');
                }
                // Longitud del barco actual
                int longitudBarco = acumulador;
                // Reiniciamos el acumulador
                acumulador = 0;

                System.out.println("Barco " + (barcoActual + 1) + ": ");

                // Pedimos al usuario las coordenadas iniciales del barco
                System.out.print("Introduce la posición inicial de tu barco: ");
                // Leer entrada del usuario
                String entrada = LT.readLine();
                char[] coordenadas = entrada.toCharArray();
                char filaCaracter = coordenadas[0];
                // Convertir fila a índice numérico
                int fila = filaCaracter - 'A';
                int columna;

                // Convertir columna de la entrada (manejar dígitos únicos o dobles)
                if (coordenadas.length == 2) {
                    columna = coordenadas[1] - '0';
                } else {
                    columna = (coordenadas[1] - '0') * 10 + (coordenadas[2] - '0');
                }
                // Ajustar a índice de array
                columna -= 1;

                // Pedimos al usuario la orientación del barco
                System.out.print("Orientación (1 para horizontal, 0 para vertical): ");
                boolean esHorizontal = LT.readInt() == 1;
                LT.skipLine();

                // Creamos el barco con la longitud especificada
                Barco barco = new Barco(longitudBarco);
                barco.setPosicion(fila, columna, esHorizontal);

                // Validamos que la posición sea válida y colocamos el barco
                if (validarTamañoBarco(longitudBarco, fila, columna, esHorizontal) && validarPosicionBarco(barco)) {
                    barcos[barcoActual] = barco;
                    colocarBarcoEnTablero(barco);
                    // Pasamos al siguiente barco
                    barcoActual++;
                } else {
                    System.out.println("Posición inválida. Intenta nuevamente.");
                }
            }
        }

        // Si al terminar queda un barco pendiente, lo procesamos
        if (acumulador > 0 && barcoActual < contadorNumeroBarcos) {
            int longitudBarco = acumulador;

            System.out.println("Barco " + (barcoActual + 1) + ": ");
            System.out.print("Introduce la posición inicial de tu barco: ");
            String entrada = LT.readLine(); // Leer posición del usuario
            char[] coordenadas = entrada.toCharArray();
            char filaCaracter = coordenadas[0];
            int fila = filaCaracter - 'A';
            int columna;

            // Convertir columna
            if (coordenadas.length == 2) {
                columna = coordenadas[1] - '0';
            } else {
                columna = (coordenadas[1] - '0') * 10 + (coordenadas[2] - '0');
            }
            columna -= 1;

            System.out.print("Orientación (1 para horizontal, 0 para vertical): ");
            boolean esHorizontal = LT.readInt() == 1;
            LT.skipLine();

            // Creamos el barco y validamos su posición
            Barco barco = new Barco(longitudBarco);
            barco.setPosicion(fila, columna, esHorizontal);

            if (validarTamañoBarco(longitudBarco, fila, columna, esHorizontal) && validarPosicionBarco(barco)) {
                barcos[barcoActual] = barco;
                colocarBarcoEnTablero(barco);
            } else {
                System.out.println("Posición inválida. Intenta nuevamente.");
            }
        }
    }

    // Validar si la distribución del barco cabe en el tablero
    private boolean validarTamañoBarco(int longitudBarco, int fila, int columna, boolean esHorizontal) {
        // Verifica si el barco cabe horizontalmente o verticalmente según su orientación
        if (esHorizontal) {
            // Comprueba horizontalmente
            return (columna + longitudBarco) <= NUMCOLUMNAS;
        } else {
            // Comprueba verticalmente
            return (fila + longitudBarco) <= NUMFILAS;
        }
    }

    // Validar si el barco no se superpone ni sale del tablero
    private boolean validarPosicionBarco(Barco barco) {
        // Obtiene las coordenadas iniciales del barco
        int fila = barco.getFilaInicio();
        int columna = barco.getColumnaInicio();

        // Recorre cada casilla que ocupará el barco según su longitud
        for (int i = 0; i < barco.getLongitud(); i++) {
            int filaActual;
            int columnaActual;

            // Calcula las coordenadas de la casilla actual según la orientación del barco
            if (barco.esHorizontal()) {
                // La fila no cambia para barcos horizontales
                filaActual = fila;
                // Avanza por las columnas
                columnaActual = columna + i;
            } else {
                // Avanza por las filas para barcos verticales
                filaActual = fila + i;
                // La columna no cambia
                columnaActual = columna;
            }

            // Verifica que las coordenadas actuales estén dentro de los límites del tablero
            if (filaActual >= NUMFILAS || columnaActual >= NUMCOLUMNAS || filaActual < 0 || columnaActual < 0) {
                System.out.println("Posición fuera de límites: fila=" + filaActual + ", columna=" + columnaActual);
                // El barco se sale del tablero
                return false;
            }

            // Verifica que la casilla actual esté vacía
            if (tablero[filaActual][columnaActual].getEstado() != Casilla.celdaVacia) {
                System.out.println("Posición ocupada: fila=" + filaActual + ", columna=" + columnaActual);
                // La casilla ya está ocupada
                return false;
            }
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    // Colocar el barco en el tablero
    private void colocarBarcoEnTablero(Barco barco) {
        // Obtiene las coordenadas iniciales, longitud y orientación del barco
        int filaInicio = barco.getFilaInicio();
        int columnaInicio = barco.getColumnaInicio();
        int longitud = barco.getLongitud();
        boolean esHorizontal = barco.esHorizontal();

        // Variables para la posición actual durante la colocación
        int filaActual = filaInicio;
        int columnaActual = columnaInicio;

        // Recorre la longitud del barco para colocar cada casilla
        for (int i = 0; i < longitud; i++) {
            // Actualiza el estado de la casilla actual a "barco no tocado"
            tablero[filaActual][columnaActual].setEstado(Casilla.barco_no_tocado);

            // Si el barco es horizontal, avanzamos en las columnas
            // Si es vertical, avanzamos en las filas
            if (esHorizontal) {
                columnaActual++;
            } else {
                filaActual++;
            }
        }
    }

    // Metodos get para obtener las filas y columnas de un objeto tablero
    public int getNUMFILAS() {
        return NUMFILAS;
    }

    public int getNUMCOLUMNAS() {
        return NUMCOLUMNAS;
    }

}
