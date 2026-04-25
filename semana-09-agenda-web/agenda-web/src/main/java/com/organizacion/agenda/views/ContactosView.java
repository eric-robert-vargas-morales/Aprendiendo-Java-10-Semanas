package com.organizacion.agenda.views;

import java.text.Normalizer.Form;

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

    public ContactosView(){

        campoNombre.setPlaceholder("Ej: Eric Vargas");
        campoEmail.setPlaceholder("Ej: eric@correo.com");
        campoTelef.setPlaceholder("Ej: 76150322");

        campoNombre.setWidthFull();
        campoEmail.setWidthFull();
        campoTelef.setWidthFull();

        FormLayout formulario = new FormLayout();
        formulario.add(campoNombre, campoEmail, campoTelef);
        formulario.setColspan(campoNombre, 2);
        formulario.setWidthFull();
        add(formulario);
        setWidthFull();

    }
    
}
