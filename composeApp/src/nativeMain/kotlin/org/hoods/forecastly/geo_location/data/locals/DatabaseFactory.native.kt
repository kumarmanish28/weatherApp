package org.hoods.forecastly.geo_location.data.locals

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import org.hoods.forecastly.geo_location.data.locals.GeoLocationDb
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<GeoLocationDb> {
        val dbFile = documentDirectory() + "/${GeoLocationDb.DB_NAME}"
        return Room.databaseBuilder<GeoLocationDb>(
            name = dbFile
        )
    }


    @OptIn(ExperimentalForeignApi::class)
    private fun documentDirectory() : String{
        val documentDir = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return requireNotNull(documentDir?.path)
    }
}