# Documentación del Proyecto: Sistema de Progresión

## 1. Introducción

Este codigo es un sistema de progresión de niveles de personaje, similar a los que se encuentran en los juegos de rol (RPG). Cuenta con una interfaz visual que permite al usuario simular la ganancia de experiencia, subir de nivel y ver cómo mejoran los atributos de un personaje.

El código está escrito en **Kotlin** y utiliza componentes modernos de Android para la interfaz de usuario.

## 2. Características Principales

* **Sistema de Experiencia (EXP):** El personaje gana una cantidad aleatoria de experiencia al "derrotar un enemigo".
* **Subida de Nivel (Level Up):** Cuando la experiencia actual alcanza el umbral necesario, el personaje sube de nivel.
* **Atributos Mejorados:** Al subir de nivel, los atributos del personaje (Vida, Ataque, Defensa, Velocidad) aumentan.
* **Curva de Experiencia Dinámica:** La cantidad de experiencia necesaria para el siguiente nivel aumenta con cada nivel, haciendo la progresión más desafiante.
* **Interfaz de Usuario Reactiva:** La pantalla se actualiza en tiempo real para mostrar el nivel, la experiencia y los atributos actuales.
* **Reinicio de Progreso:** Un botón permite restablecer todas las estadísticas del personaje a su estado inicial.

## 3. ¿Cómo Funciona el Código? (Lógica Principal)

Toda la lógica del sistema de progresión se encuentra en el archivo `MainActivity.kt`.

#### Variables Clave:
* `currentLevel`: Almacena el nivel actual del personaje.
* `currentExp`: La cantidad de EXP acumulada en el nivel actual.
* `expToNextLevel`: La cantidad total de EXP necesaria para pasar al siguiente nivel.
* `vida`, `ataque`, `defensa`, `velocidad`: Los atributos base del personaje.

#### Flujo de Eventos:

1.  **Ganar Experiencia (`gainExperience`):**
    * Cuando el usuario presiona el botón "Derrotar Enemigo", se llama a la función `defeatEnemy()`, que a su vez invoca a `gainExperience()` con una cantidad aleatoria de EXP (entre 15 y 35).
    * La EXP ganada se suma a `currentExp`.
    * Se entra en un bucle `while` que comprueba si `currentExp` es mayor o igual que `expToNextLevel`.

2.  **Subir de Nivel (`levelUp`):**
    * Si la condición del bucle es verdadera, se llama a la función `levelUp()`.
    * Se resta `expToNextLevel` de `currentExp`, conservando el excedente de experiencia para el nuevo nivel.
    * Se incrementa `currentLevel`.
    * Los atributos (`vida`, `ataque`, etc.) aumentan según valores predefinidos:
        * **Vida:** +10
        * **Ataque:** +5
        * **Defensa:** +3
        * **Velocidad:** +1
    * Se calcula la nueva cantidad de `expToNextLevel` usando la fórmula: `(Nivel Actual × 150) + 100`.
    * Finalmente, se actualiza la interfaz de usuario.

## 4. Tecnologías y Librerías Utilizadas

* **Lenguaje:** **Kotlin**
* **Kit de Desarrollo:** **Android SDK**
* **Interfaz de Usuario:**
    * **XML** para la maquetación de vistas.
    * **Material Components:** Para los elementos visuales como `CardView` y `MaterialButton`.
    * **ConstraintLayout:** Para un diseño de pantalla flexible y adaptable.
* **Sistema de Build:** **Gradle**

## 5. Personalización

Si deseas modificar el balance del juego, puedes ajustar fácilmente las siguientes variables y valores dentro de `MainActivity.kt`:

* **Experiencia por enemigo:** Modifica el rango en la función `defeatEnemy()`:
    ```kotlin
    val expGained = (15..35).random() // Cambia 15 y 35
    ```

* **Atributos iniciales y por nivel:** Cambia los valores iniciales en la declaración de variables y los incrementos dentro de la función `levelUp()`:
    ```kotlin
    private fun levelUp() {
        // ...
        vida += 10      // Cambia el 10
        ataque += 5     // Cambia el 5
        defensa += 3    // Cambia el 3
        velocidad += 1  // Cambia el 1
        // ...
    }
    ```

* **Fórmula de experiencia por nivel:** Modifica la función `calculateExpForNextLevel()`:
    ```kotlin
    private fun calculateExpForNextLevel(currentLevel: Int): Int {
        return (currentLevel * 150) + 100 // Cambia 150 y 100
    }
    ```