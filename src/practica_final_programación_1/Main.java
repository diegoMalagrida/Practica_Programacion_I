package practica_final_programación_1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * La clase Main es el punto de entrada del juego "Hundir la Flota" implementado en Java.
 * Esta clase gestiona la interacción con el usuario a través de menús en la consola,
 * permitiendo seleccionar diferentes modos de juego, configurar el tablero y acceder
 * a registros y estadísticas de partidas anteriores.
 *
 * Manual de Uso
 * --------------
 *
 * Inicio del Programa:
 * 1. Ejecución:
 *    - Ejecuta la clase Main.
 *    - Asegúrate de que todos los archivos necesarios están en el mismo directorio
 *      o en el classpath adecuado.
 *
 * 2. Menú Principal:
 *    Al iniciar, se presentará el siguiente menú principal:
 *
 *    ***************************************************
 *                      MENÚ PRINCIPAL
 *    ***************************************************
 *    1. JUGAR
 *    2. REGISTRO
 *    s. SALIR
 *
 *    Opciones Disponibles:
 *    - Opción 1: JUGAR. Permite iniciar una nueva partida.
 *    - Opción 2: REGISTRO. Accede a detalles y estadísticas de partidas anteriores.
 *    - Opción s: SALIR. Cierra el juego.
 *
 * Opciones de Juego:
 * ------------------
 *
 * 1. Seleccionar Modo de Juego:
 *    Al elegir la opción JUGAR, se mostrará un submenú con las siguientes opciones:
 *
 *    ***************************************************
 *                        MENÚ JUGAR
 *    ***************************************************
 *    1. Jugar solo
 *    2. Jugar contra otro jugador
 *    3. Jugar contra el ordenador
 *    s. Volver al menú principal
 *
 *    Modos Disponibles:
 *    - Opción 1: Jugar solo. Enfréntate a un tablero rival.
 *    - Opción 2: Jugar contra otro jugador. Compite contra otro usuario local.
 *    - Opción 3: Jugar contra el ordenador. Juega contra una inteligencia artificial.
 *    - Opción s: Volver al menú principal. Regresa al menú principal.
 *
 * 2. Configuración del Tablero:
 *    Independientemente del modo seleccionado, se procederá a configurar el tablero.
 *
 *    Distribución de Barcos:
 *    - Opción 1: Usar la distribución predeterminada (5-4-3-3-2).
 *    - Opción 2: Definir una distribución personalizada ingresando una secuencia
 *                como 5-4-3-2-1.
 *
 *    Tamaño del Tablero:
 *    - Opción 1: Tablero convencional de 10x10.
 *    - Opción 2: Tablero con dimensiones personalizadas introduciendo el número
 *                de filas y columnas.
 *
 *    Colocación de Barcos:
 *    - Opción 1: Cargar la distribución de barcos desde un archivo predefinido.
 *    - Opción 2: Colocar los barcos manualmente ingresando las coordenadas y orientaciones.
 *    - Opción 3: Distribuir los barcos aleatoriamente en el tablero.
 *
 * 3. Realización de Disparos:
 *    Una vez configurado el tablero, se procederá a la fase de disparos.
 *
 *    Formato de Coordenadas:
 *    - Las coordenadas deben ingresarse en formato como A5 o B10, donde la letra
 *      representa la fila y el número la columna.
 *
 *    Proceso de Disparo:
 *    - Introduce las coordenadas donde deseas disparar.
 *    - El sistema actualizará el estado del tablero y notificará si el disparo fue
 *      Agua, Tocado o Hundido.
 *    - Continúa realizando disparos hasta que todos los barcos del oponente estén hundidos.
 *
 *    Turnos en Modo Multiplayer:
 *    - En partidas contra otro jugador, se alternarán los turnos entre los jugadores
 *      hasta que uno de ellos gane.
 *
 *    Turnos en Modo CPU:
 *    - En partidas contra la CPU, el jugador realizará su disparo primero, seguido
 *      de la CPU generando un disparo aleatorio.
 *
 * Registro y Estadísticas:
 * -------------------------
 *
 * 1. Acceder al Registro de Partidas:
 *    Al seleccionar la opción REGISTRO en el menú principal, se presentarán las siguientes opciones:
 *
 *    ***************************************************
 *                       MENÚ REGISTRO
 *    ***************************************************
 *    1. Mostrar detalles de las partidas
 *    2. Mostrar estadísticas de un jugador
 *    s. Volver al menú principal
 *
 *    Opciones Disponibles:
 *    - Opción 1: Mostrar detalles de las partidas. Visualiza un historial completo
 *                de todas las partidas jugadas, incluyendo fecha, hora, modo de juego,
 *                resultados y estadísticas de disparos.
 *    - Opción 2: Mostrar estadísticas de un jugador. Introduce el nombre de un jugador
 *                para ver estadísticas específicas como el número de partidas jugadas,
 *                porcentaje de victorias, promedio de disparos exitosos y fallidos.
 *    - Opción s: Volver al menú principal. Regresa al menú principal.
 *
 * 2. Filtros en Estadísticas:
 *    Al visualizar las estadísticas de un jugador, puedes aplicar filtros adicionales
 *    para refinar los resultados.
 *
 *    - Filtro por Modo de Juego: Solitario, Jugador vs Jugador o Contra la CPU.
 *    - Filtro por Tamaño del Tablero: Dimensiones específicas del tablero.
 *    - Filtro por Distribución de Barcos: Configuración de los barcos utilizados
 *      en las partidas.
 *
 * Finalización del Juego:
 * -----------------------
 * Para cerrar el juego, selecciona la opción SALIR en el menú principal.
 * El programa finalizará mostrando un mensaje de despedida.
 *
 * Notas Adicionales:
 * ------------------
 * - Validación de Entradas: El sistema valida todas las entradas del usuario
 *   para asegurar que sean correctas y estén dentro de los límites del tablero.
 *   En caso de entradas inválidas, se solicitará al usuario que las corrija.
 *
 * - Persistencia de Datos: Todas las partidas jugadas se registran automáticamente
 *   en un archivo de texto llamado RegistroPartidas.txt para su posterior consulta.
 *
 * - Personalización del Tablero: Se puede personalizar tanto la distribución de los
 *   barcos como las dimensiones del tablero para variar la dificultad y la experiencia
 *   de juego.
 *
 * Historial de Versiones:
 * -----------------------
 * 
 * Autor: Diego
 * Versión: 1.0
 */

