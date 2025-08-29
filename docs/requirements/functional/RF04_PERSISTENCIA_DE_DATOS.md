# RF04: Persistencia de Datos

## Propósito
Este requerimiento define la necesidad de que el juego guarde y cargue el progreso del jugador para asegurar que no se pierda entre sesiones de juego. Esto incluye el estado de los personajes, el progreso de nivel y otros datos relevantes.

## Requisitos Fundamentales

### Datos a Guardar
El sistema debe ser capaz de guardar, como mínimo, la siguiente información para cada personaje:
*   Nombre del personaje
*   Clase
*   Nivel
*   Experiencia (XP)
*   Puntos de Vida (actuales y máximos)
*   Ataque
*   Defensa
*   Velocidad
*   Poder
*   Puntos de atributo sin gastar

### Operaciones de Guardado y Carga
*   **Guardado:** El jugador debe poder guardar su partida en cualquier momento fuera del combate.
*   **Carga:** El jugador debe poder cargar una partida guardada desde el menú principal.
*   **Múltiples Archivos:** El sistema debe permitir al jugador gestionar múltiples archivos de guardado (por ejemplo, hasta 5 "slots" de guardado).
*   **Sobrescritura:** El jugador debe tener la opción de sobrescribir un archivo de guardado existente.

## Propuestas de Implementación
Existen dos enfoques principales para la implementación de la persistencia de datos. La elección final dependerá de los recursos del proyecto y los objetivos a largo plazo.

### Opción 1: Almacenamiento Local
*   **Descripción:** Los datos del juego se guardan en archivos locales en el dispositivo del usuario.
*   **Formato:** Los archivos se guardarían con una extensión personalizada (ej. `.sav`).
*   **Ubicación:** `"{ruta_del_juego}/files/saves/{nombre_del_archivo}.sav"`
*   **Ventajas:**
    *   Simple de implementar.
    *   No requiere conexión a internet.
    *   Rápido acceso a los datos.
*   **Desventajas:**
    *   Los datos solo existen en un dispositivo y no se pueden sincronizar.
    *   Riesgo de pérdida de datos si el dispositivo se daña o se pierde.

### Opción 2: Almacenamiento en la Nube con Soporte Offline (Firebase)
*   **Descripción:** Utiliza un servicio de base de datos en la nube como Firebase Realtime Database para almacenar los datos del juego, con una caché local para permitir el juego sin conexión.
*   **Funcionamiento:**
    *   **Online:** Con conexión a internet, todos los datos se sincronizan en tiempo real con la base de datos en la nube.
    *   **Offline:** Sin conexión, el juego utiliza una caché de datos local. Los cambios se guardan en el dispositivo y se sincronizan automáticamente cuando se recupera la conexión.
*   **Ventajas:**
    *   Respaldo automático de los datos en la nube.
    *   Sincronización entre múltiples dispositivos del mismo usuario.
    *   Alta disponibilidad y persistencia de los datos.
*   **Desventajas:**
    *   Mayor complejidad de implementación.
    *   Requiere configuración de un servicio externo (Firebase).
    *   Puede incurrir en costos asociados al servicio en la nube.
