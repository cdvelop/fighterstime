# RF01: Creación de Personaje - Estadísticas y Clase

**Descripción:**  
El sistema debe proveer una interfaz que permita al jugador seleccionar una clase de personaje (Guerrero, Mago o Arquero) y visualizar las estadísticas base asociadas a dicha clase. Este requerimiento asegura que la lógica de asignación de atributos funcione correctamente antes de la creación final del personaje.

**Interfaz:**  
La pantalla de creación de personaje debe incluir selectores claros (por ejemplo, botones) para cada una de las tres clases disponibles: Guerrero, Mago y Arquero.

**Visualización de Atributos:**  
El sistema debe mostrar en pantalla los cuatro atributos clave del personaje:
- Vida (int)
- Ataque (int)
- Defensa (int)
- Velocidad (int)

**Asignación de Estadísticas:**  
Al seleccionar una clase, el sistema debe actualizar de forma inmediata y automática los valores de los atributos del personaje con los siguientes datos predefinidos:

- **Guerrero:** Vida: 150, Ataque: 20, Defensa: 15, Velocidad: 8
- **Mago:** Vida: 90, Ataque: 30, Defensa: 8, Velocidad: 12
- **Arquero:** Vida: 120, Ataque: 25, Defensa: 10, Velocidad: 15

**Rendimiento:**  
El tiempo de respuesta para la actualización de las estadísticas en pantalla no debe superar los 200 ms.

**Responsable:** Grupo Supported / Francisco Villa  
**Prioridad:** Crítica