public class Main {

    //DECLARACIONES 
    // Variable global tipo String para guardar la distrubucion con la que se jugara una partida
    private static String distribucion;
    // Ruta para poder cargar los barcos en el tablero desde un fichero
    private static final String RUTA_TAULERS = "D:\\UNI\\PROGRAMACION\\Practica_Final_Programación_1\\taulers";

    // Metodo principal en el cual se ejecuta un menu para poder escojer entre las opciones implementadas disponilbes
    public static void main(String[] args) throws Exception {
        // Variable para almacenar la opcion escogida por el usuario
        char opcion;
        do {
            // Menu principal
            System.out.println("\n***************************************************");
            System.out.println("                 MENÚ PRINCIPAL                    ");
            System.out.println("***************************************************");
            System.out.println("1. 🕹️ JUGAR");
            System.out.println("2. 📋 REGISTRO");
            System.out.println("s. ❌ SALIR");
            System.out.print("\nSeleccione una opción: ");

            opcion = LT.readChar();
            LT.skipLine();

            switch (opcion) {
                case '1':
                    // Variable para almacenar la opcion escogida por el usuario
                    char opcionJugar;
                    do {
                        // Sub-Menu Jugar
                        System.out.println("\n***************************************************");
                        System.out.println("                  MENÚ JUGAR                      ");
                        System.out.println("***************************************************");
                        System.out.println("1. 🤸 Jugar solo.");
                        System.out.println("2. 👥 Jugar contra otro jugador.");
                        System.out.println("3. 🤖 Jugar contra el ordenador.");
                        System.out.println("s. 🔙 Volver al menú principal.");
                        System.out.print("\nSeleccione una opción: ");

                        opcionJugar = LT.readChar();
                        LT.skipLine();
                        // Dependiendo de la opcion imprime la opcion selecionada y llama a un suubrpograma
                        switch (opcionJugar) {
                            case '1':
                                System.out.println("\n⚔️ Partida en solitario iniciada...");
                                partidaEnSolitario();
                                break;
                            case '2':
                                System.out.println("\n👥 Partida contra otro jugador iniciada...");
                                partidaContraOtroJugador();
                                break;
                            case '3':
                                System.out.println("\n🤖 Partida contra el ordenador iniciada...");
                                partidaContraCpu();
                                break;
                            case 's':
                                System.out.println("\n🔙 Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("\n⚠️ Opción incorrecta. Intente de nuevo.");
                        }
                    } while (opcionJugar != 's');
                    break;
                case '2':
                    // Variable para almacenar la opcion escogida por el usuario
                    char opcionRegistro;

                    do {
                        // Sub-Menu Registro
                        System.out.println("\n***************************************************");
                        System.out.println("                  MENÚ REGISTRO                   ");
                        System.out.println("***************************************************");
                        System.out.println("1. 📜 Mostrar detalles de las partidas.");
                        System.out.println("2. 📊 Mostrar estadísticas de un jugador.");
                        System.out.println("s. 🔙 Volver al menú principal.");
                        System.out.print("\nSeleccione una opción: ");

                        opcionRegistro = LT.readChar();
                        LT.skipLine();
                        // Dependiendo de la opcion imprime la opcion selecionada y llama a un suubrpograma
                        switch (opcionRegistro) {
                            case '1':
                                System.out.println("\n📜 Mostrando detalles de las partidas...");
                                mostrarDetallesPartidas();
                                break;
                            case '2':
                                System.out.println("\n📊 Mostrando estadísticas del jugador...");
                                mostrarEstadisticasJugador();
                                break;
                            case 's':
                                System.out.println("\n🔙 Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("\n⚠️ Opción incorrecta. Intente de nuevo.");
                        }
                    } while (opcionRegistro != 's');
                    break;
                case 's':
                    // Sale del progorama
                    System.out.println("\n❌ Programa finalizado. Espero que hayas disfrutado.");
                    break;
                default:
                    System.out.println("\n⚠️ Opción incorrecta. Por favor, elija una opción válida.");
            }
            // Mientras el usuario no salga del programa seguiremos en el 
        } while (opcion != 's');
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                  LÓGICA DE CADA TIPO DE PARTIDA                                                       //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Metodo partidaEnSolitario que permite al usuario jugar una partida en solitario contra un tablero rival
    private static void partidaEnSolitario() throws Exception {
        // Variable para almacenar el nombre del usuario
        String nombre;
        System.out.print("Introduce tu nombre: ");
        nombre = LT.readLine();
        // Instancia del tablero rival y llamada a subprograma dedicado a presonalizar o no el tablero
        Tablero tablero = configurarTablero(nombre);
        int numFilas = tablero.getNUMFILAS();
        int numColumnas = tablero.getNUMCOLUMNAS();
        String tamañoTablero = numFilas + "x" + numColumnas;
        System.out.println("Configuracion del tablero finalizada, este es el tablero: ");
        // Mostramos el tablero debidamente configurado
        tablero.mostrarTablero();
        System.out.println();
        // Llamada al subprograma que se encarga de iniciar el juego en el caso de partida en solitario
        iniciarElJuego(true, nombre, tablero, distribucion, tamañoTablero);
    }

    // Metodo partidaContraOtroJugador que permite al usuario jugar una partida contra otro rival
    private static void partidaContraOtroJugador() throws Exception {
        // Variablres para almacenar los nombres de los jugadores
        String jugador1, jugador2;
        System.out.print("Jugador 1 introduce tu nombre: ");
        jugador1 = LT.readLine();
        // Instancia de tablero para el jugador 1 y llamada al subprograma encargado de personaizar o no el tablero
        Tablero tableroJugador1 = configurarTablero(jugador1);
        int numFilasJugador1 = tableroJugador1.getNUMFILAS();
        int numColumnasJugador1 = tableroJugador1.getNUMCOLUMNAS();
        String tamañoTableroJugador1 = numFilasJugador1 + "x" + numColumnasJugador1;
        System.out.println();
        System.out.print("Jugador 2 introduce tu nombre: ");
        jugador2 = LT.readLine();
        // Instancia de tablero para el jugador 2 y llamada al subprograma encargado de personaizar o no el tablero
        Tablero tableroJugador2 = configurarTablero(jugador2);
        int numFilasJugador2 = tableroJugador2.getNUMFILAS();
        int numColumnasJugador2 = tableroJugador2.getNUMCOLUMNAS();
        String tamañoTableroJugador2 = numFilasJugador2 + "x" + numColumnasJugador2;
        // Instancias de Partida para almacenar las partidas de cada jugador
        Partida partidaJugador1 = new Partida();
        Partida partidaJugador2 = new Partida();

        // Llamada al metodo encargado de configurar detalles iniciales para cada partida
        configurarDetallesPartida(partidaJugador1, jugador1, "Jugador vs Jugador", tamañoTableroJugador1);
        configurarDetallesPartida(partidaJugador2, jugador2, "Jugador vs Jugador", tamañoTableroJugador2);
        // Variable para gestionar logica del juego
        boolean juegoActivo = true;
        // Variable encargadad de decidir si es el turno de el jugador 1 o 2 
        // NOTA: Siempre empieza el jugador 1
        boolean turnoJugador1 = true;
        // Mientras el juego este acitvo (los barcos de algun jugador no esten todos hundidos)
        while (juegoActivo) {
            // Instancias de tablero y partida y string para indicar que nombre/tablero/partida se esta gestionando
            // en cada turno
            String jugadorActual;
            Tablero tableroOponente;
            Partida partidaActual;
            // Gestion de cada turno
            if (turnoJugador1) {
                jugadorActual = jugador1;
                tableroOponente = tableroJugador2;
                partidaActual = partidaJugador1;
            } else {
                jugadorActual = jugador2;
                tableroOponente = tableroJugador1;
                partidaActual = partidaJugador2;
            }
            // Llamada al metodo encargado de ejecutar cada turno
            ejecutarTurnoJugadorVsJugador(jugadorActual, tableroOponente, partidaActual);
            // Si el tablero que se esta usando tiene toods los barcos hundidos
            if (tableroOponente.todosLosBarcosHundidos()) {
                // Mensaje de win para el jugador que estaba jugando contra ese tablero
                System.out.println("¡Felicidades " + jugadorActual + ", has ganado!");
                // Terminamos el bucle
                juegoActivo = false;
                // Dependiendo del ganador guradamos el resultado deseado en cada instancia de partida
                if (turnoJugador1) {
                    partidaJugador1.setResultado(true);
                    partidaJugador2.setResultado(false);
                } else {
                    partidaJugador1.setResultado(false);
                    partidaJugador2.setResultado(true);
                }
                // Si no estan todos hundidos no ha ganado asi que es el turno del otro jugador   
            } else {
                turnoJugador1 = !turnoJugador1;
            }
        }

        // Guardar ambas partidas en el archivo al finalizar
        guardarPartida(partidaJugador1);
        guardarPartida(partidaJugador2);
    }

    // Metodo partidaContraCpu que permite al usuario jugar una partida contra una IA de nombre CPU
    private static void partidaContraCpu() throws Exception {
        // Nombre del jugador
        System.out.print("Introduce tu nombre: ");
        String nombreJugador = LT.readLine();

        // Configurar el tablero del jugador humano
        Tablero tableroHumano = configurarTablero(nombreJugador);
        int numFilasTableroJugador = tableroHumano.getNUMFILAS();
        int numColumnasTableroJugador = tableroHumano.getNUMCOLUMNAS();
        String tamañoTableroJugador = numFilasTableroJugador + "x" + numColumnasTableroJugador;

        // Configurar el tablero de la IA (nombre "CPU")
        String nombreCPU = "CPU";
        Tablero tableroCPU = configurarTablero(nombreCPU);
        int numFilasCPU = tableroCPU.getNUMFILAS();
        int numColumnasCPU = tableroCPU.getNUMCOLUMNAS();
        String tamañoTableroCPU = numFilasCPU + "x" + numColumnasCPU;

        // Crear las partidas para humano y CPU
        Partida partidaJugador = new Partida();
        configurarDetallesPartida(partidaJugador, nombreJugador, "Contra el ordenador", tamañoTableroJugador);

        Partida partidaCPU = new Partida();
        configurarDetallesPartida(partidaCPU, nombreCPU, "Contra el ordenador", tamañoTableroCPU);

        boolean juegoActivo = true;
        boolean turnoJugador = true;
        // Numero total de celdas disponible en el tablero del jugador
        int totalCeldas = numFilasTableroJugador * numColumnasTableroJugador;
        // Array unidimensional para marcar disparos de la CPU
        boolean[] disparosRealizadosCPU = new boolean[totalCeldas];
        while (juegoActivo) {
            if (turnoJugador) {
                boolean disparoValido = false;

                while (!disparoValido && juegoActivo) {
                    System.out.println("Turno de " + nombreJugador + ".");
                    tableroCPU.mostrarTablero();
                    System.out.print("Introduce la coordenada donde quieres disparar (ejemplo: B5): ");
                    String entrada = LT.readLine();

                    // Validar y procesar el disparo del Jugador
                    if (validarCoordenadas(entrada, tableroCPU.getNUMFILAS(), tableroCPU.getNUMCOLUMNAS())) {
                        // Si la coordenada es válida, hacemos el disparo
                        disparoValido = true;

                        char[] caracteres = entrada.toCharArray();
                        char fila = caracteres[0];
                        int columna;
                        if (caracteres.length == 2) {
                            columna = caracteres[1] - '0';
                        } else {
                            columna = (caracteres[1] - '0') * 10 + (caracteres[2] - '0');
                        }

                        // Realizar el disparo y actualizar estadísticas
                        tableroCPU.disparo(fila, columna, partidaJugador);
                        partidaJugador.setDisparosRecibidos(partidaJugador.getDisparosRecibidos() + 1);
                        tableroCPU.mostrarTablero();

                        // Comprobar si el jugador ha ganado
                        if (tableroCPU.todosLosBarcosHundidos()) {
                            System.out.println("¡Felicidades " + nombreJugador + ", has ganado!");
                            juegoActivo = false;
                            partidaJugador.setResultado(true);
                            partidaCPU.setResultado(false);
                        } else {
                            // Si no ha ganado, al terminar su disparo pasa el turno a la CPU
                            turnoJugador = false;
                        }

                    } else {
                        // Si la coordenada es inválida, mostrámos mensaje 
                        // y NO cambiamos el turno. Repite el bucle hasta ser válida.
                        System.out.println("Coordenada inválida, por favor inténtalo de nuevo.");
                    }
                }
            } else {
                // TURNO DE LA CPU
                System.out.println("Turno de " + nombreCPU + ".");
                tableroHumano.mostrarTablero(); // Mostrar el tablero del jugador

                // Generar una coordenada aleatoria que no haya sido usada
                int celda;
                do {
                    celda = (int) (Math.random() * totalCeldas);
                } while (disparosRealizadosCPU[celda]);
                // Marcamos en el array la celda como ya disparada
                disparosRealizadosCPU[celda] = true;

                // Convertir la celda en coordenadas fila y columna
                int filaCPU = celda / numColumnasTableroJugador;
                int columnaCPU = celda % numColumnasTableroJugador;
                char filaChar = (char) ('A' + filaCPU);
                int columnaNum = columnaCPU + 1;

                // Registrar el disparo de la CPU
                tableroHumano.disparo(filaChar, columnaNum, partidaCPU);
                partidaCPU.setDisparosRecibidos(partidaCPU.getDisparosRecibidos() + 1);
                tableroHumano.mostrarTablero();

                // Comprobar si la CPU ha ganado
                if (tableroHumano.todosLosBarcosHundidos()) {
                    System.out.println("La CPU ha hundido todos tus barcos. ¡Has perdido!");
                    juegoActivo = false;
                    partidaJugador.setResultado(false);
                    partidaCPU.setResultado(true);
                } else {
                    // Cambiar el turno al jugador
                    turnoJugador = true;
                }
            }
        }

        // Guardar las partidas
        guardarPartida(partidaJugador);
        guardarPartida(partidaCPU);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                       MÉTODOS PARA LA EJECUCIÓN DE TURNOS DEL JUGADOR                                          //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Método para iniciar el juego en modo solitario
    private static void iniciarElJuego(boolean jugar, String nombre, Tablero tablero, String distribucion, String tamañoTablero) throws Exception {
        // Mostrar de quién es el turno al inicio del juego
        System.out.println("Turno de " + nombre + ".");

        // Crear una nueva instancia de la clase Partida para registrar los detalles de la partida
        Partida partida = new Partida();

        // Configurar los detalles iniciales de la partida 
        configurarDetallesPartida(partida, nombre, "Solitario", tamañoTablero);

        // Bucle principal del juego
        while (jugar) {
            // Solicitar al jugador que introduzca una coordenada para disparar
            System.out.print("Introduce la coordenada donde quieres disparar (ejemplo: B5): ");
            String entrada = LT.readLine();
            // Validar si las coordenadas introducidas son correctas
            if (validarCoordenadas(entrada, tablero.getNUMFILAS(), tablero.getNUMCOLUMNAS())) {

                // Convertir la entrada en un array de caracteres para procesar fila y columna
                char[] caracteres = entrada.toCharArray();

                // Almacenamos la fila que se encuentra en la pos 0 del array
                char fila = caracteres[0];
                int columna;
                // Si el tamaño del array es igual a 2 es una cooredenada del tipo A1 asi que asignamos al columna 
                // la pos 1 del array
                if (caracteres.length == 2) {
                    columna = caracteres[1] - '0';
                } else {
                    // Si no asignamos a columna la pos 1 y 2 del array la 1 la desplazamos una vez a la izquierda y la 2
                    // la concatenamos con la 1
                    columna = (caracteres[1] - '0') * 10 + (caracteres[2] - '0');
                }

                // Realizar el disparo en el tablero y actualizar la partida
                tablero.disparo(fila, columna, partida);

                // Mostrar el estado actual del tablero después del disparo
                tablero.mostrarTablero();

                // Comprobar si el jugador ha ganado
                if (partida.getResultado()) {
                    // Mensaje de victoria
                    System.out.println("¡Felicidades " + nombre + ", has ganado!");
                    // Finalizar el bucle del juego
                    jugar = false;
                }
            } else {
                System.out.println("Introduce una coordenada válida.");
            }
        }

        // Guardar los resultados de la partida en un archivo txt
        guardarPartida(partida);
    }

// Método para ejecutar el turno de un jugador contra otro jugador
    private static void ejecutarTurnoJugadorVsJugador(String jugadorActual, Tablero tableroOponente, Partida partidaActual) throws Exception {
        boolean disparoValido = false;
        while (!disparoValido) {
            // Mostrar mensaje indicando de quién es el turno
            System.out.println("Turno de " + jugadorActual + ".");
            // Mostrar el tablero del oponente al jugador actual
            tableroOponente.mostrarTablero();
            // Solicitar al jugador que introduzca una coordenada para disparar
            System.out.print("Introduce la coordenada donde quieres disparar (ejemplo: B5): ");
            String entrada = LT.readLine();

            if (validarCoordenadas(entrada, tableroOponente.getNUMFILAS(), tableroOponente.getNUMCOLUMNAS())) {
                // Convertir la entrada en un array de caracteres para procesar fila y columna
                char[] caracteres = entrada.toCharArray();
                // Almacenamos la fila que se encuentra en la pos 0 del array
                char fila = caracteres[0];
                int columna;
                // Si el tamaño del array es igual a 2 es una cooredenada del tipo A1 asi que asignamos al columna 
                // la pos 1 del array
                if (caracteres.length == 2) {
                    columna = caracteres[1] - '0';
                } else {
                    // Si no asignamos a columna la pos 1 y 2 del array la 1 la desplazamos una vez a la izquierda y la 2
                    // la concatenamos con la 1
                    columna = (caracteres[1] - '0') * 10 + (caracteres[2] - '0');
                }
                // Registrar el disparo en el tablero del oponente
                tableroOponente.disparo(fila, columna, partidaActual);

                // Incrementar el contador de disparos recibidos en la partida actual
                partidaActual.setDisparosRecibidos(partidaActual.getDisparosRecibidos() + 1);

                // Mostrar el estado actualizado del tablero del oponente
                tableroOponente.mostrarTablero();

                disparoValido = true;
            } else {
                System.out.println("Introduce una coordenada válida.");
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                           SUBPROGRAMAS AUXILIARES                                                        //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Método para configurar el tablero de un jugador
    private static Tablero configurarTablero(String jugador) throws Exception {
        // Mensaje inicial para la configuración del tablero
        System.out.println("\n=== CONFIGURACIÓN DEL TABLERO ===");
        System.out.println("¡Hola, " + jugador + "!");
        System.out.println("Vamos a preparar tu tablero para el juego.");
        System.out.println("Tendrás la oportunidad de personalizar ciertos aspectos o usar configuraciones predeterminadas.\n");

        // Paso 1: Selección de distribución de barcos
        System.out.println("PRIMER PASO: Seleccionar distribución de barcos.");
        System.out.println("¿Cómo deseas distribuir tus barcos?");
        System.out.println("1. Usar la distribución predeterminada (5-4-3-3-2).");
        System.out.println("2. Definir una distribución personalizada.");
        System.out.print("Introduce tu elección (1 o 2): ");
        // Leer la elección del jugador
        int opcionTipoDistribucion = LT.readInt();

        // Configuración de la distribución de barcos según la elección
        if (opcionTipoDistribucion == 2) {
            // Opción personalizada: se solicita una distribución específica
            System.out.println("Has elegido definir una distribución personalizada.");
            System.out.println("Por favor, introduce la distribución deseada. Ejemplo: '5-4-3-2-1'");
            System.out.println("Nota: Cada número representa el tamaño de un barco.");
            // Leer la distribución personalizada del usuario
            distribucion = LT.readLine();
        } else {
            // Opción predeterminada
            System.out.println("Usarás la distribución predeterminada: 5-4-3-3-2.");
            // Asignar la distribución predeterminada
            distribucion = "5-4-3-3-2";
        }

        // Paso 2: Selección del tamaño del tablero
        System.out.println("\nSEGUNDO PASO: Seleccionar tamaño del tablero.");
        System.out.println("¿Qué tipo de tablero deseas usar?");
        System.out.println("1. Tablero convencional (10x10).");
        System.out.println("2. Tablero con dimensiones personalizadas.");
        System.out.print("Introduce tu elección (1 o 2): ");
        // Leer la elección del tamaño del tablero
        int opcionTablero = LT.readInt();

        // Variable para almacenar el objeto Tablero
        Tablero tablero;

        if (opcionTablero == 2) {
            // Opción personalizada: el jugador introduce las dimensiones del tablero
            System.out.println("Has elegido un tablero con dimensiones personalizadas.");
            System.out.print("Introduce el número de filas: ");
            // Leer el número de filas
            int numFilas = LT.readInt();
            System.out.print("Introduce el número de columnas: ");
            // Leer el número de columnas
            int numColumnas = LT.readInt();
            // Crear un tablero con las dimensiones proporcionadas
            tablero = new Tablero(numFilas, numColumnas);
            System.out.println("Se ha creado un tablero de " + numFilas + " filas y " + numColumnas + " columnas.");
        } else {
            // Opción predeterminada: tablero convencional de 10x10
            tablero = new Tablero();
            System.out.println("Se ha seleccionado el tablero convencional de 10x10.");
        }

        // Paso 3: Colocación de los barcos en el tablero
        System.out.println("\nTERCER PASO: Colocar los barcos en el tablero.");
        System.out.println("¿Cómo deseas que se coloquen los barcos?");
        System.out.println("1. Cargar los barcos desde un fichero.");
        System.out.println("2. Colocar los barcos manualmente.");
        System.out.println("3. Colocar los barcos de manera aleatoria.");
        System.out.print("Introduce tu elección (1, 2 o 3): ");
        // Leer la elección de colocación de los barcos
        int opcionDistribucion = LT.readInt();

        // Procesar la elección de colocación de barcos
        switch (opcionDistribucion) {
            case 1:
                // Opción 1: Cargar distribución desde un fichero
                System.out.println("Cargando la distribución de barcos desde un fichero...");
                tablero.caragarBarcosFichero(RUTA_TAULERS, distribucion);
                break;
            case 2:
                // Opción 2: Colocar los barcos manualmente
                System.out.println("Coloca manualmente los barcos en el tablero.");
                tablero.colocacionManualBarcos(distribucion);
                break;
            case 3:
                // Opción 3: Colocar los barcos aleatoriamente
                System.out.println("Distribuyendo los barcos aleatoriamente en el tablero.");
                tablero.colocacionAleatoriaBarcos(distribucion);
                break;
            default:
                // Opción inválida: se carga la distribución predeterminada desde un fichero
                System.out.println("Opción inválida. Se cargará la distribución desde un fichero por defecto.");
                tablero.caragarBarcosFichero(RUTA_TAULERS, distribucion);
                break;
        }

        // Mensaje final indicando que el tablero está listo
        System.out.println("\nTu tablero está listo. ¡Buena suerte, " + jugador + "!");

        return tablero;
    }

// Método para configurar los detalles iniciales de una partida
    private static void configurarDetallesPartida(Partida partida, String nombreJugador, String modoJuego, String tamañoTablero) {
        // Formato de fecha: día/mes/año
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        // Formato de hora: hora:minuto 
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        // Obtener la fecha y hora actual del sistema
        Date fechaActual = new Date();

        // Asignar los detalles de la partida
        partida.setFecha(formatoFecha.format(fechaActual));
        partida.setHora(formatoHora.format(fechaActual));
        partida.setNombreJugador(nombreJugador);
        partida.setModoJuego(modoJuego);
        partida.setTamañoTablero(tamañoTablero);
        partida.setDistribucionBarcos(distribucion);
    }

    // Método para guardar una partida en el archivo
    private static void guardarPartida(Partida partida) throws Exception {
        boolean adicion = true;
        // Instancia de objeto que permite la escritura de objetos partidas en un archvio de texto
        PartidaFicheroEscritura pfe = new PartidaFicheroEscritura("RegistroPartidas.txt", adicion);
        pfe.escritura(partida);
        // Cierre del archivo
        pfe.cierre();
    }

    private static boolean validarCoordenadas(String inPut, int numFilas, int numColumnas) throws Exception {
        // Crear una Linea a partir de la entrada
        Linea entrada = new Linea(inPut);

        int total = entrada.numeroCaracteres();
        if (total < 2 || total > 3) {
            System.out.println("⚠️ Coordenada inválida. Debes introducir un formato como 'A5' o 'C10'.");
            return false;
        }

        // Obtener la fila (primer carácter)
        char fila = entrada.obtenerCaracter(0);
        if (fila < 'A' || fila >= (char) ('A' + numFilas)) {
            System.out.println("⚠️ Coordenada inválida. La fila debe estar entre 'A' y '" + (char) ('A' + numFilas - 1) + "'.");
            return false;
        }

        // Construir la subLinea para la columna a partir del 2º carácter
        Linea subLineaColumna = new Linea();
        for (int i = 1; i < total; i++) {
            subLineaColumna.adicionCaracter(entrada.obtenerCaracter(i));
        }

        // Comprobar que la sublínea de la columna sea un número
        if (!esNumero(subLineaColumna)) {
            System.out.println("⚠️ Coordenada inválida. La columna debe ser un número válido.");
            return false;
        }

        // Convertir la sublinea a entero
        int columna = convertirAEntero(subLineaColumna);
        if (columna < 1 || columna > numColumnas) {
            System.out.println("⚠️ Coordenada inválida. La columna debe estar entre 1 y " + numColumnas + ".");
            return false;
        }

        return true;
    }

    // Comprueba si una línea representa un número
    private static boolean esNumero(Linea linea) throws Exception {
        for (int i = 0; i < linea.numeroCaracteres(); i++) {
            char c = linea.obtenerCaracter(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Convierte una línea numérica a entero sin excepciones
    private static int convertirAEntero(Linea linea) throws Exception {
        int resultado = 0;
        for (int i = 0; i < linea.numeroCaracteres(); i++) {
            resultado = resultado * 10 + (linea.obtenerCaracter(i) - '0');
        }
        return resultado;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                               DETALLES DE PARTIDAS                                                            //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Método para mostrar los detalles de las partidas almacenadas
    private static void mostrarDetallesPartidas() throws Exception {
        // Crear una instancia para leer las partidas desde el archivo "RegistroPartidas.txt"
        PartidaFicheroLectura pfr = new PartidaFicheroLectura("RegistroPartidas.txt");
        // Variable para almacenar las partidas leídas
        Partida partida;

        // Encabezado para los detalles de las partidas
        System.out.println("\n***********************************************************");
        System.out.println("*                DETALLES DE LAS PARTIDAS                *");
        System.out.println("***********************************************************\n");
        // Contador para enumerar las partidas
        int numeroPartida = 1;

        // Bucle para leer y mostrar todas las partidas del archivo
        while ((partida = pfr.lectura()) != null) {
            // Mostrar el número y la fecha/hora de la partida
            System.out.println("Partida " + numeroPartida + " (" + partida.getFecha() + " " + partida.getHora() + ")");
            // Mostrar el modo de juego
            System.out.println("Modo de Juego: " + partida.getModoJuego());
            // Mostrar el tamaño del tablero utilizado en la partida
            System.out.println("Tamaño del Tablero: " + partida.getTamañoTablero());
            // Mostrar la distribución de barcos elegida para la partida
            System.out.println("Distribución de Barcos: " + partida.getDistribucionBarcos());
            // Mostrar el nombre del jugador
            System.out.println("Nombre del Jugador: " + partida.getNombreJugador());

            // Mostrar el resultado de la partida (ganador o perdedor)
            if (partida.getResultado()) {
                System.out.println("Resultado: Ganador/a");
            } else {
                System.out.println("Resultado: Perdedor/a");
            }

            // Mostrar estadísticas de disparos realizados y recibidos
            System.out.println("Disparos a barcos hundidos: " + partida.getDisparosHundidos());
            System.out.println("Disparos a barcos tocados (no hundidos): " + partida.getDisparosTocados());
            System.out.println("Disparos al agua: " + partida.getDisparosAgua());
            System.out.println("Disparos recibidos: " + partida.getDisparosRecibidos());

            // Separador entre partidas
            System.out.println("-----------------------------------------------------------\n");

            // Incrementar el número de partida para la siguiente iteración
            numeroPartida++;
        }

        // Cerrar el archivo después de procesar todas las partidas
        pfr.cerrar();

        // Mensaje indicando el final de la lista de partidas
        System.out.println("Fin de los detalles de las partidas.");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             ESTADISITCAS DE LOS JUGADORES                                                     //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Método para mostrar estadísticas de un jugador con filtros opcionales
    private static void mostrarEstadisticasJugador() throws Exception {
        // Crear una instancia para leer las partidas desde el archivo "RegistroPartidas.txt"
        PartidaFicheroLectura pfr = new PartidaFicheroLectura("RegistroPartidas.txt");

        // Solicitar al usuario el nombre del jugador y convertirlo a un objeto Linea
        System.out.print("Introduce el nombre del jugador: ");
        String nombreInput = LT.readLine();
        Linea nombreJugador = new Linea(nombreInput);

        // Preguntar si desea aplicar filtros adicionales
        System.out.println("\n¿Deseas aplicar algún filtro adicional?");

        // Variables para determinar si se aplicarán filtros y almacenar los valores filtrados
        boolean filtrarModo;
        boolean filtrarTamaño;
        boolean filtrarDistribucion;

        // FILTRO: Modo de juego
        System.out.print("Filtrar por modo de juego (S/N): ");
        char respuesta = LT.readChar();
        LT.skipLine();
        // Determinar si se aplicará el filtro de modo de juego
        filtrarModo = (respuesta == 'S');

        Linea modoFiltro = null;
        if (filtrarModo) {
            System.out.println("1. Solitario\n2. Jugador vs Jugador\n3. Contra la CPU");
            System.out.print("Introduce el número correspondiente al modo: ");
            int modoSeleccionado = LT.readInt();

            // Asignar el filtro de modo de juego según la selección del usuario
            if (modoSeleccionado == 1) {
                modoFiltro = new Linea("Solitario");
            } else if (modoSeleccionado == 2) {
                modoFiltro = new Linea("Jugador vs Jugador");
            } else if (modoSeleccionado == 3) {
                modoFiltro = new Linea("Contra la CPU");
            }
        }

        // FILTRO: Tamaño de tablero
        System.out.print("Filtrar por tamaño de tablero (S/N): ");
        respuesta = LT.readChar();
        LT.skipLine();
        // Determinar si se aplicará el filtro de tamaño de tablero
        filtrarTamaño = (respuesta == 'S');

        Linea tamañoFiltro = null;
        if (filtrarTamaño) {
            System.out.print("Introduce el tamaño del tablero (Ejemplo: 10x10): ");
            String tamañoInput = LT.readLine();
            tamañoFiltro = new Linea(tamañoInput);
        }

        // FILTRO: Distribución de barcos
        System.out.print("Filtrar por distribución de barcos (S/N): ");
        respuesta = LT.readChar();
        LT.skipLine();
        // Determinar si se aplicará el filtro de distribución de barcos
        filtrarDistribucion = (respuesta == 'S');

        Linea distribucionFiltro = null;
        if (filtrarDistribucion) {
            System.out.print("Introduce la distribución de barcos (Ejemplo: 5-4-3-3-2): ");
            String distribucionInput = LT.readLine();
            distribucionFiltro = new Linea(distribucionInput);
        }

        // Variables para estadísticas acumulativas
        int totalPartidas = 0, ganadas = 0;
        int totalDisparosHundidos = 0, totalDisparosTocados = 0, totalDisparosAgua = 0;
        int totalDisparosRecibidos = 0;

        Partida partida;

        // Encabezado para las estadísticas
        System.out.println("\n***********************************************************");
        System.out.println("*              ESTADÍSTICAS DEL JUGADOR                   *");
        System.out.println("***********************************************************\n");

        // Leer todas las partidas y aplicar filtros
        while ((partida = pfr.lectura()) != null) {
            // Convertir datos relevantes de la partida en objetos Linea para comparar
            Linea jugadorPartida = new Linea(partida.getNombreJugador());
            Linea modoPartida = new Linea(partida.getModoJuego());
            Linea tamañoPartida = new Linea(partida.getTamañoTablero());
            Linea distribucionPartida = new Linea(partida.getDistribucionBarcos());

            // Aplicar los filtros seleccionados y verificar si la partida coincide
            if (jugadorPartida.esIgual(nombreJugador) && (!filtrarModo || modoPartida.esIgual(modoFiltro)) && 
               (!filtrarTamaño || tamañoPartida.esIgual(tamañoFiltro)) && 
               (!filtrarDistribucion || distribucionPartida.esIgual(distribucionFiltro))) {

                // Incrementar contadores y acumular estadísticas
                totalPartidas++;
                if (partida.getResultado()) {
                    ganadas++;
                }
                totalDisparosHundidos += partida.getDisparosHundidos();
                totalDisparosTocados += partida.getDisparosTocados();
                totalDisparosAgua += partida.getDisparosAgua();
                totalDisparosRecibidos += partida.getDisparosRecibidos();
            }
        }

        // Mostrar estadísticas si hay partidas que coinciden con los filtros
        if (totalPartidas > 0) {
            double porcentajeGanadas = (ganadas / (double) totalPartidas) * 100;
            double promedioHundidos = totalDisparosHundidos / (double) totalPartidas;
            double promedioTocados = totalDisparosTocados / (double) totalPartidas;
            double promedioAgua = totalDisparosAgua / (double) totalPartidas;
            double promedioRecibidos = totalDisparosRecibidos / (double) totalPartidas;

            System.out.println("\n***************************************************");
            System.out.println("📊 Total de partidas jugadas: " + totalPartidas);
            System.out.println("🏆 Partidas ganadas: " + porcentajeGanadas + "%");
            System.out.println("🚢 Promedio disparos hundidos: " + promedioHundidos);
            System.out.println("🎯 Promedio disparos tocados: " + promedioTocados);
            System.out.println("💦 Promedio disparos al agua: " + promedioAgua);
            System.out.println("🔻 Promedio disparos recibidos: " + promedioRecibidos);
            System.out.println("***************************************************");
        } else {
            // Mostrar mensaje si no hay partidas que coincidan con los filtros
            System.out.println("\n⚠️ No se encontraron partidas registradas para el jugador.");
        }

        // Cerrar el archivo después de procesar todas las partidas
        pfr.cerrar();

        // Mensaje final indicando que se han terminado de mostrar las estadísticas
        System.out.println("\n***********************************************************");
        System.out.println("Fin de las estadísticas del jugador.");
    }
}
