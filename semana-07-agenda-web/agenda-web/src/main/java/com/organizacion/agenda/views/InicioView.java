package com.organizacion.agenda.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Route("")
public class InicioView extends VerticalLayout{

    public InicioView(){
        H1 titulo = new H1("Hola eric");
        add(titulo);
    }
}
