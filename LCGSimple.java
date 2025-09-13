import java.util.Scanner;
import java.time.LocalDateTime;

public class LCGSimple {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        long a = 1664525;
        long c = 1013904223;
        long m = (long) Math.pow(2, 32);
        int periodo = 3;

        System.out.print("Ingresa el valor mínimo del rango: ");
        int min = leer.nextInt();
        System.out.print("Ingresa el valor máximo del rango: ");
        int max = leer.nextInt();

        if (min >= max) {
            System.out.println("El mínimo debe ser menor que el máximo.");
            return;
        }

        String res = "s";
        while (res.equals("s")) {
            LocalDateTime ahora = LocalDateTime.now();
            long seed = ahora.getHour() + ahora.getMinute() + ahora.getSecond();
            long x = seed;

            for (int i = 0; i < periodo; i++) {
                x = (a * x + c) % m;
            }
            int rango = max - min + 1;
            int pseudoaleatorio = (int)(x % rango) + min;

            System.out.println("\nNúmero pseudoaleatorio generado dentro del rango [" + min + ", " + max + "]: " + pseudoaleatorio);
            System.out.println("¿Deseas generar un nuevo número? s/n");
            res = leer.next();
        }
    }
}
