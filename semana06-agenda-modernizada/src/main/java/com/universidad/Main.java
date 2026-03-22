package com.universidad;
import com.universidad.modelo.Contacto;
import com.universidad.exception.*;
import java.util.Scanner;
import com.universidad.servicio.AgendaContactos;
public class Main {
    static AgendaContactos agenda = new AgendaContactos();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do{
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1: agregarContacto();  break;
                case 2: listarContactos(); break;
                case 3: menuBusqueda(); break;
                case 4: eliminarContacto(); break;
                case 5: editarContacto(); break;
                case 6: estadistica(); break;
                case 7: System.out.println("hasta luego :)"); break;
                default: System.out.println("opcion no valida");
                    break;
            }
        } while (opcion != 7);
        sc.close();
    }

    static int leerOpcion() {
        try{
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    static void mostrarMenu() {
        System.out.println("\n === Agenda === ");
        System.out.println("1-. Agregar contacto");
        System.out.println("2-. Listar todos");
        System.out.println("3-. Buscar contacto");
        System.out.println("4-. Eliminar");
        System.out.println("5-. Editar contacto");
        System.out.println("6-. Estadisticas");
        System.out.println("7-. Salir");
        System.out.println("Elija una opcion: ");
    }

    static void agregarContacto() {
        try {
            
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Telefono: ");
            String tel = sc.nextLine();
            System.out.println("email: ");
            String email = sc.nextLine();
            System.out.println("Direccion");
            String dir = sc.nextLine();


            agenda.agregar(nombre, tel, email, dir);
            System.out.println("Contacto guardado: ");
        } catch (ContactoExistenteException e) {
            System.out.println("error: " + e.getMessage());
        } catch (DatoInvalidoException e){
            System.out.println("Dato invalido es '" + e.getMessage() + "': " + e.getMessage());
        }
    }

    static void listarContactos(){
        var lista = agenda.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay contactos");
            return;
        }
        System.out.println("\n=== CONTACTOS (" + lista.size() + ") ===");
        for (var c : lista) System.out.println(c);
    }

    static void buscarId() {
        System.out.println("ID a buscar: ");
        String id = sc.nextLine();
        try {
            System.out.println(agenda.buscar(id));
        } catch (ContactoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    static void eliminarContacto() {
        System.out.println("ID a eliminar: ");
        String id = sc.nextLine();
        try {
            agenda.eliminar(id);
            System.out.println("Contacto eliminado");
        } catch (ContactoNoEncontradoException e) {
            System.out.println(e.getMessage());

        }
    }

    static void editarContacto() {
        try {
            System.out.println("Id del contacto a editar");
            String id = sc.nextLine();
            System.out.println("nuevo telefono: ");  
            String tel = sc.nextLine();
            System.out.println("nuevo email: ");
            String email = sc.nextLine();
            agenda.editar(id, tel, email);
            System.out.println("Contacto actualizado");
        } catch(ContactoNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch(DatoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    static void estadistica() {
        System.out.println("=== estadisticas ===");
        int total = agenda.total();
        int conEmail = agenda.totalEmail();
        int sinEmail = total-conEmail;

        System.out.println("total contactos: " + total);
        System.out.println("Con email: " + conEmail);
        System.out.println("Sin email:" + sinEmail);

    }
    static void menuBusqueda() {
        System.out.println("\nBuscar por:");
        System.out.println("1. ID");
        System.out.println("2. Nombre");
        System.out.println("Opción: ");
        int op = leerOpcion();
        switch (op) {
            case 1: buscarId(); break;
            case 2: buscarNombre(); break;
            default: System.out.println("Opción inválida");
        }
    }

    static void buscarNombre() {
        System.out.println("Ingrese nombre o parte del nombre: ");
        String nombre = sc.nextLine();
        var resultados = agenda.buscarPorNombre(nombre);

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias");
            return;
        }
        System.out.println("\nResultados (" + resultados.size() + " encontrados):");
        for (var c : resultados) {
            System.out.println(c);
        }
    }
}