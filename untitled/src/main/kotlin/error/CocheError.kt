package org.example.error

sealed class CocheError (val messager: String) {
    class NotFoundError(matricula: String): CocheError("matricula $matricula no escontrada")
    class validationError(message:String): CocheError("Coche no valido $message")
}