package org.hoods.forecastly.geo_location.data.locals.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.hoods.forecastly.geo_location.data.locals.GeoLocationEntity

@Dao
interface GeoLocationDao {
    @Upsert
    @Transaction
    suspend fun updateGeoLocation(geoLocationEntity: GeoLocationEntity)

    @Query("select * from geolocation_table limit 1")
    fun getGeoLocation() : Flow<GeoLocationEntity?>

    @Query("delete from geolocation_table")
    @Transaction
    suspend fun clearGeoLocation()
}