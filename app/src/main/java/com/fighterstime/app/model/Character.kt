package com.fighterstime.app.model

class Character {
}

package personajes

/**
 * Clase abstracta que representa a un personaje genérico en el juego.
 * Es una clase base de la cual heredarán todos los demás personajes (héroes y enemigos).
 * Al ser 'abstracta', no se pueden crear instancias directas de esta clase.
 *
 * @property nombre El nombre del personaje.
 * @property nivel El nivel actual del personaje.
 * @property vidaMaxima La cantidad máxima de puntos de vida que puede tener el personaje.
 * @property vidaActual La cantidad actual de puntos de vida del personaje.
 * @property ataque El valor de ataque del personaje, utilizado para infligir daño.
 * @property defensa El valor de defensa del personaje, utilizado para reducir el daño recibido.
 */
abstract class Personaje(
    val nombre: String,
    var nivel: Int,
    var vidaMaxima: Int,
    var vidaActual: Int,
    var ataque: Int,
    var defensa: Int
) {

    /**
     * Permite que el personaje ataque a otro.
     * Calcula el daño base y lo aplica al objetivo, considerando su defensa.
     * Se marca como 'open' para que las clases hijas puedan sobrescribir este comportamiento.
     *
     * @param objetivo El personaje que recibirá el ataque.
     */
    open fun atacar(objetivo: Personaje) {
        // Muestra un mensaje en la consola indicando quién ataca a quién.
        println("\n$nombre ataca a ${objetivo.nombre}!")

        // Calcula el daño base restando la defensa del objetivo al ataque del atacante.
        val danoBase = this.ataque - objetivo.defensa

        // Verifica si el ataque es efectivo (si el daño base es mayor que 0).
        if (danoBase > 0) {
            // Lógica para que el ataque reduzca permanentemente la defensa del objetivo.
            // Si la defensa del objetivo es mayor que 0, se reduce por el valor del ataque.
            if (objetivo.defensa > 0) {
                val defensaAnterior = objetivo.defensa
                objetivo.defensa = maxOf(0, objetivo.defensa - this.ataque)
                val defensaPerdida = defensaAnterior - objetivo.defensa
                println("${objetivo.nombre} pierde $defensaPerdida de defensa. Defensa: ${objetivo.defensa}")
            }

            // Reduce la vida actual del objetivo por el daño base.
            // maxOf(0, ...) asegura que la vida no baje de 0.
            objetivo.vidaActual = maxOf(0, objetivo.vidaActual - danoBase)

            // Muestra un mensaje con el daño recibido y la vida actual del objetivo.
            println("${objetivo.nombre} recibe $danoBase de daño. Vida: ${objetivo.vidaActual}/${objetivo.vidaMaxima}")
        } else {
            // Si el ataque es igual o menor que la defensa, el ataque es bloqueado.
            println("Ataque bloqueado por la defensa!")
        }
    }

    /**
     * Verifica si el personaje sigue vivo.
     *
     * @return `true` si la vida actual es mayor que 0; de lo contrario, `false`.
     */
    fun estaVivo(): Boolean = vidaActual > 0

    /**
     * Muestra el estado actual del personaje en la consola.
     * Se marca como 'open' para permitir que las clases hijas (como EnemigoBasico)
     * puedan añadir más información a esta visualización.
     */
    open fun mostrarEstado() {
        // Muestra el nombre, nivel, vida y estadísticas de ataque/defensa.
        println("=== $nombre ===")
        println("Nivel: $nivel")
        println("Vida: $vidaActual/$vidaMaxima")
        println("Ataque: $ataque | Defensa: $defensa")
    }
}


package personajes

/**
 * Clase que representa a un enemigo básico en el juego.
 * Hereda de la clase 'Personaje', lo que le otorga atributos como vida, ataque y defensa.
 * Se marca como 'open' para permitir que otras clases (como EnemigoAvanzado) puedan heredar de ella.
 *
 * @property nombre El nombre del enemigo.
 * @property nivel El nivel del enemigo, que afecta sus estadísticas y la experiencia que otorga.
 * @property vidaMaxima La vida máxima del enemigo.
 * @property ataque El valor de ataque del enemigo.
 * @property defensa El valor de defensa, con un valor por defecto de 0 si no se especifica.
 * @property habilidadEspecial Un string que describe la habilidad especial del enemigo.
 * @property experienciaOtorgada La cantidad de experiencia que este enemigo otorga al ser derrotado.
 * El valor se calcula automáticamente como el nivel del enemigo multiplicado por 50.
 */
