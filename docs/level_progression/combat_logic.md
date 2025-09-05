# Lógica del Sistema de Combate

Este documento detalla las mecánicas y las reglas fundamentales que rigen el combate en el juego.

---

### **1. Duración del Combate**

El combate tiene un límite de tiempo estricto de **180 segundos (3 minutos)**.

---

### **2. Cálculo de Daño**

El daño se calcula en dos fases, afectando primero la defensa y luego la vida del personaje.

* **Daño a la Defensa:** La **Defensa** de un personaje actúa como una barrera que absorbe el daño entrante. El valor del ataque se resta directamente de la defensa.
    * **Ejemplo:** Si un personaje tiene 10 de Defensa y recibe 7 de daño, su defensa se reduce a 3.
* **Daño a la Vida (HP):** Si el ataque del oponente es mayor que la defensa del personaje, la defensa se anula por completo y el daño restante se aplica directamente a la **Vida (HP)** del personaje.
    * **Ejemplo:** Si un personaje tiene 10 de Defensa y recibe 11 de daño, su defensa se pierde y recibe 1 de daño en su HP.

La fórmula base para el cálculo del daño es:

$Daño = (Ataque - Defensa)$

Si el resultado de la operación es un número negativo (el ataque es menor que la defensa), el daño infligido es 0.

---

### **3. Estadísticas de Clases y Habilidades**

Cada clase de personaje tiene estadísticas base únicas que definen su estilo de juego.

* **Vikingo:** Alto HP, Ataque y Defensa. Baja Velocidad y Poder.
* **Arquero:** HP y Defensa medias. Alto Ataque, Poder y Velocidad.
* **Mago:** HP y Ataque medios-bajos. Muy alto Poder. Velocidad media.
* **Goblin (NPC):** Estadísticas de combate bajas.

El stat de **Poder** es crucial para la efectividad de las habilidades especiales y el uso de ítems. Las clases como el Mago y el Arquero, con alto Poder, son más efectivas usando estas habilidades, mientras que el Vikingo se basa en su alto Ataque base.

---

### **4. Consideraciones Adicionales**

* **Balance (WIP):** La **Defensa** es un valor dinámico que puede ser alterado con ítems o buffs durante el combate.
* **Ataque Aumentado:** El stat de **Poder** del atacante (`Pa`) y otros factores pueden aumentar el daño del ataque. Aunque la fórmula final aún está en desarrollo, considera la interacción de la Letalidad (`La`), el Poder del Atacante (`Pa`) y la Penetración (`Pia`) para calcular el daño final.