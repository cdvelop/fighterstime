package com.fighterstime.app.data


import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.fighterstime.app.data.SaveFile
import kotlinx.coroutines.tasks.await


class DbConnection {
    private val db: FirebaseFirestore = Firebase.firestore
    private val collectionName = "saveFiles"

    // Guardar un nuevo archivo de guardado
    suspend fun saveSaveFile(saveFile: SaveFile): Result<String> {
        return try {
            val docRef = db.collection(collectionName)
                .add(saveFile)
                .await()
            Result.success(docRef.id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Guardar con un ID específico (útil para sobrescribir)
    suspend fun saveSaveFileWithId(documentId: String, saveFile: SaveFile): Result<Unit> {
        return try {
            db.collection(collectionName)
                .document(documentId)
                .set(saveFile)
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Actualizar un archivo de guardado existente
    suspend fun updateSaveFile(documentId: String, updates: Map<String, Any>): Result<Unit> {
        return try {
            db.collection(collectionName)
                .document(documentId)
                .update(updates)
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Cargar un archivo de guardado específico por ID
    suspend fun loadSaveFile(documentId: String): Result<SaveFile> {
        return try {
            val document = db.collection(collectionName)
                .document(documentId)
                .get()
                .await()

            val saveFile = document.toObject(SaveFile::class.java)
            if (saveFile != null) {
                Result.success(saveFile)
            } else {
                Result.failure(Exception("SaveFile no encontrado"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Cargar todos los archivos de guardado de un usuario
    suspend fun loadSaveFilesByUser(userName: String): Result<List<Pair<String, SaveFile>>> {
        return try {
            val querySnapshot = db.collection(collectionName)
                .whereEqualTo("userName", userName)
                .get()
                .await()

            val saveFiles = querySnapshot.documents.mapNotNull { doc ->
                doc.toObject(SaveFile::class.java)?.let { saveFile ->
                    doc.id to saveFile
                }
            }
            Result.success(saveFiles)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Cargar un archivo específico por nombre de usuario y nombre de archivo
    suspend fun loadSaveFileByName(userName: String, saveFileName: String): Result<Pair<String, SaveFile>?> {
        return try {
            val querySnapshot = db.collection(collectionName)
                .whereEqualTo("userName", userName)
                .whereEqualTo("saveFileName", saveFileName)
                .limit(1)
                .get()
                .await()

            val result = querySnapshot.documents.firstOrNull()?.let { doc ->
                doc.toObject(SaveFile::class.java)?.let { saveFile ->
                    doc.id to saveFile
                }
            }
            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // Eliminar un archivo de guardado
    suspend fun deleteSaveFile(documentId: String): Result<Unit> {
        return try {
            db.collection(collectionName)
                .document(documentId)
                .delete()
                .await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
