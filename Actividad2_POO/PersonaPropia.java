package Actividad2_POO;

import java.util.Scanner; // Importamos la clase Scanner para leer datos del teclado

/**
 * Clase Persona con lectura interactiva por consola.
 */
public class PersonaPropia {

    // Atributos de la clase
    String nombre;
    String apellidos;
    String númeroDocumentoIdentidad;
    int añoNacimiento;
    String paísNacimiento;
    char género;

    /**
     * Constructor de la clase Persona
     */
    public PersonaPropia(String nombre, String apellidos, String númeroDocumentoIdentidad, int añoNacimiento, String paísNacimiento, char género) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.númeroDocumentoIdentidad = númeroDocumentoIdentidad;
        this.añoNacimiento = añoNacimiento;
        this.paísNacimiento = paísNacimiento;
        this.género = género;
    }

    /**
     * Método para imprimir la información en pantalla
     */
    public void imprimir() {
        System.out.println("\n--- DATOS REGISTRADOS ---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Número de documento de identidad: " + númeroDocumentoIdentidad);
        System.out.println("Año de nacimiento: " + añoNacimiento);
        System.out.println("País de nacimiento: " + paísNacimiento);
        System.out.println("Género: " + género);
        System.out.println("-------------------------\n");
    }

    /**
     * Método principal interactivo
     */
    public static void main(String[] args) {
        // Objeto Scanner para capturar datos desde la consola
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== INGRESO DE DATOS DE LA PERSONA ===");

        // Solicitud y captura de cada dato
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese el número de documento de identidad: ");
        String documento = scanner.nextLine();

        System.out.print("Ingrese el año de nacimiento: ");
        int añoNacimiento = scanner.nextInt();
        scanner.nextLine(); // Limpieza de búfer (consume el salto de línea pendiente)

        System.out.print("Ingrese el país de nacimiento: ");
        String pais = scanner.nextLine();

        System.out.print("Ingrese el género (H/M): ");
        char genero = scanner.next().charAt(0);

        // Crear el objeto PersonaPropia con los datos ingresados por el usuario
        PersonaPropia personaUsuario = new PersonaPropia(nombre, apellidos, documento, añoNacimiento, pais, genero);

        // Imprimir los datos ingresados
        personaUsuario.imprimir();

        // Cerramos el scanner al finalizar
        scanner.close();
    }
}