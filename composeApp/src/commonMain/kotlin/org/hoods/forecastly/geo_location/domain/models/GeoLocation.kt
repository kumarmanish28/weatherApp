package org.hoods.forecastly.geo_location.domain.models

import org.hoods.forecastly.utils.FlagUrl

data class GeoLocation(
    val id: Int = 1,
    val name: String,
    val country: String,
    val countryCode: String,
    val flagUrl: FlagUrl,
    val countryId: Int,
    val latitude: Double,
    val longitude: Double,
    val elevation: Double,
    val timezone: String
)
