import modelo.*;
import servicio.GestorVehiculos;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // === DEMOSTRACION DE POLIMORFISMO (RF6) ===
        // ==========================================

        ArrayList<Vehiculo> flota = new ArrayList<>();

        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CB500", 2023, false));
        flota.add(new Camion("Volvo", "FH16", 2022, 24.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        flota.add(new MotoElectrica("NIU", "MQi+", 2023, 60));

        System.out.println("=== acelerar() en toda la flota ===");

        for (Vehiculo v : flota) {
            v.acelerar();   // Cada objeto ejecuta su propia version
        }

        // ==========================================
        // ============ MENU INTERACTIVO ============
        // ==========================================

        GestorVehiculos gestor = new GestorVehiculos();

        // Cargamos algunos vehiculos iniciales al gestor
        gestor.agregar(new Auto("Toyota", "Corolla", 2024, 4));
        gestor.agregar(new Moto("Honda", "CB500", 2023, false));
        gestor.agregar(new Camion("Volvo", "FH16", 2022, 24.0));
        gestor.agregar(new AutoElectrico("Tesla", "Model 3", 2024, 4, 15));
        gestor.agregar(new MotoElectrica("NIU", "MQi+", 2023, 10));

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== GESTION DE VEHICULOS ===");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Listar todos");
            System.out.println("3. Filtrar por tipo");
            System.out.println("4. Ver electricos y baterias");
            System.out.println("5. Cargar baterias bajas");
            System.out.println("6. Demostrar polimorfismo");
            System.out.println("7. Estadisticas");
            System.out.println("8. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Tipo (auto/moto/camion/autoE/motoE): ");
                    String tipo = sc.next();

                    if (tipo.equalsIgnoreCase("auto")) {
                        gestor.agregar(new Auto("Ford", "Focus", 2020, 4));
                    }
                    else if (tipo.equalsIgnoreCase("moto")) {
                        gestor.agregar(new Moto("Yamaha", "R3", 2022, false));
                    }
                    else if (tipo.equalsIgnoreCase("camion")) {
                        gestor.agregar(new Camion("Scania", "R500", 2021, 18.0));
                    }
                    else if (tipo.equalsIgnoreCase("autoE")) {
                        gestor.agregar(new AutoElectrico("BYD", "Dolphin", 2024, 4, 50));
                    }
                    else if (tipo.equalsIgnoreCase("motoE")) {
                        gestor.agregar(new MotoElectrica("SuperSoco", "TC", 2023, 40));
                    }
                    break;

                case 2:
                    gestor.listarTodos();
                    break;

                case 3:
                    System.out.print("Ingrese tipo (auto/moto/camion/electrico): ");
                    String filtro = sc.next();
                    gestor.listarPorTipo(filtro);
                    break;

                case 4:
                    gestor.listarElectricos();
                    break;

                case 5:
                    gestor.cargarElectricosNecesarios();
                    break;

                case 6:
                    gestor.demostrarPolimorfismo();
                    break;

                case 7:
                    gestor.mostrarEstadisticas();
                    break;

                case 8:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 8);

        sc.close();
    }
}