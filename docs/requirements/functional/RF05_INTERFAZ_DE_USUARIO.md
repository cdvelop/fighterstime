# RF05: Interfaz de Usuario (UI)

## Propósito
Este requerimiento define los elementos de la interfaz de usuario (UI) necesarios para que el jugador pueda interactuar con el juego de manera clara e intuitiva.

## Elementos de la Interfaz

### Menú Principal
*   Al iniciar el juego, se debe mostrar una pantalla de inicio con un menú principal que contenga las siguientes opciones:
    *   **Jugar:** Inicia una nueva partida o carga una existente.
    *   **Opciones:** Permite configurar ajustes del juego (ej. sonido, gráficos).
    *   **Tutorial:** Inicia un tutorial interactivo para nuevos jugadores.
    *   **Salir:** Cierra la aplicación.

### Interfaz de Combate
*   **Indicadores de Estado:** Durante el combate, la vida (PV) del jugador y del enemigo debe estar siempre visible.
*   **Menú de Acciones:** El jugador debe tener un menú claro para seleccionar sus acciones (Atacar, Defender, etc.).
*   **Indicadores Visuales:** El sistema debe mostrar mensajes emergentes para eventos clave del combate, como `Round 1`, `KO`, `Combo`, y `Perfect`, para mejorar la retroalimentación visual.
*   **Marcador de Rondas:** Debe haber un indicador visual que muestre las rondas ganadas por cada combatiente.

### Menús Adicionales
*   **Selección de Escenario:** Antes de un combate, el jugador debe poder elegir el escenario de la batalla, preferiblemente con una vista previa visual.
*   **Menú de Pausa:** En cualquier momento durante el juego (excepto en cinemáticas), el jugador debe poder pausar la partida. El menú de pausa debe ofrecer las siguientes opciones:
    *   Reanudar.
    *   Reiniciar combate.
    *   Salir al Menú Principal.
*   **Confirmación de Acciones:** El sistema debe solicitar confirmación para acciones críticas que puedan causar la pérdida de progreso, como salir de una partida o reiniciar un combate.

### Tutorial Interactivo
*   Para los nuevos jugadores, el juego debe incluir un tutorial interactivo que guíe al usuario a través de las mecánicas básicas.
*   El tutorial debe usar instrucciones visuales y resaltar los botones de la interfaz para enseñar al jugador cómo moverse, atacar y usar las funciones principales.
