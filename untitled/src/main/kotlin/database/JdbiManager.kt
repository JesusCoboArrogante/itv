package org.example.database


import org.example.configuracion.Configuration
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import java.io.File

class JdbiManager private constructor() {



    private val jdbi = Jdbi.create(Configuration.dataBaseUrl)

    companion object{
        val instance: Jdbi by lazy {
            JdbiManager().jdbi
        }
    }

    init {
        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(SqlObjectPlugin())

        if (Configuration.databaseInitTables){
            executeSqlScriptFromResources("tables.sql")
        }
        if (Configuration.databaseInitData){
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

