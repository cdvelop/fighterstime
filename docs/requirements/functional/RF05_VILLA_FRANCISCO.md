# RF05: Sistema de Gestión de Turnos

**Descripción:**  
El juego debe implementar un sistema de gestión de turnos que determine el orden y las acciones de los participantes (jugador y enemigo) durante las batallas. La duración máxima de cada combate será de 180 segundos (3 minutos).

**Inicio del Turno:**  
Al comenzar el combate, la iniciativa del primer turno será asignada al personaje con mayor Velocidad. Si ambos tienen la misma Velocidad, el turno inicial se asignará aleatoriamente.

**Secuencia de Turnos:**  
Durante cada turno, solo el participante activo (jugador o enemigo) podrá realizar una acción. Al finalizar la acción, el turno pasará automáticamente al siguiente participante.

**Acciones Disponibles en el Turno del Jugador:**
- **Atacar:**  
  El daño se calculará usando la fórmula:  
  `Daño = (2*Nivel + Control)/5 + 3 * STAB * Tipo1 * Tipo2 * Random`
  - **Nivel:** Nivel actual del personaje.
  - **Control:** Atributo de control del personaje.
  - **STAB:** Bonificación de ataque del mismo tipo.
  - **Tipo1/Tipo2:** Bonificaciones o penalizaciones de tipo.
  - **Random:** Valor aleatorio para variar el daño.

- **Defender:**  
  El personaje adoptará una postura defensiva, reduciendo en un 50% el daño del siguiente ataque recibido.

**Actualización de Estado:**  
Al finalizar cada turno, los puntos de vida (PV) de ambos participantes deben actualizarse inmediatamente en la interfaz.

**Finalización de la Secuencia de Turnos:**  
La gestión de turnos continuará hasta que los puntos de vida de uno de los participantes sean menores o iguales a 0, o se agote el tiempo de 180 segundos. Al finalizar, se mostrará un mensaje de Victoria o Derrota.

**Animaciones:**  
- Las animaciones de acciones durante el turno no deben superar los 2 segundos.
- La animación de victoria o derrota no debe superar los 3 segundos.

**Responsable:** Supported / Francisco Villa  
**Prioridad:** Crítica
