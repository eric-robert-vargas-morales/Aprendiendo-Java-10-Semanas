package com.universidad.exception;

public class ContactoDuplicadoException extends Exception {
    private String nombreDuplicado;

    public ContactoDuplicadoException(String nombre) {
        super("Error: Ya existe un contacto registrado con el nombre: " + nombre);
        this.nombreDuplicado = nombre;
    }

    public String getNombreDuplicado() {
        return nombreDuplicado;
    }
}
