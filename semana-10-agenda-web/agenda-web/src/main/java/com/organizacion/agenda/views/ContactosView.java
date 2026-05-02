package com.organizacion.agenda.views;


import com.organizacion.agenda.modelo.Contacto;
import com.organizacion.agenda.service.ContactoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {

    private final ContactoService servicio;

    private TextField campoNombre = new TextField("nombre completo");
    private EmailField campoEmail = new EmailField("correo electronico");
    private NumberField campoTelef = new NumberField("telefono");

    private Binder<Contacto> binder = new Binder<>(Contacto.class);
    public ContactosView(ContactoService servicio) {
        this.servicio = servicio;

        campoNombre.setPlaceholder("Ej: Eric Vargas");
        campoEmail.setPlaceholder("Ej: eric@correo.com");
        campoTelef.setPlaceholder("Ej: 76150322");

        campoNombre.setWidthFull();
        campoEmail.setWidthFull();
        campoTelef.setWidthFull();

        configurarBinder();

        FormLayout formulario = new FormLayout();
        formulario.add(campoNombre, campoEmail, campoTelef);
        formulario.setColspan(campoNombre, 2);
        formulario.setWidthFull();

        Button btnGuardar = new Button("Guardar Contacto");
        Button btnLimpiar = new Button("Limpiar");

        btnGuardar.addClickListener(e -> guardar());
        btnLimpiar.addClickListener(e -> limpiar());

        HorizontalLayout botones = new HorizontalLayout(btnGuardar, btnLimpiar);
        add(formulario, botones);
        setWidthFull();

    }

    private void configurarBinder(){
        binder.forField(campoNombre)
            .asRequired("El nombre no puede estar vacio")
            .bind(Contacto::getNombre, Contacto::setNombre);

        binder.forField(campoEmail)
            .bind(Contacto::getEmail, Contacto::setEmail);

        binder.forField(campoTelef)
            .withConverter(
                v -> v == null ? "" : String.valueOf(v.intValue()),
                t -> t == null || t.isEmpty() ? null : Double.valueOf(t)
            )
            .bind(Contacto::getTelefono, Contacto::setTelefono);
    }

    private void guardar(){
        Contacto contacto = new Contacto();
        try{
            binder.writeBean(contacto);
            servicio.guardar(contacto);
            Notification.show("Guardado: " + contacto.getNombre());
            limpiar();
        } catch (ValidationException e){
            
        }
    }

    private void limpiar(){
        binder.readBean(new Contacto());
    }

    
}
