#!/usr/bin/env kotlin
package com.example.fighterstime.data

import android.content.Context
import java.io.File

// Datos del jugador
data class PlayerData(
    val nombreUsuario: String,
    val nombrePersonaje: String,
    val posX: Float,
    val posY: Float,
    val experiencia: Int
)

// Sistema de guardado básico
object SaveSystem {

    private const val FILE_NAME = "playerdata.sav"

    // Guarda los datos en formato de texto
    fun guardarDatos(context: Context, datos: PlayerData) {
        val contenido = """
            nombreUsuario=${datos.nombreUsuario}
            nombrePersonaje=${datos.nombrePersonaje}
            posX=${datos.posX}
            posY=${datos.posY}
            experiencia=${datos.experiencia}
        """.trimIndent()

        val file = File(context.filesDir, FILE_NAME)
        file.writeText(contenido)
    }

    // Carga los datos desde el archivo
    fun cargarDatos(context: Context): PlayerData? {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return null

        val lineas = file.readLines()
        val datos = mutableMapOf<String, String>()

        for (linea in lineas) {
            val partes = linea.split("=")
            if (partes.size == 2) {
                datos[partes[0]] = partes[1]
            }
        }

        return PlayerData(
            nombreUsuario = datos["nombreUsuario"] ?: "",
            nombrePersonaje = datos["nombrePersonaje"] ?: "",
            posX = datos["posX"]?.toFloatOrNull() ?: 0f,
            posY = datos["posY"]?.toFloatOrNull() ?: 0f,
            experiencia = datos["experiencia"]?.toIntOrNull() ?: 0
        )
    }

    // Borra los datos guardados (opcional)
    fun borrarDatos(context: Context) {
        val file = File(context.filesDir, FILE_NAME)
        if (file.exists()) file.delete()
    }
}
