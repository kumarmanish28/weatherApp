package org.hoods.forecastly.geo_location.data.locals

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "geolocation_table")
data class GeoLocationEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
    val name: String,
    val country: String,
    val countryCode: String,
    val countryId: Int,
    val latitude: Double,
    val longitude: Double,
    val elevation: Double,
    val timezone: String
)
