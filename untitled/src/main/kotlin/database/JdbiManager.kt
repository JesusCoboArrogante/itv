package org.example.database

import org.h2.tools.Script
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton
import java.io.File
import javax.sound.midi.SoundbankResource

class JdbiManager(
    private val databaseUrl: String,
    private val databaseInitData:Boolean,
    private val databaseInitTables: Boolean
) {
    val jdbi by lazy { Jdbi.create(databaseUrl)}
    init {
        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(SqlObjectPlugin())

        if (databaseInitTables){
            executeSqlScriptFromResources("tables.sql")
        }
        if (databaseInitData){
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
