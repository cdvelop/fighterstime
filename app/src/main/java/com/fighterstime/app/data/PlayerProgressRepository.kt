package com.fighterstime.app.data

import android.content.ContentValues
import android.content.Context

class PlayerProgressRepository(context: Context) {
    private val dbHelper = DatabaseHelper(context)

    // Guardar progreso
    fun guardarProgreso(nombreUsuario: String, nombrePersonaje: String, posX: Double, posY: Double, experiencia: Int) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("nombre_usuario", nombreUsuario)
            put("nombre_personaje", nombrePersonaje)
            put("pos_x", posX)
            put("pos_y", posY)
            put("experiencia", experiencia)
        }
        db.insert("progreso_jugador", null, values)
        db.close()
    }

    // Cargar progreso
    fun cargarProgreso(nombreUsuario: String): String {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM progreso_jugador WHERE nombre_usuario = ?",
            arrayOf(nombreUsuario)
        )

        var resultado = "No hay progreso guardado"
        if (cursor.moveToFirst()) {
            val personaje = cursor.getString(cursor.getColumnIndexOrThrow("nombre_personaje"))
            val x = cursor.getDouble(cursor.getColumnIndexOrThrow("pos_x"))
            val y = cursor.getDouble(cursor.getColumnIndexOrThrow("pos_y"))
            val exp = cursor.getInt(cursor.getColumnIndexOrThrow("experiencia"))

            resultado = "Personaje: $personaje, PosX: $x, PosY: $y, Exp: $exp"
        }

        cursor.close()
        db.close()
        return resultado
    }
}
