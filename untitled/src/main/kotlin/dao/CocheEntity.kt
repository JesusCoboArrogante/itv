package org.example.dao

import org.example.models.Vehiculo.Motor
import java.time.LocalDate

data class CocheEntity(
    var matricula:String,
    val marca:String,
    val motor: Motor,
    val fechaMatriculacion: LocalDate

)
