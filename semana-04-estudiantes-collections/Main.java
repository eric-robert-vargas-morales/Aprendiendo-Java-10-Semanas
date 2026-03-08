import modelo.Estudiante;
import servicio.GestorEstudiantes;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GestorEstudiantes gestor=new GestorEstudiantes();

        cargarDatosPrueba(gestor);
        int opcion;
        do{
            System.out.println("\n=== SISTEMA DE ESTUDIANTES ===");
            System.out.println("1 Agregar Estudiante");
            System.out.println("2. Buscar por carnet");
            System.out.println("3. Actualizar promedio");
            System.out.println("4. Eliminar Estudiante");
            System.out.println("5. Ver ranking completo");
            System.out.println("6. ver top 5");
            System.out.println("7. Filtrar por carrera");
            System.out.println("8. Estadisticas");
            System.out.println("9. Historial");
            System.out.println("0. Salir ");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch (opcion) {
                case 1: agrearEstudiante(sc, gestor); break;
                case 2: buscarEstudiante(sc, gestor); break;
                case 3: actualizarPromedio(sc, gestor); break;
                case 4: eliminarEstudiante(sc, gestor); break;
                case 5: gestor.mostrarRanking(); break;
                case 6: gestor.mostrarTop5(); break;
                case 7: 
                    System.out.println("Carrera: ");
                    gestor.filtrarPorCarrera(sc.nextLine());
                break;
                case 8: gestor.mostrarEstadisticas(); break;
                case 9: gestor.mostrarHistorial(); break;
                case 0: System.out.println("Hasta luego");
                break;
                default: System.out.println("opcion invalida");
            
            }
        } while (opcion!=0);
        sc.close();
    }

    private static void agrearEstudiante(Scanner sc, GestorEstudiantes g){
        System.out.println("Carnet  :"); String carnet=sc.nextLine();
        System.out.println("Nombre  :"); String nombre=sc.nextLine();
        System.out.println("Carrera :"); String carrera=sc.nextLine();
        System.out.println("Promedio:"); double prom=sc.nextDouble();
        sc.nextLine();
        boolean ok=g.agregar(new Estudiante(carnet, nombre, carrera, prom));
        System.out.println(ok ? "Estudiante registrado" : "Error: carnet ya existe");
    }

    private static void buscarEstudiante(Scanner sc, GestorEstudiantes g){
        System.out.println("Carnet    :"); String carnet=sc.nextLine();
        System.out.println("Nuevo pro :"); double prom=sc.nextDouble();
        sc.nextLine();
        boolean ok=g.actualizarPromedio(carnet, prom);
        System.out.println(ok ? "Promedio actualizado" : "Carnet no encontrado");
    }

    private static void cargarDatosPrueba(GestorEstudiantes g){
        g.agregar (new Estudiante ("2021001","Ana Torres", "Sistemas" ,75.5) );
        g.agregar (new Estudiante ("2021002","Carlos Quispe", "Industrial" ,88.0) );
        g.agregar (new Estudiante ("2021003","Maria Condori", "Sistemas" ,92.3) );
        g.agregar (new Estudiante ("2021004 ","Luis Mamani", "Civil" ,61.0) );
        g.agregar (new Estudiante ("2021005","Rosa Flores", "Industrial" ,79.5) );
        g.agregar (new Estudiante ("2021006","Pedro Vargas", "Sistemas" ,55.0) );
        g.agregar (new Estudiante ("2021007","Silvia Choque", "Civil" ,83.5) );
        g.agregar (new Estudiante ("2021008","Hugo Espejo", "Industrial" ,70.0) );
        g.agregar (new Estudiante ("2021009 ","Patricia Lima", "Sistemas" ,95.0) );
        g.agregar (new Estudiante ("2021010 ","Diego Arce", "Civil" ,67.5) );
    }
    
}
