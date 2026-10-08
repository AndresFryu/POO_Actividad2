package Actividad2_POO;

import java.util.Scanner;

/**
 * Clase CuentaBancaria - Ejercicio 2.5
 */
public class CuentaBancaria {

    // Atributos de la clase
    private String nombresTitular;
    private String apellidosTitular;
    private int numeroCuenta;
    private double saldo;

    // 1. Atributo solicitado para determinar si la cuenta está activa
    private boolean activa;

    /**
     * Constructor de la clase CuentaBancaria.
     * Evalúa dinámicamente si la cuenta nace activa según el saldo inicial.
     */
    public CuentaBancaria(String nombresTitular, String apellidosTitular, int numeroCuenta, double saldoInicial) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuenta = numeroCuenta;
        
        if (saldoInicial > 0) {
            this.saldo = saldoInicial;
            this.activa = true; // Una cuenta está activa si tiene un saldo positivo
        } else {
            this.saldo = 0;
            this.activa = false; // Nace inactiva si el saldo inicial es cero o negativo
        }
    }

    // --- MÉTODOS DE CONTROL DE CUENTA ---

    /**
     * Permite consignar dinero en la cuenta.
     * No permite consignaciones si la cuenta se encuentra inactiva.
     */
    public void consignar(double valor) {
        if (!activa) {
            System.out.println("\n[ERROR] No se pueden realizar consignaciones a la cuenta porque está INACTIVA.");
            return;
        }

        if (valor > 0) {
            saldo += valor;
            System.out.println("\n[ÉXITO] Consignación realizada por: $" + valor);
            System.out.println("Nuevo saldo actual: $" + saldo);
        } else {
            System.out.println("\n[ERROR] El valor a consignar debe ser mayor a 0.");
        }
    }

    /**
     * Permite retirar dinero de la cuenta.
     * Si al retirar dinero el saldo llega a 0, la cuenta pasa a estar inactiva.
     */
    public void retirar(double valor) {
        if (!activa) {
            System.out.println("\n[ERROR] La cuenta está INACTIVA. No se pueden realizar retiros.");
            return;
        }

        if (valor <= 0) {
            System.out.println("\n[ERROR] El valor a retirar debe ser mayor a 0.");
            return;
        }

        if (valor > saldo) {
            System.out.println("\n[ERROR] Fondos insuficientes. Saldo disponible: $" + saldo);
        } else {
            saldo -= valor;
            System.out.println("\n[ÉXITO] Retiro realizado por: $" + valor);
            System.out.println("Saldo restante: $" + saldo);

            // Si al retirar dinero el saldo queda en cero, pasa a considerarse inactiva
            if (saldo == 0) {
                activa = false;
                System.out.println("[ALERTA] El saldo ha llegado a $0. La cuenta ha cambiado su estado a INACTIVA.");
            }
        }
    }

    /**
     * Imprime en pantalla la información básica y el estado de la cuenta.
     */
    public void imprimir() {
        System.out.println("\n====================================");
        System.out.println("      ESTADO DE CUENTA BANCARIA     ");
        System.out.println("====================================");
        System.out.println("Titular: " + nombresTitular + " " + apellidosTitular);
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: $" + saldo);
        System.out.println("Estado de la Cuenta: " + (activa ? "ACTIVA" : "INACTIVA"));
        System.out.println("====================================\n");
    }

    // Getters y Setters
    public boolean isActiva() {
        return activa;
    }

    public double getSaldo() {
        return saldo;
    }

    // --- MENÚ PRINCIPAL INTERACTIVO ---

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== APERTURA DE CUENTA BANCARIA ===");
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese los apellidos del titular: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();

        System.out.print("Ingrese el saldo inicial: $");
        double saldoInicial = scanner.nextDouble();

        // Crear la cuenta bancaria con los datos ingresados
        CuentaBancaria cuenta = new CuentaBancaria(nombre, apellidos, numeroCuenta, saldoInicial);

        int opcion;
        do {
            System.out.println("\n--- MENÚ DE OPERACIONES ---");
            System.out.println("1. Consultar estado de cuenta");
            System.out.println("2. Consignar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cuenta.imprimir();
                    break;
                case 2:
                    System.out.print("Ingrese el monto a consignar: $");
                    double consignacion = scanner.nextDouble();
                    cuenta.consignar(consignacion);
                    break;
                case 3:
                    System.out.print("Ingrese el monto a retirar: $");
                    double retiro = scanner.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 4:
                    System.out.println("\nGracias por utilizar nuestros servicios bancarios.");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
