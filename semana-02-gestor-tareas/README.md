# Semana 2: gestor de tareas

Permite gestionar tareas utilizando los principios de Programación Orientada a Objetos

El sistema permite crear, listar, completar y eliminar tareas.

Se aplican conceptos como:
- Clases y objetos
- Encapsulamiento
- ArrayList
- Packages
- Separación modelo/servicio

## Funcionalidades
- Crear tareas con ID automático  
- Listar todas las tareas  
- Listar tareas pendientes  
- Listar tareas completadas  
- Marcar una tarea como completada  
- Eliminar tarea por ID  
- Mostrar estadísticas
- Menú interactivo repetitivo 

## Como ejecutar
1. Entrar a la carpeta: ‘cd semana-02-gestor-tareas‘
2. Compilar: 'javac Main.java modelo/*.java servicio/*.java'
3. Ejecutar: 'java Main'

## Diagrama simple de clases
+--------------------+
| Tarea              |
+--------------------+
| id:int             |
| titulo:String      |
| descripcion:String |
| estado:String      |
+--------------------+
| completar()        |
| mostrarInfo()      |
| estaCompletada()   |
| getters/setters    |
+--------------------+
+--------------------+
| GestorTareas       |
+--------------------+
| tareas:ArrayList   |
| proximoId:int      |
+--------------------+
| agregar()          |
| listar()           |
| completar()        |
| eliminar()         |
| buscar()           |
| estadisticas()     |
+--------------------+