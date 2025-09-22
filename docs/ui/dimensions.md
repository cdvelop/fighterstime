Dimensiones esenciales del juego Fighter’s Time

En esta sección se establecerán de manera precisa y estructurada las dimensiones esenciales del juego, considerando tanto los aspectos técnicos como las necesidades de jugabilidad y experiencia del usuario. La definición de medidas no se limita únicamente a valores numéricos en píxeles, sino que también incluye la justificación que respalda cada elección, asegurando coherencia entre la estética, la funcionalidad y la accesibilidad en dispositivos móviles. Se abarcarán cuatro apartados fundamentales: el mapa, que constituye el escenario principal de interacción y debe estar diseñado con una proporción equilibrada entre detalle visual y rendimiento; los personajes, tanto jugables como NPCs, cuyas dimensiones deben garantizar legibilidad, diferenciación y consistencia en animaciones; la perspectiva de visualización, entendida como el nivel de zoom o distancia de cámara que determinará cuánto del entorno es visible en pantalla y cómo se percibe la acción; y, finalmente, la interfaz de usuario (UI), compuesta por botones, menús y elementos interactivos, que debe diseñarse bajo estándares de usabilidad táctil y adaptarse a distintos tamaños de pantalla. Cada medida se define en píxeles (y cuando corresponde en dp, según densidad de pantalla), indicando altura, ancho y profundidad, junto con la argumentación que explica por qué se adoptan dichas proporciones y cómo estas contribuyen a una experiencia de juego clara, inmersiva y optimizada para dispositivos móviles en orientación vertical (portrait).

1. Mapa
	•	Dimensiones de los tiles: 128 px × 128 px.
	•	Viewport visible: 1080 px (ancho) × 1440 px (alto), lo que corresponde aproximadamente a 8 tiles completos en sentido horizontal y 11 en sentido vertical.
	•	Ejemplo de nivel completo: un mapa de 12 × 16 tiles, con un tamaño total de 1536 px de ancho y 2048 px de alto.
Justificación: el mapa es el núcleo de la jugabilidad, pues define el espacio donde los personajes se mueven y las batallas ocurren. El tamaño elegido para los tiles (128 px) ofrece un equilibrio entre detalle gráfico y eficiencia en el rendimiento, permitiendo que los objetos y personajes se representen con claridad sin sobrecargar la memoria del dispositivo. Al diseñar mapas más grandes que el área visible del viewport se genera la necesidad de exploración y estrategia, ya que los jugadores no podrán ver todo el escenario de una sola vez, fomentando el desplazamiento y la planificación táctica por turnos.


2. Personajes (jugables y NPCs)
	•	Guerrero: 144 px × 192 px.
	•	Arquero: 120 px × 192 px.
	•	Mago: 136 px × 192 px.
	•	NPC estándar: 128 px × 192 px.
	•	Jefes/Boss: 192 px × 256 px.
Justificación: los personajes han sido diseñados con una altura estándar de 192 px (equivalente a 1.5 tiles), lo que asegura una correcta legibilidad en pantalla y suficiente espacio para animaciones expresivas, como ataques, movimientos o gestos. La variación en el ancho permite resaltar la identidad de cada clase: el guerrero más ancho para transmitir fortaleza, el arquero más estilizado para enfatizar agilidad y el mago con proporciones intermedias para reflejar su enfoque en habilidades mágicas. Los NPCs mantienen dimensiones similares a los personajes jugables para integrarse de manera coherente al entorno, mientras que los jefes se diseñan con mayor tamaño (256 px de altura) para destacar su importancia en el gameplay y generar un mayor impacto visual frente al jugador. Esta coherencia en alturas también facilita la programación de colisiones, los puntos pivote y las sombras, manteniendo consistencia técnica y estética.

3. Distancia de visualización (cámara)
	•	Zoom base: 1 tile = 128 px.
	•	Viewport vertical: 1440 px → muestra aproximadamente 11 tiles completos en altura.
	•	Reglas de escalado:
     •	Zoom out → reducir tamaño de tile a 96 px, mostrando más área del mapa en pantalla.
     •	Zoom in → aumentar tamaño de tile a 160 px, priorizando el detalle de personajes y escenarios.
Justificación: la cámara define cuánto del mapa es visible para el jugador y, por lo tanto, influye directamente en la experiencia de juego. Mantener un zoom base de 128 px por tile permite un balance entre claridad visual y campo de visión. La posibilidad de escalar hacia arriba o hacia abajo ofrece flexibilidad: un zoom out es útil para planear estrategias y tener un panorama más amplio del terreno, mientras que un zoom in refuerza la inmersión y el detalle gráfico en escenas de combate o cinemáticas. Esta adaptabilidad asegura que el juego pueda ajustarse a distintos momentos y estilos de interacción sin perder consistencia visual.


