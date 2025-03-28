package org.example.storage

import org.example.dto.CocheDto
import org.example.mapper.toModel
import org.example.models.Coche
import org.example.models.Motor
import java.io.File

class CocheCsv:CocheStorage {

    override fun fileRead(file: File): List<Coche> {
        return  file.readLines()
            .drop(1)
            .map { it.split(",") }
            .map { CocheDto(
                matricula = it[0],
                marca = it[1],
                motor = it[2],
                fechaMatriculacion = it[3]
            ).toModel()
            }
    }

    override fun fileWrite(garaje: List<Coche>, file: File) {
        TODO("Not yet implemented")
    }
}