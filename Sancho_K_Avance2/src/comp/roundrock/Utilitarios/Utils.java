package comp.roundrock.Utilitarios;
import java.io.*;
/**
 * Clase utilitarios.Utils
 * Esta clase contiene métodos utilizarios para la lectura de datos básicos.
 * Además, de validaciones de las entradas para facilitar la escritura de
 * códigos.
 *
 * @author Mauricio Andrés Zamora Hernández
 * @version 1.0
 */

public class Utils {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static PrintStream out = System.out;

    public static String leerString(String texto) {
        String resultado = null;
        out.print(texto);

        try {
            resultado = in.readLine();

        } catch (Exception e) {
        }

        return resultado;
    }

    /**
     * Este método leer un boolean (true/false), para esto se hace una pregunta de tipo Si y NO,
     * si el usuario escribe un Si, el sistema devuelve un true, el usuario escoge No el sistema
     * devuelve un false. Si no responde a las opciones, el sistema sigue preguntando.
     *
     * @param pregunta Es el texto de la pregunta, no es necesario colocar los signos de puntuación.
     * @return boolean que corresopnde a la respuesta del usuario True para Si, False para No
     */

    public static void limpiar() {
        System.out.print("\033[2J");
    }

    public static void establecerColorRojo() {
        System.out.print("\033[31m");
    }

    public static void establecerColorVerde() {
        System.out.print("\033[32m");
    }

    public static void establecerColorAmarillo() {
        System.out.print("\033[33m");
    }

    public static void establecerColorAzul() {
        System.out.print("\033[34m");
    }

    public static void establecerColorMangenta() {
        System.out.print("\033[35m");
    }

    public static void establecerColorCian() {
        System.out.print("\033[36m");
    }

    public static void establecerColorBlanco() {
        System.out.print("\033[37m");
    }

    public static void reiniciarColores() {
        System.out.print("\033[0m");
    }

    public static int seleccionarElementoTexto(String etiqueta, String[] opciones) {
        int resultado = 0;
        out.println(etiqueta);

        for (int i = 0; i < opciones.length; i++) {
            out.printf("%3d - %s\n", (i + 1), opciones[i]);
        }

        resultado = leerRangosEnteros("Seleccione el ID de la opción", 1, opciones.length);

        return resultado;
    }

    public static int leerEntero(String texto) {
        int resultado = 0;
        out.print(texto);

        boolean ocurrioUnaBronca = false;

        do {
            try {
                resultado = Integer.parseInt(in.readLine());
                ocurrioUnaBronca = false;
            } catch (Exception e) {
                ocurrioUnaBronca = true;
                out.println("Intente de nuevo, porque no digito un número");
            }
        } while (ocurrioUnaBronca);

        return resultado;
    }

    /**
     * Este método permite la lectura de un String (texto).
     *
     * @param texto Es el texto utilizado como etiqueta para que el usuario sepa que
     *              se le solicita.
     *              Si no desea imprimir una etiqueta, coloque "".
     * @return String (texto) digitado por el usuario.
     */

    public static int leerRangosEnteros(String etiqueta, int min, int max) {
        int resultado = 0;
        out.println(etiqueta);

        do {
            resultado = leerEntero("");
            if (resultado < min || resultado > max) {
                out.println("Valor fuera del rango [" + min + " al " + max + "], digite de nuevo");
            }

        } while (resultado < min || resultado > max);

        return resultado;
    }

    /**
     * Este método valida la lectura de un rango de valores dobles, ambos límites
     * inclusive.
     * Si el usuario digita un valor fuera del rango, el sistema le solitará otro
     * valor hasta
     * encontrar un valor válido.
     *
     * @param etiqueta Es el texto utilizado como etiqueta para que el usuario sepa
     *                 que se le solicita.
     * @param min      Valor mínimo del rango
     * @param max      Valor máximo del rango
     * @return Número doble digitado por el usuario.
     */


}