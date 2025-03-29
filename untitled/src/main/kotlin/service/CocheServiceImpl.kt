package org.example.service

import com.github.benmanes.caffeine.cache.Cache
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import org.example.error.CocheError
import org.example.models.Coche
import org.example.repository.RepositoryImp
import org.example.validador.Validator

class CocheServiceImpl(
    private val cache: Cache<String,Coche>,
    private val validador: Validator<Coche, CocheError>,
    private val repository: RepositoryImp
):CocheService {
    override fun findAll(): List<Coche> {
        return repository.getAll()
    }

    override fun findById(matricula: String): Result<Coche, CocheError> {
        return cache.getIfPresent(matricula)?.let {
            Ok(it)
        }?: repository.getById(matricula)?.let {
            cache.put(matricula,it)
            Ok(it)
        }?: Err(CocheError.NotFoundError(matricula))
    }

    override fun save(coche: Coche): Result<Coche, CocheError> {
        return validador.validate(coche).andThen { Ok(repository.save(it))}
    }

    override fun update(matricula: String, coche: Coche): Result<Coche, CocheError> {
        TODO("Not yet implemented")
    }

    override fun delete(matricula: String): Result<Coche, CocheError> {
        TODO("Not yet implemented")
    }


}