import java.time.LocalDateTime; // Importa clase para obtener la hora actual
import java.util.Random;  // Importa clase para generar números aleatorios
import java.util.Scanner;       // Importa clase para leer entrada del usuario


public class Aleatorio
{
    // Método principal que gestiona la interacción con el usuario
    public static void numeroAleatorio()
    {
        Scanner sc = new Scanner(System.in); // Crea objeto Scanner para leer entrada
        System.out.print("Ingresa el primer número del rango: ");
        int inicio = sc.nextInt(); // Límite inferior del rango
        System.out.print("Ingresa el segundo número del rango: ");
        int fin = sc.nextInt();    // Límite superior del rango
       
        boolean continuar = true;  // Controla si se sigue generando números
        int contador = 1;          // Lleva cuenta de cuántos números se han generado
       
        while (continuar) {
            int NumeroGenerado = Generar(inicio, fin); // Genera número aleatorio
            while (NumeroGenerado < inicio || NumeroGenerado > fin)
            {
                NumeroGenerado = Generar(inicio, fin); // Reintenta si está fuera del rango
            }
            System.out.println("\nNúmero " + contador + ": " + NumeroGenerado);
           
            System.out.print("¿Deseas generar otro número? (s/n): ");
            String respuesta = sc.next().toLowerCase(); // Convierte respuesta a minúsculas
           
            if (respuesta.equals("n") || respuesta.equals("no")) {
                continuar = false; // Termina el ciclo si el usuario no quiere continuar
                System.out.println("¡Hasta luego!");
            }
            contador++; // Incrementa el contador de números generados
        }
    }
    // Método que genera un número aleatorio dentro del rango usando lógica personalizada
    public static int Generar(int inicio, int fin)
    {
        Random random = new Random(); // Crea generador aleatorio
        int semilla = 9;              // Valor base para la fórmula personalizada
        int numeroal = 0;             // Número generado
        boolean valido = false;       // Controla si el número generado es válido
       
        while (!valido)          
        {
            int cifrasFin = (int) Math.log10(Math.abs(fin)) + 1; // Calcula cuántas cifras tiene el número máximo
            int cifrasElegidas = 1 + random.nextInt(cifrasFin);  // Elige aleatoriamente cuántas cifras tendrá el número
            int minimo = (int) Math.pow(10, cifrasElegidas - 1); // Calcula el mínimo para esa cantidad de cifras
            int maximo = (int) Math.pow(10, cifrasElegidas) - 1; // Calcula el máximo para esa cantidad de cifras
           
            if (cifrasElegidas == 1)
            {
                minimo = 1; // Asegura que el mínimo sea al menos 1 si se elige una sola cifra
            }
            if (maximo > fin)
            {
                maximo = fin; // Ajusta el máximo si excede el límite superior
            }
            if (minimo < inicio)
            {
                minimo = inicio; // Ajusta el mínimo si está por debajo del límite inferior
            }
            if (minimo <= maximo)
            {
                LocalDateTime ahora = LocalDateTime.now(); // Obtiene la hora actual
                int h = ahora.getHour();   // Hora
                int m = ahora.getMinute(); // Minutos
                int s = ahora.getSecond(); // Segundos
                int hora = h + m + s;      // Suma total de tiempo actual
                int base = semilla * hora; // Multiplica por semilla para obtener base
                int al = (base + 19) / 5;  // Fórmula personalizada para generar número
                numeroal = minimo + (Math.abs(al) % (maximo - minimo + 1)); // Ajusta número dentro del rango
                valido = true; // Marca como válido para salir del ciclo
            }
        }
        return numeroal; // Devuelve el número generado
    }
   
    // Método main que inicia el programa
    public static void main(String[] args)
    {
        numeroAleatorio(); // Llama al método principal
    }
}
