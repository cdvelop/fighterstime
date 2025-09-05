# Lógica de la Progresión de Niveles Francisco Villa

La lógica de la progresión de niveles define cómo el jugador avanza en el juego, sube de nivel y desbloquea mejoras de atributos. El sistema se basa en la acumulación de Puntos de Experiencia (EXP) obtenidos al derrotar enemigos.

El sistema funciona de la siguiente manera:

1.  **Obtención de EXP**: Cada enemigo derrotado otorga una cantidad fija de EXP, que se añade al total acumulado del personaje.
2.  **Cálculo de Requerimiento de EXP**: La cantidad de EXP necesaria para subir de nivel se incrementa con cada nivel, siguiendo una fórmula simple para asegurar que la progresión sea un desafío creciente.

---

### Fórmula de Progresión

La cantidad de EXP necesaria para alcanzar el siguiente nivel se calcula con la siguiente fórmula:

`EXP_para_Siguiente_Nivel = (Nivel_Actual * 150) + 100`

Esta fórmula asegura que el esfuerzo para subir de nivel sea progresivo, requiriendo más EXP a medida que el personaje se hace más fuerte.

---

### Ejemplo Numérico

A continuación se muestra una tabla con la cantidad de EXP requerida para cada uno de los primeros cinco niveles, para que la lógica sea fácil de entender:

| Nivel Actual | EXP Necesaria para Subir | Total de EXP Acumulada |
| :----------: | :----------------------: | :--------------------: |
|      1       |           250            |          250           |
|      2       |           400            |          650           |
|      3       |           550            |         1,200          |
|      4       |           700            |         1,900          |
|      5       |           850            |         2,750          |

* **Ejemplo de Nivel 1 a 2**: Al iniciar, el jugador está en el Nivel 1. Debe acumular 250 EXP para subir al Nivel 2.
* **Ejemplo de Nivel 2 a 3**: Para pasar del Nivel 2 al Nivel 3, el jugador debe obtener 400 EXP adicionales (lo que da un total acumulado de 650 EXP).

---

### Efectos de la Subida de Nivel

Cuando el personaje alcanza la EXP necesaria, sube de nivel y se beneficia de las siguientes mejoras:

* **Aumento de Atributos**: Sus atributos base (Vida, Ataque, Defensa, Velocidad) se incrementan permanentemente.
* **Vida**: Aumenta en 10 puntos.
* **Ataque**: Aumenta en 5 puntos.
* **Defensa**: Aumenta en 3 puntos.
* **Velocidad**: Aumenta en 1 punto.