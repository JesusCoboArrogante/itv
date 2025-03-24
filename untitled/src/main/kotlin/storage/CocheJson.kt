package org.example.storage

import kotlinx.serialization.json.Json
import org.example.dto.CocheDto
import org.example.mapper.toDto
import org.example.models.Coche
import java.io.File

class CocheJson:CocheStorage {
    override fun fileRead(file: File): List<Coche> {
        TODO("Not yet implemented")
    }

    override fun fileWrite(garaje: List<Coche>, file: File) {
        val json = Json { ignoreUnknownKeys = true; prettyPrint = true }
        val listaCocheDto : List<CocheDto> = garaje.mapNotNull {
            it.toDto()
        }
        val  jsonString:String = json.encodeToString(listaCocheDto)
        file.writeText(jsonString)
    }

}