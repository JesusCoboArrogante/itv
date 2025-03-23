package org.example.extesions

import org.example.models.Coche
import org.example.models.Vehiculo.Motor
import java.time.LocalDate

fun Coche.copy(
    newMatricula: String = this.matricula,
    newMarca: String = this.marca,
    newMotor: Motor = this.motor,
    newMatriculacion: LocalDate = this.fechaMatriculacion
    ):Coche {
    return Coche(
        matricula = newMatricula,
        marca = newMarca,
        motor = newMotor,
        fechaMatriculacion = newMatriculacion,
    )


}