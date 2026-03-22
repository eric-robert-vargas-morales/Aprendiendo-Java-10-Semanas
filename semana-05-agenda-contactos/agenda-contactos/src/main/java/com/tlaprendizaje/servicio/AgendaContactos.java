package com.tlaprendizaje.servicio;

import com.tlaprendizaje.exception.*;
import com.tlaprendizaje.modelo.Contacto;
import com.tlaprendizaje.util.ManejadorJSON;
import java.util.ArrayList;
public class AgendaContactos {
    private static final String ARCHIVO = "data/contactos.json";
    private static final String BACKUP = "data/contactos.backup.json";

    private ArrayList<Contacto> contactos;
    private int contadorId = 1;

    public AgendaContactos(){
        contactos = ManejadorJSON.cargar(ARCHIVO);
        contadorId = contactos.size() + 1;
        System.out.println("Agenda cargada con " + contactos.size() + " contactos ");

    }
    
    private void persistir() {
        ManejadorJSON.guardarConBackup(contactos, ARCHIVO, BACKUP);
    }

    private String generarId() {
        return String.format("C%03d", contadorId++);
    }

    public void agregar(String nombre, String tel, String email, String dir)
            throws ContactoExistenteException {

    String id = generarId();

    Contacto c = new Contacto(id, nombre, tel, email, dir);
    contactos.add(c);
    persistir();
    System.out.println("Contacto agregado con ID: " + id);
    }

    public Contacto buscar(String id)
            throws ContactoNoEncontradoException {
                for (Contacto c : contactos){
                    if (c.getId().equals(id)) return c;
                }
            throw new ContactoNoEncontradoException("No existe contacto con ID: " + id);
            }

    public void eliminar(String id)
            throws ContactoNoEncontradoException {
                Contacto c = buscar(id);
                contactos.remove(c);
                persistir();
    }

    public void editar(String id, String tel, String email)
            throws ContactoNoEncontradoException {
                Contacto c = buscar(id);
                c.setTelefono(tel);
                c.setEmail(email);
                persistir();
            }

    public ArrayList<Contacto> listarTodos() {
        return new ArrayList<>(contactos);
    }

    public int total() {
        return contactos.size();
    }

    public int totalEmail() {
        int contar = 0;
        for (Contacto c : contactos) {
            if (c.getEmail() != null && !c.getEmail().isEmpty())
                contar++;
        }
        return contar;
    }

    public ArrayList<Contacto> buscarPorNombre(String nombre) {
        ArrayList<Contacto> resultados = new ArrayList<>();
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(c);
            }
        }
        return resultados;
    }
}
