import java.util.Scanner;

public class MontaCargas {

    public static void main(String[] args) {
        ejecutarSimulacion();
    }

    public static void ejecutarSimulacion() {
        Scanner scanner = new Scanner(System.in);
        int plantaActual = 0;
        boolean simulacionActiva = true;

        System.out.println("Montacargas iniciado en planta 0.");

        while (simulacionActiva) {
            mostrarEdificio(plantaActual);
            int destino = solicitarDestino(scanner, plantaActual);

            if (destino == -1) {
                System.out.println("Finalizando simulación.");
                simulacionActiva = false;
            } else {
                plantaActual = moverMontacargas(plantaActual, destino, scanner);
                System.out.println("Montacargas detenido en planta " + plantaActual + ".\n");
            }
        }

        scanner.close();
    }

    public static int solicitarDestino(Scanner scanner, int plantaActual) {
        final int PISO_MIN = 0;
        final int PISO_MAX = 9;
    
        while (true) {
            System.out.print("Ingrese el número de planta destino (0-9), o -1 para salir: ");
            int destino = scanner.nextInt();
            scanner.nextLine(); 
    
            if (destino == -1) {
                return -1;
            } else if (destino < PISO_MIN || destino > PISO_MAX) {
                System.out.println("Planta inválida. Intente nuevamente.\n");
            } else if (destino == plantaActual) {
                System.out.println("Ya estás en esa planta.\n");
            } else {
                return destino;
            }
        }
    }

    public static int moverMontacargas(int origen, int destino, Scanner scanner) {
        System.out.println("Moviendo montacargas... Presiona Enter para avanzar piso a piso.\n");

        if (destino > origen) {
            for (int i = origen + 1; i <= destino; i++) {
                scanner.nextLine(); 
                mostrarEdificio(i);
            }
        } else {
            for (int i = origen - 1; i >= destino; i--) {
                scanner.nextLine(); 
                mostrarEdificio(i);
            }
        }

        return destino;
    }

    public static void mostrarEdificio(int plantaActual) {
        System.out.println();
        for (int i = 9; i >= 0; i--) {
            if (i == plantaActual) {
                System.out.println("[ --- ]" + i);
            } else {
                System.out.println("|   |" + i);
            }
        }
        System.out.println("-----------------");
        System.out.println("En planta " + plantaActual);
        System.out.println("Detenido");
    }
}
