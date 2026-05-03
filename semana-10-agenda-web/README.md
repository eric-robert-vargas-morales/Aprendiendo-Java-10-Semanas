# Semana 10: Vaadin la agenda completa 

Esta aplicacion desarrollada a lo largo de 4 semanas diseñado para organizar contactos y eventos de manera eficiente
El usuario puede ingresar nombre, correo electronico, telefono, titulo de evento, fecha de evento y descripcion de evento

## Diagrama ASCII
```
ContactosView           EventosView
      |                       |
      v                       v
ContactoService         EventoService       <- @Service
      |                       |
      v                       v
ManejadorJSON           ManejadorJSON
      |                       |
      v                       v
contactos.json          eventos.json
```

## Flujo de datos
- Views-. contiene las vistas con las que interactua el usuario, en las que se encuentra los componentes vaadin hasta presionar guardar
- Service-. La vista llama al metodo guardar del servicio donde se aplica la logica de validacion
- ManejadorJSON-. el servicio delega la persistencia al manejador generico que convierte la lista de objetos a formato JSON
- JSON-. Finalmente la libreria GSON escribe los datos fisicamente en el archivo del disco duro

## Como ejecutar 
1. Entrar a la carpeta `cd semana-10-agenda-web/agenda-web`
2. Realizar los test `mvn test`
3. Compilar con `mvn compile`
4. Correr con `mvn spring-boot:run`
5. Ejecutar en el navegador `localhost:8080`

## Ejemplo vista JSON Contactos
```
[
  {
    "nombre": "juan perez",
    "telefono": "75426242",
    "email": "perez@gmail.com"
  },
  {
    "nombre": "eric vargas",
    "telefono": "76150322",
    "email": "eric69904@gmail.com"
  },
  {
    "nombre": "jose felipino",
    "telefono": "61234567",
    "email": "jose@gmail.com"
  },
  {
    "nombre": "Roberto Vargas",
    "telefono": "73810967",
    "email": "roberto@gmail.com"
  }
]
```

## Ejemplo vista JSON Eventos
```
[
  {
    "titulo": "Conferencia",
    "fecha": "2026-10-10",
    "descripcion": "Charla tecnica"
  },
  {
    "titulo": "presentacion de proyecto",
    "fecha": "2026-05-10",
    "descripcion": "debo de entregar mi proyecto de fisica 3 completo impreso y en digital"
  }
]
```

## Capturas
![Inicio](capturas/Inicio.png)
![Contactos](capturas/Contactos.png)
![Eventos](capturas/Eventos.png)
