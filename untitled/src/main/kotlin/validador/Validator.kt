package org.example.validador
import com.github.michaelbull.result.Result
interface Validator<T, E> {
    fun validate(it: T): Result<T,E>
}