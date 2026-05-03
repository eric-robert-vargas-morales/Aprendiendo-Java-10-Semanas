package com.organizacion.agenda.service;

import com.organizacion.agenda.modelo.Evento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class EventoServiceTest {

    public EventoServiceTest() {
    }

    @Test
    public void testGuardarEvento() {
        EventoService servicio = new EventoService();
        Evento ev = new Evento("Conferencia", "2026-10-10", "Charla tecnica");
        
        servicio.guardar(ev);
        List<Evento> resultados = servicio.obtenerTodos();
        
        assertNotNull(resultados);
        assertTrue(resultados.stream().anyMatch(e -> e.getTitulo().equals("Conferencia")));
    }

    @Test
    public void testEliminarEvento() {
        EventoService servicio = new EventoService();
        Evento ev = new Evento("Cita Medica", "2026-11-11", "Revision");
        
        servicio.guardar(ev);
        servicio.eliminar(ev);
        List<Evento> resultados = servicio.obtenerTodos();
        
        assertFalse(resultados.stream().anyMatch(e -> e.getTitulo().equals("Cita Medica")));
    }
}