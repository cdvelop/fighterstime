package com.example.characterskt.personajes

/**
 * Clase base abstracta para todos los personajes del juego (héroes y enemigos).
 * No se puede instanciar directamente.
 */
abstract class Personaje(
    val nombre: String,
    var nivel: Int,
    var vidaMaxima: Int,
    var vidaActual: Int,
    var ataque: Int,
    var defensa: Int,
    var velocidad: Int,
    var poder: Int,
    var manaMaximo: Int,
    var manaActual: Int = manaMaximo
) {

    /**
     * Ataca a otro personaje, calculando el daño según la defensa del objetivo.
     * @param objetivo El personaje que recibirá el ataque.
     */
    open fun atacar(objetivo: Personaje) {
        println("\n$nombre ataca a ${objetivo.nombre}!")
        val danoBase = this.ataque - objetivo.defensa

        if (danoBase > 0) {
            if (objetivo.defensa > 0) {
                val defensaAnterior = objetivo.defensa
                objetivo.defensa = Math.max(0, objetivo.defensa - this.ataque)
                val defensaPerdida = defensaAnterior - objetivo.defensa
                println("${objetivo.nombre} pierde $defensaPerdida de defensa. Defensa: ${objetivo.defensa}")
            }

            objetivo.vidaActual = Math.max(0, objetivo.vidaActual - danoBase)
            println("${objetivo.nombre} recibe $danoBase de daño. Vida: ${objetivo.vidaActual}/${objetivo.vidaMaxima}")
        } else {
            println("Ataque bloqueado por la defensa!")
        }
    }

    /**
     * Aplica una cantidad de daño directo al personaje (ignora defensa).
     * @param cantidad La cantidad de daño a recibir.
     */
    open fun recibirDano(cantidad: Int) {
        vidaActual = Math.max(0, vidaActual - cantidad)
        println("$nombre recibe $cantidad de daño. Vida: $vidaActual/$vidaMaxima")
    }

    /**
     * Comprueba si el personaje sigue con vida.
     * @return `true` si la vida actual es mayor a 0.
     */
    fun estaVivo(): Boolean = vidaActual > 0

    /**
     * Muestra las estadísticas actuales del personaje en la consola.
     */
    open fun mostrarEstado() {
        println("=== $nombre ===")
        println("Nivel: $nivel")
        println("Vida: $vidaActual/$vidaMaxima")
        println("Ataque: $ataque | Defensa: $defensa")
        println("Velocidad: $velocidad | Poder: $poder")
        println("Maná: $manaActual/$manaMaximo")
    }
}


/**
 * Representa a un enemigo básico. Hereda de `Personaje`.
 *
 * @property habilidadEspecial Descripción de la habilidad del enemigo.
 * @property experienciaOtorgada Puntos de experiencia que da al ser derrotado.
 */
open class EnemigoBasico(
    nombre: String,
    nivel: Int,
    vidaMaxima: Int,
    ataque: Int,
    defensa: Int = 0,
    velocidad: Int = 5,
    poder: Int = 5,
    manaMaximo: Int = 50,
    val habilidadEspecial: String,
    val experienciaOtorgada: Int = nivel * 50
) : Personaje(nombre, nivel, vidaMaxima, vidaMaxima, ataque, defensa, velocidad, poder, manaMaximo) {

    /**
     * Devuelve la experiencia si el enemigo ha sido derrotado.
     * @return La cantidad de experiencia, o 0 si sigue vivo.
     */
    fun otorgarExperiencia(): Int {
        return if (!estaVivo()) experienciaOtorgada else 0
    }

    /**
     * Muestra el estado del enemigo, incluyendo su habilidad especial.
     */
    override fun mostrarEstado() {
        super.mostrarEstado()
        println("Habilidad: $habilidadEspecial")
    }
}

/**
 * Representa a un enemigo avanzado con maná y habilidades complejas.
 * Hereda de `EnemigoBasico`.
 *
 * @property costeMana Coste de maná para la habilidad especial.
 * @property probabilidadCuracion Probabilidad (en %) de que el enemigo se cure a sí mismo.
 */
