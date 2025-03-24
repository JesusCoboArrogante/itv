package org.example.configuracion

import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import kotlin.io.path.pathString

class Configuration {
    object Configuration {

        val configurationProperties: ConfigurationProperties = loadConfig()

        private fun loadConfig(): ConfigurationProperties {


            val propiedades = Properties()

            val cadenaPropiedades = this::class.java.getResourceAsStream("/config.properties")
                ?: throw RuntimeException("No se ha encontrado el fichero de configuración")

            propiedades.load(cadenaPropiedades)


            val directorioActual = System.getProperty("user.dir")

            var directorioDataProperties: String? = propiedades.getProperty("data.directory")
            if (directorioDataProperties.isNullOrEmpty()) {
                directorioDataProperties = "data"
            }

            var directorioBackupProperties: String? = propiedades.getProperty("backup.directory")
            if (directorioBackupProperties.isNullOrEmpty()) {
                directorioBackupProperties = "backup"
            }


            val directorioData = Path.of(directorioActual, directorioDataProperties).pathString
            val directorioBackup = Path.of(directorioActual, directorioBackupProperties).pathString

            crearDirectorios(directorioData, directorioBackup)

            return ConfigurationProperties(directorioData, directorioBackup)


        }

        private fun crearDirectorios(vararg directorios: String) {
            directorios.forEach {
                val dir = java.io.File(it)
                Files.createDirectories(dir.toPath())
            }
        }
    }
}