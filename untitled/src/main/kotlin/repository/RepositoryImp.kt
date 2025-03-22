package org.example.repository

import sun.util.logging.resources.logging

class RepositoryImp:CrudRepository<Int, Coche> {
    private val  logger = logging()
    private val garaje = mutableMapOf<Int, Coche>()
    private var nextId = 1

    private fun generateId():Int{
        return  nextId++
    }

    override fun save(entity: T): Coche {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Coche? {

        return  garaje.remove[id]
    }

    override fun update(id: Int, entity: T): Coche? {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Coche> {
        return garaje.value.toList()
    }

    override fun getById(id: Int, entity:T): Coche? {
        return garaje[id]
    }


}


