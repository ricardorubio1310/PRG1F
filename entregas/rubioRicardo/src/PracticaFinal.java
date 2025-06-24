import java.util.Scanner;

public class Final {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] carnet;
        int sumaPosicionParCarnet;
        int sumaPosicionImparCarnet;
        int sumaTotalCarnet;
        int problema1;
        int problema2;
        int problema3;

        System.out.println("Ingrese los 10 numeros del carnet de identidad, separados por espacios:");
        carnet = new int[10];
        for (int i = 0; i < carnet.length; i++) {
            carnet[i] = entrada.nextInt();
        }
        sumaPosicionImparCarnet = carnet[0] + carnet[2] + carnet[4] + carnet[6] + carnet[8];
        sumaPosicionParCarnet = carnet[1] + carnet[3] + carnet[5] + carnet[7] + carnet[9];
        sumaTotalCarnet = sumaPosicionImparCarnet + sumaPosicionParCarnet;
        problema1 = (sumaPosicionImparCarnet / 6) + 1;
        problema2 = (sumaPosicionParCarnet / 6) + 1;
        problema3 = (sumaTotalCarnet / 6) + 1;

        do {
            if (problema1 == problema2) {
                problema1 = problema1 + 1;
            }
            if (problema1 == problema3) {
                problema1 = problema1 + 1;
            }
            if (problema2 == problema3) {
                problema3 = problema3 + 1;
            }
            if (problema1 == 7) {
                problema1 = 1;
            }
            if (problema2 == 7) {
                problema2 = 1;
            }
            if (problema3 == 7) {
                problema3 = 1;
            }
        } while (problema1 == problema2 || problema1 == problema3 || problema2 == problema3 || problema1 > 6
                || problema2 > 6 || problema3 > 6);

        System.out.println("Problema 1: " + problema1);
        System.out.println("Problema 2: " + problema2);
        System.out.println("Problema 3: " + problema3);
        entrada.close();
    }
}