open class EnemigoBasico(
    nombre: String,
    nivel: Int,
    vidaMaxima: Int,
    ataque: Int,
    defensa: Int = 0,
    val habilidadEspecial: String,
    val experienciaOtorgada: Int = nivel * 50
) : Personaje(nombre, nivel, vidaMaxima, vidaMaxima, ataque, defensa) {

    /**
     * Devuelve la experiencia que otorga este enemigo.
     * Esta función solo devuelve un valor si el enemigo ha sido derrotado.
     * La lógica está en la clase SistemaCombate, por lo que esta función es más bien
     * una utilidad para obtener el valor de la propiedad.
     *
     * @return La cantidad de experiencia si el enemigo está derrotado (vida <= 0).
     * Si el enemigo sigue vivo, retorna 0.
     */
    fun otorgarExperiencia(): Int {
        // 'estaVivo()' es un método heredado de la clase Personaje.
        return if (!estaVivo()) experienciaOtorgada else 0
    }

    /**
     * Sobrescribe el método 'mostrarEstado' de la clase 'Personaje'.
     * Llama a la implementación del padre (con 'super.mostrarEstado()') para mostrar la información básica
     * y luego añade la información específica de esta clase, que es la habilidad especial.
     */
    override fun mostrarEstado() {
        // Llama al método 'mostrarEstado' de la clase Personaje.
        super.mostrarEstado()
        // Añade una línea para mostrar la habilidad especial del enemigo.
        println("Habilidad: $habilidadEspecial")
    }
}

package personajes

/**
 * Clase que representa a un enemigo avanzado con habilidades especiales y un sistema de maná.
 * Hereda de 'EnemigoBasico', lo que le da acceso a todas sus propiedades y métodos,
 * además de las de la clase 'Personaje'.
 *
 * @property manaMaximo La cantidad máxima de maná que el enemigo puede tener.
 * @property manaActual La cantidad actual de maná.
 * @property costeMana El maná requerido para usar la habilidad especial.
 * @property probabilidadCuracion Un porcentaje que determina la probabilidad de que el enemigo se cure.
 */
