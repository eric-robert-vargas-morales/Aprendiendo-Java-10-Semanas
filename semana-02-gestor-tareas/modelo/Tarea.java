package modelo;

public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private String estado; // PENDIENTE o COMPLETADA

    // Constructor
    public Tarea(int id, String titulo, String descripcion) {
        this.id = id;
        setTitulo(titulo);
        setDescripcion(descripcion);
        this.estado = "PENDIENTE";
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    // Setters con validación
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            System.out.println("Titulo invalido");
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("Descripcion invalida");
        }
    }

    // Método para completar tarea
    public void completar() {
        if (estado.equals("COMPLETADA")) {
            System.out.println("La tarea ya esta completada");
        } else {
            estado = "COMPLETADA";
            System.out.println("Tarea completada correctamente");
        }
    }

    public boolean estaCompletada() {
        return estado.equals("COMPLETADA");
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | " + estado);
        System.out.println("Titulo: " + titulo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("----------------------------------");
    }
}