package servicio;

import org.junit.jupiter.api.*;

import com.universidad.exception.*;
import com.universidad.modelo.Contacto;
import com.universidad.servicio.GestorContactos;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class GestorContactosTest {
    
    private GestorContactos gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorContactos(false);
        try {
            gestor.agregar("Ana Lopez", "76543210", "ana@mail.com", "Calle 1", "Amigos");
            gestor.agregar("Carlos Rios", "71112233", "carlos@mail.com", "Calle 2", "Trabajo");
            gestor.agregar("Beatriz Vega", "68881234", "beatriz@mail.com", "Calle 3", "Trabajo");
            gestor.agregar("David Cruz", "72223344", "david@mail.com", "Calle 4", "Familia");
        } catch (ContactoDuplicadoException e) {
            fail("setUp no deberai lanzar exception: " + e.getMessage());
        }
    }

    @Test
    void buscarPorNombreEncuentraContactoExistente() {
        Optional<Contacto> resultado = gestor.buscarPorNombre("Ana Lopez");

        assertTrue(resultado.isPresent());
        assertEquals("76543210", resultado.get().getTelefono
            ());
    }

    @Test
    void buscarPorNombreRetornaVacioSiNoExiste() {
        Optional<Contacto> resultado = gestor.buscarPorNombre("Nombre Inexistente");

        assertFalse(resultado.isPresent());
    }

    @Test
    void filtrarPorCategoriaDevuelveSoloLosCorrectos() {
        List<Contacto> trabajo =
            gestor.filtrarPorCategoria("Trabajo");

        assertEquals(2, trabajo.size());
        assertTrue(trabajo.stream().allMatch(
            c-> c.getCategoria().equalsIgnoreCase("Trabajo")
                ));
    }

    @Test
    void obtenerNombresDevuelveTodosLosNombres() {
        List<String> nombres = gestor.obtenerNombres();

        assertEquals(4, nombres.size());
        assertTrue(nombres.contains("Ana Lopez"));
        assertTrue(nombres.contains("Carlos Rios"));
    }

    @Test
    void contarPorCategoriaRetornaCantidadCorrecta() {
        long totalTrabajo = gestor.contarPorCategoria("Trabajo");
        long totalFamilia = gestor.contarPorCategoria("Familia");

        assertEquals(2, totalTrabajo);
        assertEquals(1, totalFamilia);
    }

    @Test
    void agregarContactoDuplicadoLanzaExcepcion() {
        assertThrows(ContactoDuplicadoException.class, ()->
        {
        gestor.agregar("Ana Lopez", "9999999", "ana@gmail.com","AV 6 de agosto", "Trabajo");
        });
    }
}
