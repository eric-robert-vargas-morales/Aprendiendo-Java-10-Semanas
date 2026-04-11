package com.organizacion.agenda.views;

import com.organizacion.agenda.ui.MainLayout;
import com.organizacion.agenda.ui.TarjetaContacto;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "contactos", layout = MainLayout.class)
public class ContactosView extends VerticalLayout {

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
