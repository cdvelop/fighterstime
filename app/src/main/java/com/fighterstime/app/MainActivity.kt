package com.fighterstime.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fighterstime.app.data.PlayerProgressRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear repositorio
        val repo = PlayerProgressRepository(this)

        // Guardar datos
        repo.guardarProgreso("Jugador1", "Ryu", 120.5, 80.3, 1500)
    }
}
