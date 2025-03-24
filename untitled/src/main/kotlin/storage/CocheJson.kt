package org.example.storage

import kotlinx.serialization.json.Json
import org.example.dto.CocheDto
import org.example.mapper.toDto
import org.example.models.Coche
import java.io.File

class CocheJson:CocheStorage {
    override fun fileRead(): List<Coche> {
        TODO("Not yet implemented")
    }

    override fun fileWrite(garaje: List<Coche>, file: File) {
        val newFile = File("data", "newCoche.json")
        val json = Json { ignoreUnknownKeys = true; prettyPrint = true }
        val jsonWriter = Json{prettyPrint = true}
        val CocheDto = newCoche.map{it.toDto}
    }


}