4. Interfaz de Usuario (UI)
	•	Botones de juego (acciones principales): 160 px × 160 px.
	•	Menú principal (panel modal): 900 px × 1400 px, centrado en pantalla.
	•	Botones de menú (ejemplo: “Jugar”, “Opciones”, “Salir”): 720 px × 160 px.
Justificación: la interfaz es el puente entre el jugador y las mecánicas del juego, por lo que debe diseñarse priorizando la accesibilidad y comodidad en pantallas táctiles. En Android, la recomendación mínima para elementos interactivos es de 48 dp (144 px en pantallas con densidad xxhdpi), de modo que los botones aquí definidos superan ese estándar para ofrecer mayor precisión al presionar y mejor legibilidad de iconos y textos. Los botones de 160 px en el HUD de acción permiten que los comandos principales se ejecuten sin dificultad, mientras que el menú principal ocupa gran parte de la pantalla para resaltar opciones importantes sin distraer con elementos secundarios. El formato rectangular de los botones del menú facilita la inclusión de texto acompañado de iconos, optimizando la experiencia de navegación. Además, el uso de márgenes y padding interno asegura que la interfaz no se sienta saturada y que el jugador pueda interactuar de manera natural, incluso en dispositivos de distintos tamaños.

5. Cálculos técnicos de referencia

Para garantizar consistencia entre las dimensiones del juego y la correcta adaptación a distintos dispositivos móviles, se definió una resolución baseline de 1080 × 1920 px en orientación vertical (portrait) con densidad de pantalla 3.0 (xxhdpi). A partir de esta referencia se realizaron los cálculos que definen el tamaño de tiles, personajes, UI y cámara.

a) Conversión entre px y dp
	•	Fórmula: dp = px ÷ densidad.
	•	Ejemplo:
	•	1080 px ÷ 3 = 360 dp (ancho).
	•	1920 px ÷ 3 = 640 dp (alto).
	•	Justificación: usar dp como referencia permite que los elementos mantengan proporciones en pantallas con distinta densidad.

b) Distribución vertical de la pantalla (1920 px de alto)
	•	Barra superior (HUD estado): 120 px → 120 ÷ 3 = 40 dp.
	•	Área de juego (viewport): 1440 px.
	•	Zona inferior (UI de botones): 360 px → 360 ÷ 3 = 120 dp.
	•	Comprobación: 120 + 1440 + 360 = 1920 px totales.

c) Tamaño de tiles y visibilidad en el viewport
	•	Tile base: 128 px.
	•	Ancho visible: 1080 px ÷ 128 px ≈ 8.4 → 8 tiles completos.
	•	Alto visible: 1440 px ÷ 128 px ≈ 11.25 → 11 tiles completos.
	•	Ejemplo de mapa: 12 × 16 tiles →
	•	Ancho: 12 × 128 = 1536 px.
	•	Alto: 16 × 128 = 2048 px.
	•	Justificación: el mapa es mayor que el viewport, lo que obliga al jugador a moverse por el escenario, fomentando exploración.

d) Dimensiones de personajes y relación con tiles
	•	Altura estándar: 192 px → 192 ÷ 128 = 1.5 tiles.
	•	Anchura según clase:
	•	Guerrero: 144 px (robusto).
	•	Arquero: 120 px (esbelto).
	•	Mago: 136 px (intermedio).
	•	Jefes: 256 px de alto → 256 ÷ 128 = 2 tiles.
	•	Justificación: definir personajes en múltiplos de tiles simplifica animaciones, colisiones y posicionamiento en el mapa.

e) Cálculos de UI (botones y menús)
	•	Botón de acción: 160 px × 160 px → 160 ÷ 3 ≈ 53 dp (supera el mínimo de 48 dp recomendado por Android).
	•	Fila de 4 botones:
	•	4 × 160 px = 640 px.
	•	3 espacios de 48 px = 144 px.
	•	Total: 784 px.
	•	Margen lateral para centrar: (1080 − 784) ÷ 2 = 148 px por lado.
	•	Menú principal: 900 × 1400 px → centrado deja márgenes laterales de 90 px.
	•	Botones del menú: 720 × 160 px → cómodos para texto e iconos.

f) Cálculo de la cámara / zoom ortográfico
	•	Mitad vertical del viewport: 1440 ÷ 2 = 720 px.
	•	Cámara ajustada para mostrar 1440 px de alto → ~11 tiles verticales.
	•	Regla de escalado:
	•	Zoom out → reducir tile a 96 px.
	•	Zoom in → aumentar tile a 160 px.
	•	Justificación: cambiar el tamaño del tile es equivalente a modificar el nivel de zoom, pero requiere assets preparados en distintas resoluciones para evitar pérdida de calida
