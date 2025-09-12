import java.util.Scanner;
import java.time.LocalDateTime;

public class LCGSimple {
    public static void main(String[] args) 
    {
        Scanner leer = new Scanner (System.in);
        LocalDateTime ahora = LocalDateTime.now();
        // Parámetros típicos de LCG
        long a = 1664525;
        long c = 1013904223;
        long m = (long) Math.pow(2, 32);
        long seed = ahora.getHour() + ahora.getMinute() + ahora.getSecond();
        int periodo = 3;

        // Generador Congruencial Lineal
        long x = seed;
        for (int i = 0; i < periodo; i++) {
            x = (a * x + c) % m;
        }
        System.out.println("\nNúmero pseudoaleatorio generado:"+ x);
        System.out.println("¿Deseas generar un nuevo numero? s/n");
        String res = leer.next();
        while (res.equals("s"))
        {
            ahora = LocalDateTime.now();
            seed = ahora.getHour() + ahora.getMinute() + ahora.getSecond();
            periodo = 3;
            x = seed;
            for (int i = 0; i < periodo; i++) 
            {
                x = (a * x + c) % m;
            }
            System.out.println("\nNúmero pseudoaleatorio generado:"+ x);
            System.out.println("¿Deseas generar un nuevo numero? s/n");
            res = leer.next();
        }
        
 }
}