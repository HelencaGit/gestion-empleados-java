# Gestión de empleados (Java)

Aplicación de consola en Java para gestionar una lista de empleados usando colecciones `Map` y guardando los datos en un fichero, hecha como práctica de Programación (DAM).

## Funcionalidades
- Mostrar los empleados guardados en el fichero.
- Añadir un empleado (id, nombre y sueldo), sin permitir ids repetidos.
- Eliminar un empleado por id o por nombre.
- Mostrar los empleados ordenados por id.
- Los cambios se guardan en el fichero y se conservan al cerrar el programa.

## Tecnologías y conceptos
Java · `HashMap` y `TreeMap` · `Iterator` · Serialización de objetos (`ObjectOutputStream` / `ObjectInputStream`) · Ficheros (`java.nio.file`) · Gestión de excepciones

## Estructura
- `App.java`: menú principal.
- `GestionEmpleados.java`: lógica del `Map` y lectura/escritura del fichero.
- `Empleado.java`: clase modelo (`Serializable`).

## Cómo ejecutarlo
Requisito: JDK 11 o superior.
1. Clona el repositorio.
2. Abre la carpeta del proyecto en un IDE de Java (IntelliJ, VS Code, Eclipse...).
3. Ejecuta `App.java`. El directorio de trabajo debe ser la raíz del proyecto, donde está el fichero de datos.

## Nota
El fichero de datos guarda objetos Java serializados (formato binario), así que no se puede editar a mano. Contiene tres empleados de ejemplo.

## Capturas
![consola](capturas/consola.png)
