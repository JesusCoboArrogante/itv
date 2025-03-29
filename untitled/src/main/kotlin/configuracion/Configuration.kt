package org.example.configuracion


import sun.util.logging.resources.logging
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.io.path.pathString


    object Configuration {

        var dataBaseUrl: String = "jdbi:h2:mam:coche"
            private set
        var databaseInitTables: Boolean = false
            private set
        var databaseInitData:Boolean = false
            private set
        var storageData: String = "data"
            private set

        var locale: String = Locale.getDefault().language

        init {
            try{
                val properties = Properties()
                properties.load(ClassLoader.getSystemResourceAsStream("config.properties"))
                dataBaseUrl = properties.getProperty("database.url", this.dataBaseUrl)
                databaseInitTables =
                    properties.getProperty("database.init.tables", this.databaseInitTables.toString()).toBoolean()
                databaseInitData =
                    properties.getProperty("database.init.data", this.databaseInitData.toString()).toBoolean()
                storageData = properties.getProperty("storage.data", this.storageData)
                locale = properties.getProperty("locale", this.locale)

            }catch (e:Exception){
                println("Error cargando configuracion: ${e.message}")
                println("usando valores por defecto")

            }
        }

}