import java.util.Scanner;

public class IAFInal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] carnet = leerCarnet(entrada);
        int sumaPares = sumarEnIndicesPares(carnet);
        int sumaImpares = sumarEnIndicesImpares(carnet);
        int sumaTotal = sumaPares + sumaImpares;

        int[] problemas = calcularProblemas(sumaPares, sumaImpares, sumaTotal);
        mostrarResultados(problemas);

        entrada.close();
    }

    private static int[] leerCarnet(Scanner entrada) {
        final int LONGITUD = 10;
        int[] carnet = new int[LONGITUD];
        System.out.println("Ingrese los 10 dígitos del carnet, separados por espacios:");
        for (int i = 0; i < LONGITUD; i++) {
            while (!entrada.hasNextInt()) {
                System.out.print("Debe ser un número. Intente de nuevo: ");
                entrada.next();
            }
            carnet[i] = entrada.nextInt();
        }
        return carnet;
    }

    private static int sumarEnIndicesPares(int[] datos) {
        int suma = 0;
        for (int i = 0; i < datos.length; i += 2) {
            suma += datos[i];
        }
        return suma;
    }

    private static int sumarEnIndicesImpares(int[] datos) {
        int suma = 0;
        for (int i = 1; i < datos.length; i += 2) {
            suma += datos[i];
        }
        return suma;
    }

    private static int[] calcularProblemas(int sumaPares, int sumaImpares, int sumaTotal) {
        int problema1 = (sumaPares / 6) + 1;
        int problema2 = (sumaImpares / 6) + 1;
        int problema3 = (sumaTotal / 6) + 1;

        boolean hayConflicto = true;
        while (hayConflicto) {

            if (problema1 == problema2)
                problema1++;
            if (problema1 == problema3)
                problema1++;
            if (problema2 == problema3)
                problema3++;

            if (problema1 > 6)
                problema1 = 1;
            if (problema2 > 6)
                problema2 = 1;
            if (problema3 > 6)
                problema3 = 1;

            hayConflicto = (problema1 == problema2)
                    || (problema1 == problema3)
                    || (problema2 == problema3);
        }

        return new int[] { problema1, problema2, problema3 };
    }

    private static void mostrarResultados(int[] problemas) {
        System.out.println("Problema 1: " + problemas[0]);
        System.out.println("Problema 2: " + problemas[1]);
        System.out.println("Problema 3: " + problemas[2]);
    }
}
