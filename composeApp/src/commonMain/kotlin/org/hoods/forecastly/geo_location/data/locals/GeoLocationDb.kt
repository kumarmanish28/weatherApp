package org.hoods.forecastly.geo_location.data.locals

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import org.hoods.forecastly.geo_location.data.locals.dao.GeoLocationDao


@Database(entities = [GeoLocationEntity::class], version = 1)
@ConstructedBy(GeoLocationConstructor::class)
abstract class GeoLocationDb : RoomDatabase(){
    companion object{
        val DB_NAME = "geo_location.db"
    }
    abstract fun getGeoLocationDao() : GeoLocationDao
}