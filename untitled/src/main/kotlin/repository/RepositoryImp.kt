package org.example.repository

import org.example.dao.CocheDao
import org.example.mapper.toEntity
import org.example.mapper.toModel
import org.example.models.Coche
import sun.util.logging.resources.logging

typealias CocheEntity =Map<String,Any>
class RepositoryImp(
    private val dao:CocheDao
):CrudRepository<String, Coche> {

    override fun save(entity: Coche): Coche {
        dao.save(entity.toEntity())
        return entity

    }

    override fun delete(matricula:String): Coche? {
        val coche: Coche? = getById(matricula)
        if (coche != null){
            dao.delete(matricula)
        }
        return coche
    }

    override fun update(matricula: String, entity: Coche): Coche? {
        var coche : Coche? = this.getById(matricula)
        if (coche != null){
            val result = dao.update(entity.toEntity())
            if (result > 0){
                coche = entity
            }
        }
        return coche
    }

    override fun getAll(): List<Coche> {
        return dao.findAll().map{it.toModel()}
    }

    override fun getById(matricula: String): Coche? {
        return dao.findById(matricula)?.toModel()
    }


}


