package org.example.database


import org.example.configuracion.Configuration
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton

import java.io.File

class JdbiManager() {

    companion object{
        val instance: Jdbi by lazy {
            JdbiManager().jdbi
        }
    }

    private val jdbi = Jdbi.create(Configuration.databaseInitData)

    init {
        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(SqlObjectPlugin())

        if (Config.databaseInitTables){
            executeSqlScriptFromResources("tables.sql")
        }
        if (Config.databaseInitData){
            executeSqlScriptFromResources("data.sql")
        }
    }

    fun executeSqlScript(scriptFilePath:String){
        val script = File(scriptFilePath).readText()
        jdbi.useHandle<Exception> {handle -> handle.createScript(script).execute()
        }

    }

    fun executeSqlScriptFromResources(resourcePath: String){
        val inputStream = ClassLoader.getSystemResourceAsStream(resourcePath)?.bufferedReader()!!
        val script = inputStream.readText()
        jdbi.useHandle<Exception> {handle -> handle.createScript(script).execute()
        }
    }



}

@Singleton
fun provideDatabaseManager(
    @Property("database.url") databaseUrl:String = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
    @Property("database.init.data") databaseInitData: String = "false",
    @Property("database.init.tables") databaseInitTables: String = "false"
):Jdbi{
 return JdbiManager(
     databaseUrl,
     databaseInitData.toBoolean(),
     databaseInitTables.toBoolean()
 ).jdbi
}
