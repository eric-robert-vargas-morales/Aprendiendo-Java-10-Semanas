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

    public ContactosView(){
        setSizeFull();
        setSpacing(true);

        H2 titulo = new H2("Contactos");
        Paragraph descripcion = new Paragraph("Gestiona todos tus contactos en un solo lugar");
        H3 subtitulo = new H3("Mis contactos");

        FlexLayout cuadricula = new FlexLayout();
        cuadricula.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        cuadricula.setWidthFull();

        cuadricula.add(new TarjetaContacto("Eric Vargas", "76150322", "eric69904@email.com"), 
                       new TarjetaContacto("Nashira Vargas", "75425232", "rnvm@email.com"), 
                       new TarjetaContacto("Valeria Vargas", "68334904", "valerianayeli@email.com"), 
                       new TarjetaContacto("Roberto Vargas", "73810967", "jrobertvn@email.com"), 
                       new TarjetaContacto("Jimena Morales", "72479272", "gjmm@email.com"));

        VerticalLayout contenido = new VerticalLayout(titulo, descripcion, subtitulo, cuadricula);
        contenido.setPadding(false);

        Div footer = new Div(new Span("Agenda de Contactos v1.0"));
        footer.setWidthFull();

        add(contenido, footer);
        expand(contenido);

    }
    
}
