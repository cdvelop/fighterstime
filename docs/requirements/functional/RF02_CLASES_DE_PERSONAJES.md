# RF02: Clases de Personajes y Atributos

## Propósito
Este requerimiento define las clases de personajes jugables, sus roles de combate y sus atributos base. El objetivo es ofrecer al jugador una variedad de estilos de juego a través de personajes con fortalezas y debilidades distintas.

## Atributos Fundamentales
Cada personaje en el juego se define por los siguientes atributos principales:
*   **Vida (PV):** Puntos de Vida. Determina la cantidad de daño que un personaje puede recibir antes de ser derrotado.
*   **Ataque:** El poder de ataque base del personaje.
*   **Defensa:** La capacidad del personaje para resistir el daño.
*   **Velocidad:** Determina el orden de los turnos en combate.
*   **Poder:** Aumenta la efectividad de habilidades especiales y ataques mágicos.
*   **Nivel:** El nivel actual del personaje, que comienza en 1.
*   **Experiencia (XP):** Puntos de experiencia acumulados.

## Clases de Personajes Jugables
El jugador puede elegir entre tres clases de personajes, cada una con un rol y estadísticas base (a Nivel 1) diferentes:

### Vikingo
Un guerrero robusto que actúa como "tanque", especializado en resistir daño y sobrevivir.
*   **Vida:** 150
*   **Ataque:** 20
*   **Defensa:** 15
*   **Velocidad:** 8
*   **Poder:** 2

### Mago
Un hechicero que se especializa en infligir grandes cantidades de daño mágico. Es poderoso pero frágil.
*   **Vida:** 90
*   **Ataque:** 30
*   **Defensa:** 8
*   **Velocidad:** 12
*   **Poder:** 9

### Arquero
Un atacante ágil y equilibrado. Se enfoca en la velocidad y la consistencia en el daño.
*   **Vida:** 120
*   **Ataque:** 25
*   **Defensa:** 10
*   **Velocidad:** 15
*   **Poder:** 7

## Personajes No Jugables (NPCs)
Habrá enemigos controlados por el sistema, como el siguiente ejemplo:

### Goblin (Enemigo de Prueba)
*   **Vida:** 30
*   **Ataque:** 10
*   **Defensa:** 5
*   **Velocidad:** 5
*   **Poder:** 1
*   **Experiencia Otorgada:** 50
