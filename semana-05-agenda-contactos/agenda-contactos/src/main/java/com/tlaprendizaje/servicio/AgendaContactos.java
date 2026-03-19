package com.tlaprendizaje.servicio;

import com.tlaprendizaje.exception.*;
import com.tlaprendizaje.modelo.Contacto;
import com.tlaprendizaje.util.ManejadorJSON;
import java.util.ArrayList;
public class AgendaContactos {
    private static final String ARCHIVO = "data/contactos.json";
    private static final String BACKUP = "data/contactos.backup.json";

    private ArrayList<Contacto> contactos;

    public AgendaContactos(){
        contactos = ManejadorJSON.cargar(ARCHIVO);
        System.out.println("Agenda cargada con " + contactos.size() + " contactos ");

    }
    
    private void persistir() {
        ManejadorJSON.guardarConBackup(contactos, ARCHIVO, BACKUP);
    }

    public void agregar(Contacto c)
            throws ContactoExistenteException {
                for (Contacto existente : contactos) {
                    if (existente.getId().equals(c.getId())) {
                        throw new ContactosExistentesException(c.getId());
                    }
                }
                contactos.add(c);
                persistir();
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

    public ArrayList<Contacto> listarTodos() {
        return new ArrayList<>(contactos);
    }

    public int total() {
        return contactos.size();
    }
}
