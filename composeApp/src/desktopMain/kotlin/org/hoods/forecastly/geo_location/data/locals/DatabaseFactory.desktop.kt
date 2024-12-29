package org.hoods.forecastly.geo_location.data.locals

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<GeoLocationDb> {

        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home").lowercase()

        val appDataDir = when {
           os.contains("win") -> File(System.getenv("APPDATA"), "forecastly")
           os.contains("mac") -> File(userHome, "Library/Application Supprot/forecastly")
            else -> File(userHome, ".local/share/forecastly")
        }

        if(!appDataDir.exists()){
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, GeoLocationDb.DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}