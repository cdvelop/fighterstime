📜​ Requerimiento Funcional Y Los Sistemas de combate
Dentro de este documento se detallara los requerimientos funcionales delos sistema de combate, basadose en la lógica de la clase Personaje. Su  objetivo es simular una batalla por turnos entre dos personajes hasta que uno de ellos sea derrotado, para asi lograr obtener un ganador.
 
 Modalidad del juego:
 
​▪️​  El juego se basa en un combate de tiempos coloniales hasta los tiempos de ahora donde podran tener diversos niveles dentro del juego, en cada nivel o etapa podras juegar de diferente forma , encontrando un mundo pixeliado de combate o un sistema
  de combate en los tiempos de ahora utilizando la camara de tu telefono.

  Comienzo de la Partida:
  
​▪️​  El combate iniciara ingresando a una zona designada o al momente de choca o dialogar con un enemigo. 

  Asignación de Turno:
  
▪️ ​Almomento de iniciar el primer turno se escogera al personajes con la mayor habilidad y velocidad del combate. Donde si su habilidad y su velocidad son iguales se asignara aleatoriamente.


🎮 Opciones Durante el Turno del Jugador
🗡️ Atacar

Cuando llega su turno, el jugador puede elegir lanzar un ataque. El daño que cause dependerá de varios factores, y se calcula con la siguiente fórmula:

Daño = (6 × Nivel + Control) ÷ 4 + 6 × STAB × Tipo1 × Tipo2 × Aleatorio

¿Qué significa esto?

Nivel: El nivel actual del personaje.

Control: Representa qué tan hábil es el personaje usando magia o ataques físicos.

STAB: Si el ataque es del mismo tipo que el personaje (por ejemplo, un hechizo de fuego lanzado por un mago de fuego), se recibe un bono de daño.

Tipo1 / Tipo2: Modificadores según la afinidad elemental del ataque y del oponente (por ejemplo, fuego es débil ante agua).

Aleatorio: Un pequeño valor que aporta variabilidad, haciendo que el daño no sea siempre igual.

🛡️ Defender

Si el jugador opta por defenderse, el personaje adopta una postura defensiva, reduciendo a la mitad (50%) el daño del siguiente ataque enemigo. Es una buena estrategia para resistir ataques fuertes o ganar tiempo.

❤️ Actualización de Vida

Después de cada acción, los Puntos de Vida (PV) tanto del jugador como del enemigo se actualizan automáticamente en pantalla, reflejando el estado actual del combate.

🏁 ¿Cuándo termina el combate?

El enfrentamiento concluye si ocurre cualquiera de estas condiciones:

La vida de uno de los personajes (jugador o enemigo) llega a 0 o menos.

Se alcanza el límite de tiempo de 180 segundos.

Una vez finalizado el combate, aparece un mensaje claro en pantalla indicando si fue una Victoria o una Derrota.

🎬 Reglas de Animaciones

Las animaciones de ataque y defensa deben durar máximo 2 segundos, para mantener el ritmo del juego ágil.

Las animaciones que muestran el resultado del combate (Victoria/Derrota) no deben durar más de 3 segundos.
