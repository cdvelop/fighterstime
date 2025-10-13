package com.fighterstime.app.data
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "fighterstime.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        // Crear tabla de progreso
        db.execSQL(
            """
            CREATE TABLE progreso_jugador (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre_usuario TEXT,
                nombre_personaje TEXT,
                pos_x REAL,
                pos_y REAL,
                experiencia INTEGER
            )
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS progreso_jugador")
        onCreate(db)
    }
}
