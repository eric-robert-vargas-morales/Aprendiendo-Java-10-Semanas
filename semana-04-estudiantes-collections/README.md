# Semana 4: Sistema de estudiantes con Collections

Sistema de gestión de estudiantes en Java utilizando el Collections Framework.
El programa permite registrar estudiantes, buscarlos por carnet, actualizar su promedio, eliminarlos, visualizar un ranking académico, consultar el top 5 de mejores estudiantes, filtrar por carrera y mostrar estadísticas del sistema.
Utilizando estructuras de datos como HashMap, TreeSet y ArrayList

## Funcionalidades 
- Registrar nuevos estudiantes
- Buscar un estudiante por su carnet
- Actualizar el promedio de un estudiante
- Eliminar un estudiante del sistema
- Mostrar el ranking completo de estudiantes
- Mostrar el Top 5 de estudiantes con mejor promedio
- Filtrar estudiantes por carrera
- Mostrar estadísticas generales del sistema
- Mostrar historial de operaciones realizadas

## Como ejecutar
1. Entrar a la carpeta: `cd semana-04-estudiantes-collection`
2. Compilar: `javac Main.java modelo/*.java servicio/*.java`
3. Ejecutar: `java Main`

|          Colección           |          Rol en el sistema        |	        Por qué se usa           |
|------------------------------|-----------------------------------|-------------------------------------|
| HashMap<String, Estudiante>  |Búsqueda de estudiantes por carnet | Permite encontrar un estudiante de forma instantánea usando su carnet como clave |
| TreeSet<Estudiante>          |Ranking automático de estudiantes  | Mantiene los estudiantes ordenados automáticamente por promedio    |
| ArrayList<String>            | Historial de operaciones          | Guarda el registro de acciones realizadas en el sistema        |


## Ejemplo salida del programa
```
=== SISTEMA DE ESTUDIANTES ===
1. Agregar Estudiante
2. Buscar por carnet
3. Actualizar promedio
4. Eliminar Estudiante
5. Ver ranking completo
6. Ver top 5
7. Filtrar por carrera
8. Estadisticas
9. Historial
0. Salir
```