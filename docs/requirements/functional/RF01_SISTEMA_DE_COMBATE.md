# RF01: Sistema de Combate

## Propósito
Este requerimiento define el sistema de combate por turnos del juego. El objetivo es simular una batalla entre dos personajes hasta que uno de ellos sea derrotado o se agote el tiempo.

## Características Principales

### Inicio del Combate
*   El combate comienza cuando el jugador entra en una zona designada o interactúa con un enemigo.
*   La duración máxima de un combate es de **180 segundos** (3 minutos).

### Sistema de Turnos
*   El combate se desarrolla por turnos.
*   La iniciativa para el primer turno se asigna al personaje con el atributo de **Velocidad** más alto.
*   Si la velocidad de ambos personajes es idéntica, el primer turno se decide de forma aleatoria.
*   Después de cada acción, el turno pasa al otro personaje.

### Acciones del Jugador en Combate
Durante su turno, el jugador puede elegir una de las siguientes acciones:

1.  **Atacar:**
    *   El jugador lanza un ataque contra el enemigo.
    *   El daño infligido se calcula con la siguiente fórmula, que tiene en cuenta el nivel del personaje, su control, y las afinidades de tipo:
        ```
        Daño = (6 * Nivel + Control) / 4 + 6 * STAB * Tipo1 * Tipo2 * Aleatorio
        ```
    *   **Nivel:** Nivel actual del personaje.
    *   **Control:** Atributo que representa la habilidad del personaje con ataques físicos o mágicos.
    *   **STAB:** Bonificación de daño si el tipo de ataque coincide con el tipo del personaje.
    *   **Tipo1 / Tipo2:** Modificadores basados en la afinidad elemental del ataque y la defensa del oponente.
    *   **Aleatorio:** Un pequeño valor aleatorio para introducir variabilidad en el daño.

2.  **Defender:**
    *   El personaje adopta una postura defensiva.
    *   Reduce el daño recibido del próximo ataque enemigo en un **50%**.

### Condiciones de Fin de Combate
El combate finaliza cuando ocurre una de las siguientes condiciones:
*   La vida (PV) de uno de los personajes llega a 0.
*   Se agota el tiempo límite de 180 segundos.
*   Al finalizar, se muestra un mensaje de **Victoria** o **Derrota**.

### Animaciones
*   Las animaciones de ataque y defensa deben tener una duración máxima de **2 segundos**.
*   La animación de resultado final (Victoria/Derrota) no debe superar los **3 segundos**.

### Actualización de Estado
*   Los Puntos de Vida (PV) del jugador y del enemigo deben actualizarse en la interfaz de usuario en tiempo real después de cada acción.
