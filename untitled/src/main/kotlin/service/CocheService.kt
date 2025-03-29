package org.example.service

import com.github.michaelbull.result.Result
import org.example.error.CocheError
import org.example.models.Coche

interface CocheService {
    fun findAll(): List<Coche>
    fun findById(matricula: String): Result<Coche, CocheError>
    fun save(coche: Coche): Result<Coche, CocheError>
    fun update(matricula: String, coche: Coche): Result<Coche, CocheError>
    fun delete(matricula: String): Result<Coche, CocheError>
}