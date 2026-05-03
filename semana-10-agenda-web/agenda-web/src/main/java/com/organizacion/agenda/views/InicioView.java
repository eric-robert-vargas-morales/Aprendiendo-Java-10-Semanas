package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout{

    public InicioView(){
        setSizeFull();
        setPadding(true);

        VerticalLayout contenido = new VerticalLayout();
        contenido.setPadding(false);
        contenido.setAlignItems(FlexComponent.Alignment.START);

        H2 titulo = new H2("Bienvenido a tu Agenda");
        
        Paragraph descripcion =  new Paragraph("Guarda y organiza tus contactos en un solo lugar. " + "Busca por nombre, agrega nuevos contactos y " + "manten tu lista siempre actualizada");

        H3 instruccion = new H3("Usa el menu superior para navegar");

        contenido.add(titulo, descripcion, instruccion);

        Div footer = new Div(new Span("Agenda de contactos definitiva"));
        footer.setWidthFull();

        add(contenido, footer);
        expand(contenido);
    }
}
