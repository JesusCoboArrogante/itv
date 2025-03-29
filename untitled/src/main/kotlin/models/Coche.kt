package org.example.models

import java.time.LocalDate

class Coche(
    matricula: String,
    marca: String,
    motor: Motor,
    fechaMatriculacion: LocalDate):
    Vehiculo(matricula, marca, motor, fechaMatriculacion
) {
}