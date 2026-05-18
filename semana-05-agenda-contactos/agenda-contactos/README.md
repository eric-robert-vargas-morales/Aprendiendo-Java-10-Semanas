# Semana 5: Excepciones y JSON

Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar una agenda de contactos
Incluye funcionalidades para agregar, listar, buscar, editar y eliminar contactos, utilizando manejo de excepciones personalizadas y persistencia de datos en archivos JSON mediante la librería Gson

## Funcionalidades 
- Agregar contacto (ID generado automáticamente)
- Listar contactos
- Buscar contacto por ID
- Editar contacto
- Eliminar contacto
- Mostrar estadísticas
- Persistencia en JSON
- Backup automático
- Almacena los contactos en formato JSON

## Como ejecutar
1. Entrar a la carpeta `cd semana-05-agenda-contactos/AGENDA-CONTACTOS`
2. Compilar: `mvn compile`
3. Ejecutar: `mvn exec:java -Dexec.mainClass="com.tlaprendizaje.Main"`

## Tabla de excepciones
| Excepcion     |  Tipo |  Cuando sucede |
|---------------|:------:|:----------:|
| ContactoNoEncontradoException | Checked | Cuando se busca o elimina un contacto que no existe |
| ContactoExistenteException | Checked | Cuando se intenta agregar un contacto duplicado por id |
| DatoInvalidoException | Unchecked | Cuando los datos ingresados son invalidos (telefono, email, etc.) |

## Conceptos 
- Manejo de excepciones (try-catch)
- Excepciones personalizadas
- Checked, Unchecked
- Uso de Gson
- Persistencia de datos
- Programación orientada a objetos
