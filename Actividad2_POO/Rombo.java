package Actividad2_POO;

/**
 * Clase que representa la figura geométrica Rombo - Ejercicio 2.4
 */
public class Rombo {

    // Atributos de la figura
    private double diagonalMayor;
    private double diagonalMenor;
    private double lado;

    /**
     * Constructor de la clase Rombo
     */
    public Rombo(double diagonalMayor, double diagonalMenor, double lado) {
        this.diagonalMayor = diagonalMayor;
        this.diagonalMenor = diagonalMenor;
        this.lado = lado;
    }

    /**
     * Calcula el área del rombo: (Diagonal Mayor * Diagonal Menor) / 2
     */
    public double calcularArea() {
        return (diagonalMayor * diagonalMenor) / 2.0;
    }

    /**
     * Calcula el perímetro del rombo: 4 * Lado
     */
    public double calcularPerimetro() {
        return 4 * lado;
    }

    // Getters
    public double getDiagonalMayor() {
        return diagonalMayor;
    }

    public double getDiagonalMenor() {
        return diagonalMenor;
    }

    public double getLado() {
        return lado;
    }
}