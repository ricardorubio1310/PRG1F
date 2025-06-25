import java.util.Scanner;

class CalculadoraEstadistica {
    public static void main(String[] args) {
        int cantidadNumeros = pedirCantidad();
        double suma = 0;
        double sumaCuadrados = 0;
        for (int i = 1; i <= cantidadNumeros; i++) {
            System.out.print("Número " + i + ": ");
            double numeroSeleccionado = new Scanner(System.in).nextDouble();
            suma = suma + numeroSeleccionado;
            sumaCuadrados = sumaCuadrados + numeroSeleccionado * numeroSeleccionado;
        }
        double media = calcularMedia(suma, cantidadNumeros);
        double desviacion = calcularDesviacion(sumaCuadrados, suma, cantidadNumeros);
        System.out.println("Media: " + media);
        System.out.println("Desviación: " + desviacion);
    }

    static int pedirCantidad() {
        Scanner entrada = new Scanner(System.in);
        int numero;
        do {
            System.out.print("¿Cuántos números? ");
            numero = entrada.nextInt();
        } while (numero <= 0);
        return numero;
    }

    static double calcularMedia(double suma, int cantidad) {
        return suma / cantidad;
    }

    static double calcularDesviacion(double sumaCuadrados, double suma, int n) {
        double media = suma / n;
        return Math.sqrt(sumaCuadrados / n - media * media);
    }
}