class EnemigoAvanzado(
    nombre: String,
    nivel: Int,
    vidaMaxima: Int,
    ataque: Int,
    defensa: Int = 0,
    habilidadEspecial: String,
    experienciaOtorgada: Int = nivel * 50,
    val manaMaximo: Int,
    var manaActual: Int = manaMaximo,
    val costeMana: Int,
    val probabilidadCuracion: Int = 20
) : EnemigoBasico(nombre, nivel, vidaMaxima, ataque, defensa, habilidadEspecial, experienciaOtorgada) {

    /**
     * Comprueba si el enemigo tiene suficiente maná para usar su habilidad especial.
     * @return `true` si el maná actual es mayor o igual al coste de la habilidad, `false` en caso contrario.
     */
    fun tieneMana(): Boolean = manaActual >= costeMana

    /**
     * Permite al enemigo usar su habilidad especial en un objetivo.
     * La función primero verifica si el enemigo está vivo y tiene suficiente maná antes de proceder.
     * Utiliza un bloque 'when' para aplicar diferentes efectos de daño basados en el nombre del enemigo.
     *
     * @param objetivo El personaje que recibirá el ataque de la habilidad. Puede ser nulo.
     */
    fun usarHabilidadEspecial(objetivo: Personaje?) {
        // Si el enemigo no está vivo, no puede usar la habilidad.
        if (!estaVivo()) {
            println("$nombre no puede usar habilidades porque está derrotado.")
            return
        }

        // Si no tiene suficiente maná, la habilidad no se activa.
        if (!tieneMana()) {
            println("$nombre no tiene suficiente mana para usar $habilidadEspecial. (Mana: $manaActual/$costeMana)")
            return
        }

        println("¡$nombre usa $habilidadEspecial!")

        // 'when' es una estructura de control que ejecuta código basado en el valor de una expresión.
        // Aquí, se evalúa el nombre del enemigo para determinar el efecto de la habilidad.
        when (nombre) {
            "Oso Zombie Maldito" -> {
                objetivo?.let {
                    val daño = (ataque * 1.8).toInt()
                    println("Zarpazo maldito envenenado...")
                    it.recibirDano(daño)
                    println("${it.nombre} ha sido envenenado!")
                }
                manaActual -= costeMana
            }
            "Guerrero Zombie Espectral" -> {
                objetivo?.let {
                    val daño = (ataque * 2.0).toInt()
                    println("Corte espectral atraviesa las defensas...")
                    it.recibirDano(daño)
                }
                manaActual -= costeMana
            }
            "Hechicero Espectral" -> {
                objetivo?.let {
                    val daño = ataque + (manaActual / 2)
                    println("Lanza una bola de fuego espectral devastadora...")
                    it.recibirDano(daño)
                }
                manaActual -= costeMana
            }
            else -> {
                // Comportamiento por defecto si el nombre no coincide con ninguno de los casos anteriores.
                objetivo?.recibirDano(ataque)
                manaActual -= costeMana
            }
        }
    }

    /**
     * El enemigo tiene una oportunidad de curarse a sí mismo.
     * La curación ocurre solo si se cumple una probabilidad predefinida.
     * @param cantidad La cantidad de vida a recuperar. Por defecto, es un cuarto de la vida máxima

### 1. Visión General del Sistema
Este sistema de código está diseñado para simular un juego de rol (RPG) simple, utilizando la **programación orientada a objetos (POO)** en Kotlin. La lógica principal se basa en una jerarquía de herencia que permite crear diferentes tipos de personajes, desde los más básicos hasta los más complejos, de una manera organizada y modular.


### 2. Estructura de Clases y su Lógica

El código se compone de tres clases principales, organizadas en una jerarquía de herencia para reutilizar el código y extender la funcionalidad.

* **Clase `Personaje` (Clase Padre)**
    Esta clase abstracta es el pilar del sistema. Define los atributos y comportamientos que son comunes a **todos** los personajes del juego, ya sean héroes o enemigos.
    * **Atributos:** Posee propiedades fundamentales como `nombre`, `nivel`, `vidaMaxima`, `vidaActual`, `ataque` y `defensa`.
    * **Métodos:** Contiene acciones básicas y genéricas como `atacar()`, `recibirDano()` y `mostrarEstado()`. El método `atacar()` calcula el daño basado en el ataque y la defensa, mientras que `recibirDano()` actualiza la vida del personaje.

* **Clase `EnemigoBasico` (Clase Hija)**
    Esta clase extiende la funcionalidad de la clase `Personaje`. Representa un tipo de personaje específico: un enemigo estándar.
    * **Herencia:** Hereda de `Personaje`, lo que significa que un `EnemigoBasico` tiene automáticamente todos los atributos y métodos de un `Personaje`.
    * **Funcionalidad Adicional:** Añade características únicas para los enemigos, como `habilidadEspecial` y `experienciaOtorgada`, que se calcula en función de su nivel.
    * **Sobrescritura (`override`):** Utiliza la palabra clave `override` en el método `mostrarEstado()` para añadir información específica del enemigo (su habilidad especial) al estado general heredado de `Personaje`.

* **Clase `EnemigoAvanzado` (Subclase)**
    Esta clase representa un enemigo más complejo y especializado. Hereda de `EnemigoBasico` y, por extensión, de `Personaje`, lo que le permite tener un comportamiento más sofisticado.
    * **Herencia en Cadena:** Gracias a la herencia, un `EnemigoAvanzado` no solo tiene vida y ataque, sino que también posee una `habilidadEspecial` y la capacidad de otorgar experiencia.
    * **Características Únicas:** Introduce nuevos atributos como `manaMaximo`, `manaActual` y `costeMana`, junto con métodos para gestionar el maná (`tieneMana()`, `regenerarMana()`).
    * **Lógica de IA:** El método `turnoIA()` es el corazón de la inteligencia artificial de este enemigo. Decide su acción en combate (atacar o usar su habilidad especial) basándose en su vida y maná, lo que lo convierte en un oponente más estratégico.
    * **Comportamiento de Habilidad:** El método `usarHabilidadEspecial()` utiliza una estructura `when` para aplicar diferentes efectos de daño basados en el nombre del enemigo, demostrando un comportamiento polimórfico.
