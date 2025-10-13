package com.fighterstime.app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fighterstime.app.data.DbConnection
import com.fighterstime.app.data.SaveFile
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val DbConnection = DbConnection()

    fun saveGame(userName: String, saveFileName: String) {
        viewModelScope.launch {
            val saveFile = SaveFile(
                userName = userName,
                saveFileName = saveFileName,
                characterName = "resta",
                posX = 100.5f,
                posY = 250.3f,
                exp = 1500
            )

            val result = DbConnection.saveSaveFile(saveFile)
            result.onSuccess { docId ->
                println("Guardado exitoso con ID: $docId")
            }.onFailure { exception ->
                println("Error al guardar: ${exception.message}")
            }
        }
    }

    fun loadGame(userName: String, saveFileName: String) {
        viewModelScope.launch {
            val result = DbConnection.loadSaveFileByName(userName, saveFileName)
            result.onSuccess { pair ->
                if (pair != null) {
                    val (docId, saveFile) = pair
                    println("Cargado: ${saveFile.characterName}")
                } else {
                    println("No se encontró el archivo de guardado")
                }
            }.onFailure { exception ->
                println("Error al cargar: ${exception.message}")
            }
        }
    }

    fun updatePlayerPosition(documentId: String, newX: Float, newY: Float) {
        viewModelScope.launch {
            val updates = mapOf(
                "posX" to newX,
                "posY" to newY
            )
            val result = DbConnection.updateSaveFile(documentId, updates)
            result.onSuccess {
                println("Posición actualizada")
            }.onFailure { exception ->
                println("Error al actualizar: ${exception.message}")
            }
        }
    }
}