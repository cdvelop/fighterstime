# Requerimiento Funcional: Sistema de Progresión por Puntos de Atributo

## Propósito
Permitir a los jugadores personalizar sus personajes de manera flexible al subir de nivel. En lugar de aumentos automáticos, el jugador recibirá puntos que podrá asignar a los atributos principales (vida, ataque, defensa, velocidad) para adaptar el personaje a su estilo de juego preferido.

---

## Componentes Clave

### Atributos del Personaje
Los personajes tendrán dos nuevos atributos:
* **Nivel:** Un número entero que comenzará en 1 para todos los personajes.
* **Experiencia:** Un número entero que acumulará los puntos de experiencia (XP) ganados, comenzando en 0.

### Ganancia de Experiencia (XP)
* Los personajes ganarán XP al derrotar a un enemigo en combate.
* La cantidad de XP ganada se calculará con la siguiente fórmula: `XP Ganada = (Nivel del Enemigo * 50)`.
* Esta XP se sumará al atributo de experiencia del personaje.

### Mecánica de Subida de Nivel y Puntos de Atributo
* Después de cada combate, el sistema verificará si la experiencia acumulada es suficiente para subir de nivel.
* La XP necesaria para alcanzar el siguiente nivel se calculará con la fórmula: `XP Requerida = 100 * (Nivel Actual^2)`.
* Si la experiencia acumulada es igual o mayor a la XP Requerida, el personaje subirá de nivel. Por cada nivel que suba, el jugador recibirá 3 puntos de atributo para gastar.
* La interfaz de usuario deberá notificar al jugador que ha subido de nivel y tiene puntos disponibles para gastar.

### Menú de Asignación de Atributos
* Se creará un nuevo menú o pantalla accesible al subir de nivel. En este menú, el jugador podrá distribuir sus puntos de atributo entre los siguientes cuatro atributos principales, con un costo de 1 punto por cada unidad aumentada:
    * **Puntos de Vida (Vida):** Aumenta la vitalidad del personaje.
    * **Puntos de Ataque (Ataque):** Incrementa el daño infligido.
    * **Puntos de Defensa (Defensa):** Reduce el daño recibido.
    * **Puntos de Velocidad (Velocidad):** Aumenta la velocidad para determinar la iniciativa de turno.

### Persistencia de Datos
* Los atributos de nivel, experiencia y la asignación de puntos deben ser guardados junto con los demás datos del personaje para asegurar que el progreso del jugador no se pierda.
* Los sistemas de almacenamiento de datos deben actualizarse para incluir estos nuevos campos y garantizar que el progreso del jugador se conserve.
