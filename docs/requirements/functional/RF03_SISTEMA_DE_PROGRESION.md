# RF03: Sistema de Progresión

## Propósito
Este requerimiento define cómo los personajes de los jugadores ganan experiencia, suben de nivel y mejoran sus atributos. El objetivo es proporcionar un sistema de progresión que recompense al jugador y le permita personalizar el desarrollo de su personaje.

## Mecánicas de Progresión

### Ganancia de Experiencia (XP)
*   Los personajes ganan puntos de experiencia (XP) al derrotar enemigos en combate.
*   La cantidad de XP ganada se calcula con la fórmula: `XP Ganada = (Nivel del Enemigo * 50)`.
*   La XP obtenida se suma al total de experiencia del personaje.

### Subida de Nivel
*   Después de cada combate, el sistema verifica si la experiencia total del personaje es suficiente para subir de nivel.
*   La XP necesaria para el siguiente nivel se calcula con la fórmula: `XP Requerida = 100 * (Nivel Actual ^ 2)`.
*   Cuando la XP acumulada es igual o mayor a la XP requerida, el personaje sube de nivel.

### Puntos de Atributo
*   Por cada nivel que sube, el jugador recibe **3 puntos de atributo**.
*   Estos puntos pueden ser asignados por el jugador para mejorar los atributos principales de su personaje: **Vida, Ataque, Defensa, Velocidad y Poder**.
*   El costo de aumentar un atributo en un punto es de **1 punto de atributo**.

### Interfaz de Progresión
*   El juego debe notificar al jugador de forma clara cuando ha subido de nivel.
*   Debe existir un menú o pantalla donde el jugador pueda asignar sus puntos de atributo disponibles.

### Recompensas por Hitos de Nivel
*   Al alcanzar ciertos hitos de nivel (por ejemplo, Nivel 5, 10, 15), el jugador recibirá una recompensa especial.
*   Estas recompensas pueden ser objetos únicos, habilidades especiales o bonificaciones de atributos.
*   Por ejemplo, al llegar a Nivel 5, el jugador podrá elegir entre tres objetos, cada uno especializado en mejorar permanentemente el Ataque, la Defensa o la Vida.
