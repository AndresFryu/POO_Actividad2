package Actividad2_POO;

import java.util.Scanner;

/**
 * Clase Planeta
 * Modificada para incluir los ejercicios propuestos: periodo orbital y periodo de rotación.
 */
public class Planeta {

    // --- Atributos base (típicos de este ejercicio) ---
    String nombre;
    int cantidadSatelites;
    double masa; // En kilogramos
    double volumen; // En kilómetros cúbicos
    int diametro; // En kilómetros
    int distanciaMediaAlSol; // En millones de kilómetros
    boolean esObservable; // true si es observable a simple vista, false si no

    // --- 1. Nuevos atributos solicitados ---
    double periodoOrbital;  // Representa el tiempo que tarda en dar la vuelta al sol (en años)
    double periodoRotacion; // Representa el tiempo que tarda en girar sobre su propio eje (en días)

    /**
     * --- 2. Constructor modificado ---
     * Inicializa tanto los atributos base como los nuevos atributos propuestos.
     */
    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, 
                   int distanciaMediaAlSol, boolean esObservable, double periodoOrbital, double periodoRotacion) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaAlSol = distanciaMediaAlSol;
        this.esObservable = esObservable;
        // Inicialización de los nuevos atributos
        this.periodoOrbital = periodoOrbital;
        this.periodoRotacion = periodoRotacion;
    }

    /**
     * --- 3. Método imprimir modificado ---
     * Muestra en pantalla todos los datos, incluyendo los nuevos atributos.
     */
    public void imprimir() {
        System.out.println("\n=== DATOS DEL PLANETA REGISTRADO ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de satélites: " + cantidadSatelites);
        System.out.println("Masa: " + masa + " kg");
        System.out.println("Volumen: " + volumen + " km³");
        System.out.println("Diámetro: " + diametro + " km");
        System.out.println("Distancia media al sol: " + distanciaMediaAlSol + " millones de km");
        System.out.println("¿Es observable a simple vista?: " + (esObservable ? "Sí" : "No"));
        // Impresión de los nuevos atributos
        System.out.println("Periodo orbital: " + periodoOrbital + " años");
        System.out.println("Periodo de rotación: " + periodoRotacion + " días");
        System.out.println("====================================\n");
    }

    /**
     * Método principal interactivo
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== INGRESO DE DATOS DEL PLANETA ===");
        
        System.out.print("Ingrese el nombre del planeta: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la cantidad de satélites: ");
        int satelites = scanner.nextInt();

        System.out.print("Ingrese la masa (en kg): ");
        double masa = scanner.nextDouble();

        System.out.print("Ingrese el volumen (en km³): ");
        double volumen = scanner.nextDouble();

        System.out.print("Ingrese el diámetro (en km): ");
        int diametro = scanner.nextInt();

        System.out.print("Ingrese la distancia media al Sol (en millones de km): ");
        int distancia = scanner.nextInt();

        System.out.print("¿Es observable a simple vista? (true/false): ");
        boolean observable = scanner.nextBoolean();

        // Solicitud de los nuevos atributos
        System.out.print("Ingrese el periodo orbital (en años): ");
        double orbital = scanner.nextDouble();

        System.out.print("Ingrese el periodo de rotación (en días): ");
        double rotacion = scanner.nextDouble();

        // Se crea el objeto pasando todos los datos leídos por consola al constructor
        Planeta miPlaneta = new Planeta(nombre, satelites, masa, volumen, diametro, distancia, observable, orbital, rotacion);

        // Se imprimen los resultados
        miPlaneta.imprimir();

        scanner.close();
    }
}