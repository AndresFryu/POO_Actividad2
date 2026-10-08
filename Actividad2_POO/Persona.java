package Actividad2_POO;

/**
 * Clase Persona con atributos adicionales (País de nacimiento y Género)
 */
public class Persona {

    // 1. Atributos existentes
    String nombre;
    String apellidos;
    String númeroDocumentoIdentidad;
    int añoNacimiento;

    // 1. Nuevos atributos agregados
    String paísNacimiento;
    char género; // 'H' para Hombre, 'M' para Mujer

    /**
     * 2. Constructor modificado
     * Ahora recibe también el país de nacimiento y el género.
     */
    public Persona(String nombre, String apellidos, String númeroDocumentoIdentidad, int añoNacimiento, String paísNacimiento, char género) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.númeroDocumentoIdentidad = númeroDocumentoIdentidad;
        this.añoNacimiento = añoNacimiento;
        this.paísNacimiento = paísNacimiento;
        this.género = género;
    }

    /**
     * 3. Método imprimir modificado
     * Muestra en pantalla los datos completos de la persona, incluyendo los nuevos atributos.
     */
    public void imprimir() {
        System.out.println("Nombre = " + nombre);
        System.out.println("Apellidos = " + apellidos);
        System.out.println("Número de documento de identidad = " + númeroDocumentoIdentidad);
        System.out.println("Año de nacimiento = " + añoNacimiento);
        System.out.println("País de nacimiento = " + paísNacimiento);
        System.out.println("Género = " + género);
        System.out.println(); // Salto de línea para separar la salida
    }

    /**
     * 4. Método principal para probar las modificaciones
     */
    public static void main(String[] args) {
        // Instanciación de dos objetos pasando los nuevos valores ('H' y 'M', junto con el país)
        Persona p1 = new Persona("Pedro", "Pérez", "1053121010", 1998, "Colombia", 'H');
        Persona p2 = new Persona("Luis", "León", "1053223344", 2001, "México", 'M');

        // Invocación del método imprimir()
        p1.imprimir();
        p2.imprimir();
    }
}