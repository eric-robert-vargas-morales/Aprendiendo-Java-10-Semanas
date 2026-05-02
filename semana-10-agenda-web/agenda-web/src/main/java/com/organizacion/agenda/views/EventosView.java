package com.organizacion.agenda.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

import com.organizacion.agenda.modelo.Evento;
import com.organizacion.agenda.service.EventoService;

@Route(value = "eventos", layout = MainLayout.class)
public class EventosView extends VerticalLayout {

    private final EventoService servicio;

    private TextField campoTitulo = new TextField("Titulo");
    private DatePicker campoFecha = new DatePicker("Fecha");
    private TextField campoDescripcion = new TextField("Descripcion");
    private Binder<Evento> binder = new Binder<>(Evento.class);
    private Grid<Evento> grid = new Grid<>(Evento.class, false);
    private Evento eventoEditando = null;

    public EventosView(EventoService servicio) {
        this.servicio = servicio;
        configurarCampos();
        configurarBinder();
        configurarGrid();

        FormLayout formulario = new FormLayout();
        formulario.add(campoTitulo, campoFecha, campoDescripcion);
        formulario.setColspan(campoDescripcion, 2);
        formulario.setWidthFull();
        Button btnGuardar = new Button("Guardar", e -> guardar());
        Button btnLimpiar = new Button("Limpiar", e -> limpiar());
        Button btnEliminar = new Button("Eliminar", e -> eliminar());
        btnEliminar.getThemeNames().add("error");

        add(new H2("Eventos"), formulario,new HorizontalLayout(btnGuardar, btnLimpiar, btnEliminar), grid);
        setWidthFull();
        refrescarGrid();
    }

    private void configurarCampos() {
        campoTitulo.setPlaceholder("Ej: Reunion con Ana");
        campoDescripcion.setPlaceholder("Ej: Presentacion del proyecto");
        campoTitulo.setWidthFull();
        campoFecha.setWidthFull();
        campoDescripcion.setWidthFull();
    }

    private void configurarBinder() {
        binder.forField(campoTitulo)
            .asRequired("El titulo no puede estar vacio")
            .bind(Evento::getTitulo, Evento::setTitulo);
        binder.forField(campoFecha)
            .asRequired("La fecha es obligatoria")
            .withConverter(
                f -> f == null ? "" : f.toString(),
                t -> (t == null || t.isEmpty())
                        ? null : java.time.LocalDate.parse(t)
            )
            .bind(Evento::getFecha, Evento::setFecha);
        binder.forField(campoDescripcion)
            .bind(Evento::getDescripcion, Evento::setDescripcion);
    }

    private void configurarGrid() {
        grid.addColumn(Evento::getTitulo)
            .setHeader("Titulo").setSortable(true).setFlexGrow(2);
        grid.addColumn(Evento::getFecha)
            .setHeader("Fecha").setSortable(true).setFlexGrow(1);
        grid.addColumn(Evento::getDescripcion)
            .setHeader("Descripcion").setFlexGrow(2);
        grid.setWidthFull();
        grid.setHeight("260px");

        grid.asSingleSelect().addValueChangeListener(e -> {
            Evento ev = e.getValue();
            if(ev != null) {
                binder.readBean(ev);
                eventoEditando = ev;
            }
        });
    }

    private void guardar() {
        Evento evento = eventoEditando != null ? eventoEditando : new Evento();
        try {
            binder.writeBean(evento);
            servicio.guardar(evento);
            Notification.show("Guardado" + evento.getTitulo());
            limpiar();
        } catch (ValidationException e) { }
    }

    private void eliminar() {
        if (eventoEditando == null) {
            Notification.show("Selecciona un evento del listado");
            return;
        }
        ConfirmDialog dialogo = new ConfirmDialog();
        dialogo.setHeader("Eliminar evento");
        dialogo.setText("Eliminar " + eventoEditando.getTitulo() + "?");
        dialogo.setConfirmText("Eliminar");
        dialogo.setConfirmButtonTheme("error primary");
        dialogo.setCancelable(true);
        dialogo.addConfirmListener(e -> {
            servicio.eliminar(eventoEditando);
            refrescarGrid();
            limpiar();
            Notification.show("Evento eliminado");
        });
        dialogo.open();
    }

    private void limpiar() {
        binder.readBean(new Evento());
        eventoEditando = null;
        grid.asSingleSelect().clear();
    }

    private void refrescarGrid() {
        grid.setItems(servicio.obtenerTodos());
    }
}
