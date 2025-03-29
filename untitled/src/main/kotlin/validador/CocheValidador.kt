package org.example.validador

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.example.error.CocheError
import org.example.models.Coche
import java.time.LocalDate

class CocheValidador: Validator<Coche, CocheError> {
    val matriculaRegex = Regex("^[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$")

    override fun validate(it: Coche): Result<Coche, CocheError> {
        if (it.matricula.isBlank()) {
            return Err(CocheError.validationError("la matricula no puede estar vacia"))
        }
        if (!matriculaRegex.matches(it.matricula)) {
            return Err(CocheError.validationError("la matricula ${it.matricula} no es correcta"))
        }

        if (it.fechaMatriculacion > LocalDate.now()){
            return Err(CocheError.validationError("McFly regresa al futuro o pon la matricula bien"))
        }


    return Ok(it)
}
}