package org.example.storage

import org.example.models.Coche
import java.io.File

interface CocheStorage {
    fun fileRead (file: File): List<Coche>
    fun fileWrite (garaje: List<Coche>, file: File)

}