package org.example.repository

import org.example.models.Coche
import sun.util.logging.resources.logging

class RepositoryImp:CrudRepository<String, Coche> {
    private val  logger = logging()
    private val garaje = mutableMapOf<String, Coche>()



    override fun save(entity: Coche): Coche {
        garaje[entity.matricula] = entity
        return entity

    }

    override fun delete(matricula:String): Coche? {
        return  garaje.remove(matricula)
    }

    override fun update(matricula: String, entity: Coche): Coche? {
        garaje[matricula]?: return null
        return garaje[matricula]
    }

    override fun getAll(): List<Coche> {
        return garaje.values.toList()
    }

    override fun getById(matricula: String, entity:Coche): Coche? {
        return garaje[matricula]
    }


}


