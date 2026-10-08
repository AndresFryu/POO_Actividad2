package Actividad2_POO;

public class PruebaRombo {
    public static void main(String[] args) {
        Rombo r = new Rombo(10, 6, 5.80);

        System.out.println("Área: " + r.calcularArea());
        System.out.println("Perímetro: " + r.calcularPerimetro());
    }
}