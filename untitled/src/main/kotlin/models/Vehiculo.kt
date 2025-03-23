package org.example.models

import java.time.LocalDate

abstract class Vehiculo(
    var matricula:String,
    val marca:String,
    val motor: Motor,
    val fechaMatriculacion: LocalDate

){

    enum class Motor {
        ELECTRICO,COMBUSTION,HIBRIDO
    }
}