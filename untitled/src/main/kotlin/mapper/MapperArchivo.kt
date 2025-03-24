package org.example.mapper

import org.example.dto.CocheDto
import org.example.models.Coche
import org.example.models.Motor
import java.time.LocalDate


    fun CocheDto.toModel(): Coche{
      return  Coche(
            matricula = matricula,
            marca = marca,
            motor = Motor.valueOf(motor!!),
            fechaMatriculacion = LocalDate.parse(fechaMatriculacion)
        )
    }

    fun Coche.toDto(): CocheDto {
        return CocheDto(
            matricula = matricula,
            marca = marca,
            motor = motor.toString(),
            fechaMatriculacion = fechaMatriculacion.toString()
        )
    }

}