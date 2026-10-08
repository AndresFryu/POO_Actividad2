package Actividad2_POO;

import java.util.Scanner;

/**
 * Clase Automovil - Ejercicio 2.3
 */
public class Automovil {

    // Atributos base del automóvil
    private String marca;
    private int modelo;
    private double velocidadMaxima;
    private double velocidadActual;

    // 1. Nuevo atributo agregado (indica si es automático o no)
    private boolean esAutomatico;

    // Atributos para la gestión de multas
    private double valorTotalMultas;
    private static final double VALOR_MULTA_INDIVIDUAL = 100.0; // Valor fijo asignado por cada infracción

    /**
     * 1. Constructor modificado para inicializar el atributo esAutomatico.
     */
    public Automovil(String marca, int modelo, double velocidadMaxima, boolean esAutomatico) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.esAutomatico = esAutomatico;
        this.velocidadActual = 0.0;     // El automóvil inicia detenido
        this.valorTotalMultas = 0.0;    // Inicialmente no tiene multas
    }

    // --- 1. MÉTODOS GET Y SET PARA esAutomatico ---
    
    public boolean isEsAutomatico() {
        return esAutomatico;
    }

    public void setEsAutomatico(boolean esAutomatico) {
        this.esAutomatico = esAutomatico;
    }

    // Getters auxiliares
    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    // --- 2. MÉTODO ACELERAR MODIFICADO ---

    /**
     * Acelera el vehículo. Si supera la velocidad máxima permitida,
     * la velocidad se ajusta al límite y se genera/incrementa una multa.
     */
    public void acelerar(double incremento) {
        if (incremento <= 0) {
            System.out.println("El incremento de velocidad debe ser mayor a 0 km/h.");
            return;
        }

        if (this.velocidadActual + incremento > this.velocidadMaxima) {
            this.velocidadActual = this.velocidadMaxima;
            this.valorTotalMultas += VALOR_MULTA_INDIVIDUAL; // Incrementa el valor total de multas
            System.out.println("\n¡ALERTA! Ha intentado superar la velocidad máxima permitida (" + velocidadMaxima + " km/h).");
            System.out.println("Se ha aplicado una multa de $" + VALOR_MULTA_INDIVIDUAL + ". La velocidad se limitó al máximo permitido.");
        } else {
            this.velocidadActual += incremento;
            System.out.println("\nAcelerando... Velocidad actual: " + this.velocidadActual + " km/h.");
        }
    }

    /**
     * Método desacelerar
     */
    public void desacelerar(double decremento) {
        if (decremento <= 0) {
            System.out.println("El decremento debe ser mayor a 0 km/h.");
            return;
        }

        if (this.velocidadActual - decremento < 0) {
            this.velocidadActual = 0;
            System.out.println("\nEl vehículo se ha detenido por completo (0 km/h).");
        } else {
            this.velocidadActual -= decremento;
            System.out.println("\nDesacelerando... Velocidad actual: " + this.velocidadActual + " km/h.");
        }
    }

    // --- 3. MÉTODOS PARA GESTIÓN DE MULTAS ---

    /**
     * Determina si el vehículo tiene multas registradas.
     * @return true si el valor acumulado es mayor a 0, false de lo contrario.
     */
    public boolean tieneMultas() {
        return this.valorTotalMultas > 0;
    }

    /**
     * Determina el valor total de multas acumuladas del vehículo.
     * @return Total en dinero de las multas.
     */
    public double getValorTotalMultas() {
        return this.valorTotalMultas;
    }

    /**
     * Imprime la información básica y el estado general del automóvil.
     */
    public void imprimir() {
        System.out.println("\n====================================");
        System.out.println("        ESTADO DEL AUTOMÓVIL        ");
        System.out.println("====================================");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Transmisión: " + (esAutomatico ? "Automático" : "Mecánico / Manual"));
        System.out.println("Velocidad Máxima: " + velocidadMaxima + " km/h");
        System.out.println("Velocidad Actual: " + velocidadActual + " km/h");
        System.out.println("¿Tiene multas?: " + (tieneMultas() ? "Sí" : "No"));
        System.out.println("Total en multas: $" + getValorTotalMultas());
        System.out.println("====================================\n");
    }

    // --- MÉTODO PRINCIPAL INTERACTIVO ---

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REGISTRO DEL VEHÍCULO ===");
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el modelo (año): ");
        int modelo = scanner.nextInt();

        System.out.print("Ingrese la velocidad máxima permitida (km/h): ");
        double velocidadMaxima = scanner.nextDouble();

        System.out.print("¿Es un vehículo automático? (true/false): ");
        boolean esAutomatico = scanner.nextBoolean();

        // Instanciación del vehículo con los datos leídos
        Automovil miAuto = new Automovil(marca, modelo, velocidadMaxima, esAutomatico);

        int opcion;
        do {
            System.out.println("--- MENÚ DE CONDUCCIÓN ---");
            System.out.println("1. Acelerar");
            System.out.println("2. Desacelerar");
            System.out.println("3. Ver estado del automóvil");
            System.out.println("4. Consultar multas");
            System.out.println("5. Cambiar tipo de transmisión (Probar Setter)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("¿Cuántos km/h desea acelerar?: ");
                    double inc = scanner.nextDouble();
                    miAuto.acelerar(inc);
                    break;
                case 2:
                    System.out.print("¿Cuántos km/h desea desacelerar?: ");
                    double dec = scanner.nextDouble();
                    miAuto.desacelerar(dec);
                    break;
                case 3:
                    miAuto.imprimir();
                    break;
                case 4:
                    if (miAuto.tieneMultas()) {
                        System.out.println("\n[!] El vehículo TIENE multas registradas.");
                        System.out.println("Monto total de multas acumuladas: $" + miAuto.getValorTotalMultas() + "\n");
                    } else {
                        System.out.println("\n[OK] El vehículo no registra ninguna multa actualmente.\n");
                    }
                    break;
                case 5:
                    System.out.print("¿Desea cambiar la transmisión a Automático? (true / false): ");
                    boolean nuevoEstado = scanner.nextBoolean();
                    miAuto.setEsAutomatico(nuevoEstado);
                    System.out.println("Transmisión actualizada con éxito mediante el setter.");
                    break;
                case 6:
                    System.out.println("Finalizando simulación de conducción.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}