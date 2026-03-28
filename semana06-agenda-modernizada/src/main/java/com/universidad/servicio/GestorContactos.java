package com.universidad.servicio;

import com.universidad.modelo.Contacto;
import com.universidad.util.ManejadorJSON;
import com.universidad.exception.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.List;
import java.util.stream.*;

public class GestorContactos {
    private static final String ARCHIVO = "datos/contactos.json";
    private static final String BACKUP = "datos/contactos.backup.json";

    private ArrayList<Contacto> contactos;
    private int contadorId = 1;

    public GestorContactos(boolean usarArchivo) {
        if (usarArchivo) {
            contactos = ManejadorJSON.cargar(ARCHIVO);
        } else {
            contactos = new ArrayList<>();
        }
        contadorId = contactos.size() + 1;
    }

    
    public GestorContactos() {
        this(true);
    }
    
    private void persistir() {
        ManejadorJSON.guardarConBackup(contactos, ARCHIVO, BACKUP);
    }

    private String generarId() {
        return String.format("C%03d", contadorId++);
    }

    public void agregar(String nombre, String tel, String email, String dir, String cat)
            throws ContactoDuplicadoException {
            
        boolean existe = contactos.stream()
            .anyMatch(c -> c.getNombre()
                .equalsIgnoreCase(nombre));
        if (existe) {
            throw new ContactoDuplicadoException(nombre);
        }
    String id= generarId();
    Contacto c = new Contacto(id, nombre, tel, email, dir, cat);
    contactos.add(c);
    persistir();
    System.out.println("Contacto agregado con ID: " + id);
    }

    public Contacto buscar(String id)
            throws ContactoNoEncontradoException {
            return contactos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactoNoEncontradoException("No existe ID: " + id));
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

    public long totalEmail() {
        return contactos.stream()
            .filter(c -> c.getEmail() != null && !c.getEmail().isEmpty())
            .count();
    }

    public Optional<Contacto> buscarPorNombre(String nombre) {
        return contactos.stream()
                .filter(c -> c.getNombre()
                    .equalsIgnoreCase(nombre))
                .findFirst();
    }

    public ArrayList<String> obtenerNombres() {
        return contactos.stream()
                .map(Contacto::getNombre)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Contacto> filtrarPorCategoria(String cat) {
        return contactos.stream()
            .filter(c -> c.getCategoria().equalsIgnoreCase(cat))
            .collect(Collectors.toList());
    }
    
    public long contarPorCategoria(String categoria){
        return contactos.stream()
            .filter(c -> c.getCategoria()
                .equalsIgnoreCase(categoria))
            .count();
    }

    public List<Contacto> listarOrdenados() {
        return contactos.stream()
            .sorted(Comparator.comparing(Contacto::getNombre))
            .collect(Collectors.toList());

    }
}
