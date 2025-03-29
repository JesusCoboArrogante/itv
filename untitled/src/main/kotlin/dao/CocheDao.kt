package org.example.dao

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.kotlin.RegisterKotlinMapper
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

@RegisterKotlinMapper(CocheEntity::class)
interface CocheDao {


    @SqlQuery ("SELECT * FROM Coche")
    fun findAll(): List<CocheEntity>

    @SqlQuery ("SELECT * FROM Coche WHERE matricula = :matricula")
    fun findById(@Bind("matricula") matricula: String):CocheEntity?

    @SqlUpdate("INSERT INTO Coche (matricula, marca, modelo, fechaMatriculacion " +
            "VALUES (:matricula, :marca, :modela, :fechaMatriculacion))")
    @GetGeneratedKeys("matricula")
    fun save(@BindBean Coche: CocheEntity): Int

    @SqlUpdate("UPDATE Coche SET matricula =:matricula, marca=:marcha, modelo=:modelo, fechaMatriculacion=:fechaMatriculacion")
    fun update(@BindBean Coche:CocheEntity):Int

    @SqlUpdate ("DELETE FROM Coche WHERE matricula = :matricula")
    fun delete(@Bind("matricula") matricula: String)

}

fun provideCocheDao(jdbi: Jdbi): CocheDao{
    return jdbi.onDemand(CocheDao::class.java)
}