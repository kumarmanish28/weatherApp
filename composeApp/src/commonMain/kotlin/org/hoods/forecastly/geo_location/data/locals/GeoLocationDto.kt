package org.hoods.forecastly.geo_location.data.locals


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.hoods.forecastly.geo_location.data.remote.models.Result
import org.hoods.forecastly.geo_location.domain.models.GeoLocation
import org.hoods.forecastly.utils.K

@Serializable
data class GeoLocationDto(
    @SerialName("generationtime_ms")
    val generationtimeMs: Double,
    @SerialName("results")
    val results: List<Result>
)

fun GeoLocationDto.toDomain(): List<GeoLocation>{
    return results.map {
        GeoLocation(
            id = it.id,
            name = it.name,
            countryCode = it.countryCode,
            flagUrl = K.flagUrl(it.countryCode),
            countryId = it.countryId,
            latitude = it.latitude,
            longitude = it.longitude,
            timezone = it.timezone,
            elevation = it.elevation.toDouble(),
            country = it.country
        )
    }
}