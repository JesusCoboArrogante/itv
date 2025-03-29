package org.example.mapper

import org.example.dao.CocheEntity
import org.example.models.Coche

fun CocheEntity.toModel(): Coche = Coche(
    matricula = this.matricula,
    marca = this.matricula,
    motor = this.motor,
    fechaMatriculacion = this.fechaMatriculacion
)

fun Coche.toEntity(): CocheEntity = CocheEntity(
    matricula = this.matricula,
    marca = this.matricula,
    motor = this.motor,
    fechaMatriculacion = this.fechaMatriculacion
)