package com.fighterstime.app.data

// Modelo de datos para los archivos guardados
data class SaveFile(
    val userName: String = "",
    val saveFileName: String = "",
    val characterName: String = "",
    val posX: Float = 0f,
    val posY: Float = 0f,
    val exp: Int = 0
)
