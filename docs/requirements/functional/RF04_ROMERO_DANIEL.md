# Requerimiento de Personajes - Actualizado

## Propósito Principal

El primer requerimiento del proyecto FightersTime se enfoca en el desarrollo del sistema de personajes. El objetivo es crear un sistema modular y flexible que permita la existencia de tres tipos de personajes jugables: Guerrero, Mago y Arquero. Cada uno debe tener un conjunto de estadísticas y un rol de combate predefinido para ofrecer al jugador opciones estratégicas y un estilo de juego distinto.

## Clases de Personajes y sus Roles

Cada clase de personaje está diseñada con un rol específico en mente, reflejado en la distribución de sus atributos.

### Guerrero 🛡️

Representa al "tanque" del juego. Su rol es resistir el daño y sobrevivir en el combate. Se caracteriza por tener alta vida y defensa, con ataque y velocidad moderados.

*   **Vida:** 150
*   **Ataque:** 20
*   **Defensa:** 15
*   **Velocidad:** 8
*   **Maná:** 50

### Mago ✨

Es el "hechicero", un especialista en infligir una gran cantidad de daño. Es poderoso, pero vulnerable al daño físico. Se caracteriza por su alto ataque, pero baja vida y defensa. Su velocidad es media.

*   **Vida:** 90
*   **Ataque:** 30
*   **Defensa:** 8
*   **Velocidad:** 12
*   **Maná:** 100

### Arquero 🏹

El "tirador", un personaje ágil y equilibrado. Su rol es atacar a distancia de forma consistente y evadir ataques. Se caracteriza por su buena velocidad, con una distribución equilibrada de vida, ataque y defensa.

*   **Vida:** 120
*   **Ataque:** 25
*   **Defensa:** 10
*   **Velocidad:** 15
*   **Maná:** 75

## Componentes Técnicos Clave

Para implementar este concepto, se utiliza una clase central en Kotlin: la clase `Personaje`.

### Atributos Fundamentales

La clase `Personaje` contiene las propiedades clave que definen a un héroe:

*   `vida`
*   `ataque`
*   `defensa`
*   `velocidad`
*   `mana` *(nuevo atributo agregado)*

### Funciones de Comportamiento

La clase también incluye lógica para manejar las interacciones en el juego, como:

*   `recibirDanio()`: Una función que implementa el sistema de defensa degradable. Primero reduce la defensa del personaje, y si el ataque supera la defensa, el daño restante se aplica a la vida.
*   `estaVivo()`: Una función que verifica si la vida del personaje es mayor que cero.
*   `consumirMana()`: Una función que maneja el gasto de maná para habilidades especiales.
*   `recuperarMana()`: Una función que permite la regeneración de maná durante el combate.

### Fábrica de Personajes

La creación de los personajes se simplifica mediante un `companion object`. Este objeto funciona como una "fábrica" que genera una instancia de la clase `Personaje` con las estadísticas exactas para la clase que el jugador elija (Guerrero, Mago o Arquero).

## Notas de Implementación

- Las estadísticas están balanceadas para combates de larga duración (180 segundos)
- El sistema de maná permite el uso de habilidades especiales y perks avanzados
- La defensa funciona como un "escudo degradable" que se reduce con cada ataque recibido
- **Roles claramente definidos y balanceados:**
  - **Guerrero (Tanque)**: Máxima supervivencia, absorbe daño del equipo
  - **Mago (Apoyo/Control)**: Hechizos de área, buffs, debuffs, utilidad táctica
  - **Arquero (DPS)**: Alto daño constante, ágil pero frágil - especialista en eliminar objetivos

### Balance Final de Stats
```
                HP    ATK   DEF   VEL   MANÁ
Guerrero:      150    18    20     8     40
Mago:          100    22    12    12    120  
Arquero:        80    28     8    15     60
```

**Filosofía del diseño:**
- Cada clase tiene fortalezas y debilidades claras
- No existe una clase objetivamente superior
- El meta depende del estilo de juego y estrategia del jugador
- Balance orientado a combates tácticos de larga duración
