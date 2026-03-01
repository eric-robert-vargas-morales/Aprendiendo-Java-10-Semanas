package servicio;

import modelo.Tarea;
import java.util.ArrayList;

public class GestorTareas {

    private ArrayList<Tarea> tareas;
    private int proximoId;

    public GestorTareas() {
        tareas = new ArrayList<>();
        proximoId = 1;
    }

    public void agregar(String titulo, String descripcion) {
        Tarea nueva = new Tarea(proximoId, titulo, descripcion);
        tareas.add(nueva);
        System.out.println("Tarea agregada con ID: " + proximoId);
        proximoId++;
    }

    public void listar() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas");
            return;
        }

        for (Tarea t : tareas) {
            t.mostrarInfo();
        }
    }

    public void listarPendientes() {
        for (Tarea t : tareas) {
            if (!t.estaCompletada()) {
                t.mostrarInfo();
            }
        }
    }

    public void listarCompletadas() {
        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                t.mostrarInfo();
            }
        }
    }

    public Tarea buscar(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void completar(int id) {
        Tarea t = buscar(id);
        if (t != null) {
            t.completar();
        } else {
            System.out.println("ID no encontrado");
        }
    }

    public void eliminar(int id) {
        Tarea t = buscar(id);
        if (t != null) {
            tareas.remove(t);
            System.out.println("Tarea eliminada");
        } else {
            System.out.println("ID no encontrado");
        }
    }

    public int totalTareas() {
        return tareas.size();
    }

    public int totalCompletadas() {
        int contador = 0;
        for (Tarea t : tareas) {
            if (t.estaCompletada()) {
                contador++;
            }
        }
        return contador;
    }

    public int totalPendientes() {
        return totalTareas() - totalCompletadas();
    }
}