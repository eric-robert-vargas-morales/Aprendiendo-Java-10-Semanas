import modelo.*;
import servicio.GestorVehiculos;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Vehiculo> flota = new ArrayList<>();
        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CB500", 2023, false));
        flota.add(new Camion("Volvo", "FH16", 2022, 24.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        flota.add(new MotoElectrica("NIU", "MQi+", 2023, 60));
        System.out.println("=== acelerar() en toda la flota ===");
        for (Vehiculo v : flota) {
            v.acelerar();   
        }

        GestorVehiculos gestor = new GestorVehiculos();
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
                    System.out.println("\nSeleccione tipo de vehiculo:");
                    System.out.println("1. Auto");
                    System.out.println("2. Moto");
                    System.out.println("3. Camion");
                    System.out.println("4. Auto Electrico");
                    System.out.println("5. Moto Electrica");
                    System.out.print("Opcion: ");

                    int tipo = sc.nextInt();

                    switch (tipo) {
                        case 1:
                            gestor.agregar(new Auto("Ford", "Focus", 2020, 4));
                            break;
                        case 2:
                            gestor.agregar(new Moto("Yamaha", "R3", 2022, false));
                            break;
                        case 3:
                            gestor.agregar(new Camion("Scania", "R500", 2021, 18.0));
                            break;
                        case 4:
                            gestor.agregar(new AutoElectrico("BYD", "Dolphin", 2024, 4, 50));
                            break;
                        case 5:
                            gestor.agregar(new MotoElectrica("SuperSoco", "TC", 2023, 40));
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    }
                    break;
                case 2:
                    gestor.listarTodos();
                    break;
                case 3:
                    System.out.println("\nFiltrar por:");
                    System.out.println("1. Auto");
                    System.out.println("2. Moto");
                    System.out.println("3. Camion");
                    System.out.println("4. Electrico");
                    System.out.print("Opcion: ");

                    int filtro = sc.nextInt();

                    switch (filtro) {
                        case 1:
                            gestor.listarPorTipo("auto");
                            break;
                        case 2:
                            gestor.listarPorTipo("moto");
                            break;
                        case 3:
                            gestor.listarPorTipo("camion");
                            break;
                        case 4:
                            gestor.listarPorTipo("electrico");
                            break;
                        default:
                            System.out.println("Opcion invalida.");
                    }
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