class EnemigoAvanzado(
    nombre: String,
    nivel: Int,
    vidaMaxima: Int,
    ataque: Int,
    defensa: Int = 0,
    velocidad: Int = 5,
    poder: Int = 10,
    manaMaximo: Int = 100,
    habilidadEspecial: String,
    experienciaOtorgada: Int = nivel * 50,
    val costeMana: Int,
    val probabilidadCuracion: Int = 20
) : EnemigoBasico(nombre, nivel, vidaMaxima, ataque, defensa, velocidad, poder, manaMaximo, habilidadEspecial, experienciaOtorgada) {

    /** Comprueba si el enemigo tiene suficiente maná para su habilidad. */
    fun tieneMana(): Boolean = manaActual >= costeMana

    /**
     * Usa una habilidad especial si tiene suficiente maná.
     * El efecto varía según el nombre del enemigo.
     * @param objetivo El personaje que recibe el ataque.
     */
    fun usarHabilidadEspecial(objetivo: Personaje?) {
        if (!estaVivo()) {
            println("$nombre no puede usar habilidades porque está derrotado.")
            return
        }
        if (!tieneMana()) {
            println("$nombre no tiene suficiente mana para usar $habilidadEspecial. (Mana: $manaActual/$costeMana)")
            return
        }

        println("¡$nombre usa $habilidadEspecial!")

        when (nombre) {
            "Oso Zombie Maldito" -> {
                objetivo?.let {
                    val dano = (ataque * 1.8).toInt()
                    println("Zarpazo maldito envenenado...")
                    it.recibirDano(dano)
                    println("${it.nombre} ha sido envenenado!")
                }
                manaActual -= costeMana
            }
            "Guerrero Zombie Espectral" -> {
                objetivo?.let {
                    val dano = (ataque * 2.0).toInt()
                    println("Corte espectral atraviesa las defensas...")
                    it.recibirDano(dano)
                }
                manaActual -= costeMana
            }
            "Hechicero Espectral" -> {
                objetivo?.let {
                    val dano = ataque + (manaActual / 2)
                    println("Lanza una bola de fuego espectral devastadora...")
                    it.recibirDano(dano)
                }
                manaActual -= costeMana
            }
            else -> {
                objetivo?.recibirDano(ataque)
                manaActual -= costeMana
            }
        }
    }

    /**
     * Intenta curarse a sí mismo según una probabilidad.
     * @param cantidad La cantidad de vida a recuperar (por defecto, 25% de la vida máxima).
     */
    fun curarse(cantidad: Int = vidaMaxima / 4) {
        val probabilidad = (0..99).random()
        if (probabilidad < probabilidadCuracion) {
            val vidaAnterior = vidaActual
            vidaActual = Math.min(vidaMaxima, vidaActual + cantidad)
            val vidaRecuperada = vidaActual - vidaAnterior
            println("¡$nombre se cura a sí mismo!")
            println("$nombre recupera $vidaRecuperada puntos de vida. Vida: $vidaActual/$vidaMaxima")
        } else {
            println("$nombre intenta curarse pero falla...")
        }
    }

    /**
     * Regenera una cantidad de maná.
     * @param cantidad La cantidad de maná a regenerar (por defecto, 20).
     */
    fun regenerarMana(cantidad: Int = 20) {
        val manaAnterior = manaActual
        manaActual = Math.min(manaMaximo, manaActual + cantidad)
        val manaRegenerado = manaActual - manaAnterior

        if (manaRegenerado > 0) {
            println("$nombre regenera $manaRegenerado de maná. Maná: $manaActual/$manaMaximo")
        }
    }

    /**
     * Lógica de IA simple para decidir la acción del enemigo en su turno.
     * @param objetivo El personaje a atacar.
     */
    fun turnoIA(objetivo: Personaje) {
        if (!estaVivo()) {
            return
        }

        println("\n--- Turno de $nombre ---")

        val porcentajeVida = (vidaActual.toDouble() / vidaMaxima.toDouble()) * 100
        if (porcentajeVida < 30.0) {
            curarse()
            return
        }

        if (tieneMana()) {
            usarHabilidadEspecial(objetivo)
        } else {
            atacar(objetivo)
            regenerarMana(15)
        }
    }
}
