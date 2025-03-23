package org.example.repository

interface CrudRepository<MATRICULA,T> {
    fun save (entity:T):T
    fun delete(matricula: MATRICULA):T?
    fun update(matricula: MATRICULA, entity: T): T?
    fun getAll(): List<T>
    fun getById(matricula: MATRICULA, entity: T): T?
}