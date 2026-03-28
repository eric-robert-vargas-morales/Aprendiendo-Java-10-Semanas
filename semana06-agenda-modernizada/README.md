# Semana 6: Java Moderno + Testing

Este proyecto consiste en una aplicación de consola desarrollada en Java que permite gestionar una agenda de contactos
Se implementan el uso de Streams, Optional y manejo de excepciones

## Funcionalidades

- Agregar contacto
- Listar contactos
- Buscar por ID
- Buscar por nombre
- Editar contacto
- Eliminar contacto
- Listar contactos ordenados por nombre
- Filtrar contactos por categoría
- Contar contactos por categoría
- Obtener lista de nombres 
- Mostrar estadísticas

## Metodos refactorizados 
```
Buscar por ID
Antes:
for (Contacto c : contactos) {
    if (c.getId().equals(id)) return c;
}
Después (con Stream):
return contactos.stream()
    .filter(c -> c.getId().equals(id))
    .findFirst()
    .orElseThrow(() -> new ContactoNoEncontradoException());

Buscar por nombre
Antes:
for (Contacto c : contactos) {
    if (c.getNombre().equals(nombre)) return c;
}
return null;
Después:
return contactos.stream()
    .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
    .findFirst();

Contar contactos con email
Antes:
int count = 0;
for (Contacto c : contactos) {
    if (c.getEmail() != null) count++;
}
Después:
return contactos.stream()
    .filter(c -> c.getEmail() != null && !c.getEmail().isEmpty())
    .count();

Obtener nombres (map)
Antes:
ArrayList<String> nombres = new ArrayList<>();
for (Contacto c : contactos) {
    nombres.add(c.getNombre());
}
Después:
return contactos.stream()
    .map(Contacto::getNombre)
    .collect(Collectors.toList());

Filtrar por categoría
Antes:
ArrayList<Contacto> lista = new ArrayList<>();
for (Contacto c : contactos) {
    if (c.getCategoria().equals(cat)) lista.add(c);
}
Después:
return contactos.stream()
    .filter(c -> c.getCategoria().equalsIgnoreCase(cat))
    .collect(Collectors.toList());
```

## Como ejecutar
1. Entrar a la carpeta `cd semana06-agenda-modernizada`
2. Compilar: `mvn compile`
3. Test: `mvn test`
4. Ejecutar: `mvn exec:java -Dexec.mainClass="com.universidad.Main"`

## Resultado mvn test 
```
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.157 s -- in servicio.GestorContactosTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.720 s
[INFO] Finished at: 2026-03-28T16:04:30-04:00
[INFO] ------------------------------------------------------------------------
```

## Decision de buscarPorNombre
Se decidio que el método buscarPorNombre devuelva un Optional en lugar de null para evitar errores como NullPointerException y obligar al programador a manejar explicitamente el caso en que no se encuentre un resultado. Esto hace el codigo mas seguro, legible y acorde a las buenas prácticas modernas de Java