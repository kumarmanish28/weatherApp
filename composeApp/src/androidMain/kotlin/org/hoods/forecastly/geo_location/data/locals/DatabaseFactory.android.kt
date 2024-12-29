package org.hoods.forecastly.geo_location.data.locals

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.hoods.forecastly.geo_location.data.locals.GeoLocationDb

actual class DatabaseFactory (
    private val mContext: Context
){
    actual fun create(): RoomDatabase.Builder<GeoLocationDb> {
       val appContext = mContext.applicationContext
        val dbFile = appContext.getDatabasePath(GeoLocationDb.DB_NAME)
        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath)
    }
}