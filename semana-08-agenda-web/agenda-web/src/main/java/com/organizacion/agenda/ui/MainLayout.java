package com.organizacion.agenda.ui;

import com.organizacion.agenda.views.ContactosView;
import com.organizacion.agenda.views.InicioView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;


public class MainLayout extends AppLayout {

    public MainLayout() {
        H2 titulo = new H2("Agenda de Contactos");

        

        addToNavbar(titulo);

    }
    
}
