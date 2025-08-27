# RF 02 : SISTEMA DE COMBATE
El combate tendrá un tiempo limite de 180s (3 minutos) 
El daño será calculado de manera tal que la defensa de el personaje que recibe el ataque sea afectada antes que la vida de total del jugador.
por lo tanto si un personaje tiene 10 de defensa y el atacante le hace 7 de daño esta defensa pasa a ser 3, lo cual lo deja mucho más serca de recibir daño total.
si recibe un daño mayor a la defensa base del personaje, se le aplicara el dato restante a la vida total de quien recibio el ataque, Por Ejemplo, si un jugador tiene 10 de defensa y recibe 11 de daño, pierde su defensa total, dejandolo expuesto y recibiendo 1 de daño total en la vida del jugador siendo atacado.

Daño = (ataque-defensa) // si el ataque resulta ser menor a la defensa no se acepta el valor negativo y se cambia a 0.


## Estadisticas de cada clase (puntos base a nivel 1)

    Vikingo (Alto daño, defensa, y HP base, bajo poder y velocidad)

        HP(vitalidad): 10
        Ataque(letalidad): 7 
        Defensa: 8
        Velocidad(): 4
        Poder: 2
        Exp: {}

    Arquero (Daño y defensa baso bajos, pero alto poder y velocidad y vida media)

        HP(vitalidad): 6
        Ataque(letalidad): 5
        Defensa: 4
        Velocidad(): 8
        Poder: 7
        Exp: {}

    Mago (Daño y defensa medio-bajo, poder muy alto y velocidad media)

        HP(vitalidad): 5
        Ataque(letalidad): 5 
        Defensa: 6
        Velocidad(): 7
        Poder: 9
        Exp: {}

    Goblin (Enemigo npc de prueba)

        HP(vitalidad): 3
        Ataque(letalidad): 2 
        Defensa: 2
        Velocidad(): 3
        Poder: 1
        Exp: {5}

El Stat de "poder" es el que define la efectividad al momento de ocupar habilidades o items, personajes como "magos" o "arqueros" tendran alta habilidad, mientras tanto
los vikingos, tendran bajo "poder", pero una stat de ataque(letalidad) base alto.
Para subir de nivel, el jugador recibirá experiencia, la cual al momento de subir de nivel, se transformará en 1 punto "perk" el cual el jugador puede seleccionar donde se va a ocupar para mejorar la estadistica deseada.
El sistema de progresión premiará a el jugador por llegar a distintas metas de nivel, por ej:
Si el jugador llega a nivel 5, como recompenza por lograr esto se le otorgara una recompensa de progresión el cual puede ser uno de 3 items los cuales se especializan en subir una estadistica base en especifico (HP, Ataque, Defensa) el jugador puede escoger uno de estos 3 items.

Responsables: Diego González
Grupo: StarProgramming

prioridad: Critica
__________________________________________________________________________________________________________________________________________________________
//## Balance (wip)
//La defensa será un valor el cual puede ser afectado a travez de la batalla ya sea con items o buffs, la defensa base verá cuanta defensa será absorbida
//el estat de poder definirá cuanto será aumentado el ataque, este se puede aumentar con items o otros movimientos de buff
//


//c es una constante más grande de 1, puede ser entre 1.01 y 1.1.
//Pa es el poder del atacante
//La es la letalidad del atacante
//Pia is la penetración del atacante
//Vt es la vitalidad del objetivo
//Pt es el poder del objetivo
//c2 es un numero constante positivo que determina cual es la efectividad del stat penetracion y letalidad


//max hp = c^(Vt/2)
//healing = c^(Pa/2)
//Daño = c^(Pa - Vt/2 + c2(La * PT + Pia *Vt)/(Pt + Vt))
__________________________________________________________________________________________________________________________________________________________