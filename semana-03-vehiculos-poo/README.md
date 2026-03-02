# Semana 3: Gestion de vehiculos

Sistema de gestión de una flota de vehículos utilizando Programación Orientada a Objetos en Java  
El sistema permite registrar distintos tipos de vehículos (autos, motos, camiones y vehículos eléctricos), aplicar herencia, polimorfismo e interfaces, y gestionarlos mediante un menú interactivo en consola

Se aplica conceptos como:
- Herencia
- Clases abstractas
- Polimorfismo
- Interfaces
- Uso de ArrayList con tipo padre

## Funcionalidades

- Registrar vehículos  
- Listar toda la flota  
- Filtrar por tipo (auto, moto, camion, electrico)  
- Mostrar nivel de batería de eléctricos  
- Cargar batería si está por debajo del 20%  
- Demostración explícita de polimorfismo  
- Mostrar estadísticas (total, eléctricos, necesitan carga)

## Como ejecutar
1. Entrar a la carpeta: ‘cd semana-03-vehiculos-poo‘
2. Compilar: 'javac Main.java modelo/*.java servicio/*.java'
3. Ejecutar: 'java Main'

## Decision de diseño
- ¿Por qué Vehiculo es abstracta?
Porque no tiene sentido crear un "Vehiculo" genérico.
Solo existen tipos específicos como Auto, Moto o Camion.  
Además, obliga a que todas las clases hijas implementen el método acelerar().

- ¿Por qué Electrico es una interfaz y no una clase?
Porque no todos los vehículos son eléctricos, pero algunos pueden serlo.  
La interfaz permite que distintas clases (AutoElectrico y MotoElectrica) compartan comportamiento sin romper la jerarquía principal.
Permitiendo:
- Mantener una sola jerarquía de herencia.
- Implementar múltiples comportamientos si fuera necesario.

## Diagrama de clases 

                     [Vehiculo]    (Abstract)
                         |
        +----------------+---------------+
        |                |               |
     [Auto]           [Moto]          [Camion]
        |                |
 [AutoElectrico]  [MotoElectrica]
        |                |
        +----------------+
                |
          <<Electrico>>  (interface)

## Ejemplo Salida programa 
=== GESTION DE VEHICULOS ===
1. Agregar vehiculo
2. Listar todos
3. Filtrar por tipo
4. Ver electricos y baterias
5. Cargar baterias bajas
6. Demostrar polimorfismo
7. Estadisticas
8. Salir
Opcion: