import java.util.Scanner;

class JuegoDados {
    public static void main(String[] args) {
        int j1points = 0;
        int j2points = 0;
        int d1, d2, d3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Juego de dados");
        while (j1points < 100 && j2points < 100) {
            System.out.println("Turno J1");
            d1 = (int) (Math.random() * 6 + 1);
            d2 = (int) (Math.random() * 6 + 1);
            d3 = (int) (Math.random() * 6 + 1);
            System.out.println("Dados: " + d1 + " " + d2 + " " + d3);
            if (d1 == d2 && d2 == d3) {
                j1points = j1points + 6;
            }
            if (d1 == d2 || d2 == d3 || d1 == d3) {
                j1points = j1points + 2;
            }
            if (d1 != d2 && d2 != d3 && d1 != d3) {
                j1points = j1points + Math.max(Math.max(d1, d2), d3);
            }

            System.out.println("Puntos J1: " + j1points);
            System.out.println("Turno J2");
            d1 = (int) (Math.random() * 6 + 1);
            d2 = (int) (Math.random() * 6 + 1);
            d3 = (int) (Math.random() * 6 + 1);
            System.out.println("Dados: " + d1 + " " + d2 + " " + d3);

            if (d1 == d2 && d2 == d3) {
                j2points = j2points + 6;
            }
            if (d1 == d2 || d2 == d3 || d1 == d3) {
                j2points = j2points + 2;
            }
            if (d1 != d2 && d2 != d3 && d1 != d3) {
                j2points = j2points + Math.max(Math.max(d1, d2), d3);
            }

            System.out.println("Puntos J2: " + j2points);
            System.out.println("Presione Enter para continuar...");
            sc.nextLine();
        }
        
        if (j1points >= 100) {
            System.out.println("¡Gana J1!");
        } else {
            System.out.println("¡Gana J2!");
        }
    }
}