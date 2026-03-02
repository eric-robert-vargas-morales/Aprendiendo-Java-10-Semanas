import java.util.Scanner;
import java.util.InputMismatchException;
public class SistemaCalificaciones {
    static Scanner scanner = new Scanner(System.in);
    static String[] nombres = new String[50];
    static double[][] notas = new double[50][3];
    static double[] promedios = new double[50];
    static int totalEstudiantes = 0;
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CALIFICACIONES ===");
        int cantidad = leerEntero("¿Cuantos estudiantes desea ingresar? ");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nIngrese datos del estudiante " + (i + 1) + ":");
            scanner.nextLine();
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
            for (int j = 0; j < 3; j++) {
                notas[i][j] = leerNota("Nota " + (j + 1) + ": ");
            }
            promedios[i] = calcPromedio(notas[i]);
            totalEstudiantes++;
        }
        mostrarResultados();
        mostrarEstadisticas();
    }
    public static void mostrarResultados() {
        System.out.println("\n==================== RESULTADOS ====================");
        System.out.printf("%-15s %6s %6s %6s %8s %12s %n",
                "Nombre", "N1", "N2", "N3", "Prom", "Estado");
        System.out.println("-".repeat(60));
        for (int i = 0; i < totalEstudiantes; i++) {
            String estado = estaAprobado(promedios[i])
                    ? "APROBADO"
                    : "REPROBADO";
            System.out.printf("%-15s %6.0f %6.0f %6.0f %8.1f %12s %n",
                    nombres[i],
                    notas[i][0],
                    notas[i][1],
                    notas[i][2],
                    promedios[i],
                    estado);
        }
    }
    public static void mostrarEstadisticas() {
        System.out.println("\n========== ESTADISTICAS ==========");
        double suma = 0;
        double max = notas[0][0];
        double min = notas[0][0];
        int aprobados = 0;
        for (int i = 0; i < totalEstudiantes; i++) {
            suma += promedios[i];
            for (int j = 0; j < 3; j++) {
                if (notas[i][j] > max) max = notas[i][j];
                if (notas[i][j] < min) min = notas[i][j];
            }
            if (estaAprobado(promedios[i])) {
                aprobados++;
            }
        }
        double promedioGeneral = suma / totalEstudiantes;
        int reprobados = totalEstudiantes - aprobados;
        double porcentajeAprob = (aprobados * 100.0) / totalEstudiantes;
        double porcentajeReprob = (reprobados * 100.0) / totalEstudiantes;
        System.out.printf("Promedio general del curso: %.2f %n", promedioGeneral);
        System.out.printf("Nota mas alta: %.0f %n", max);
        System.out.printf("Nota mas baja: %.0f %n", min);
        System.out.printf("Aprobados: %d de %d (%.1f%%)%n",
                aprobados, totalEstudiantes, porcentajeAprob);
        System.out.printf("Reprobados: %d de %d (%.1f%%)%n",
                reprobados, totalEstudiantes, porcentajeReprob);
    }
    public static double calcPromedio(double[] notas) {
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }
    public static boolean estaAprobado(double prom) {
        return prom >= 51;
    }
    public static double leerNota(String msg) {
        double nota;
        do {
            nota = leerDouble(msg);
            if (nota < 0 || nota > 100) {
                System.out.println("Nota debe estar entre 0 y 100");
            }
        } while (nota < 0 || nota > 100);
        return nota;
    }
    public static int leerEntero(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int v = scanner.nextInt();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un numero valido");
                scanner.nextLine();
            }
        }
    }
    public static double leerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double v = scanner.nextDouble();
                return v;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un numero valido");
                scanner.nextLine();
            }
        }
    }
}
