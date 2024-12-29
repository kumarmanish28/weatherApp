package org.hoods.forecastly.forecast.domain.repository

import kotlinx.coroutines.flow.StateFlow
import org.hoods.forecastly.forecast.domain.models.Weather
import org.hoods.forecastly.utils.ApiErrorResponse
import org.hoods.forecastly.utils.Response

interface ForecastRepository {
    val weatherData: StateFlow<Response<Weather, ApiErrorResponse>?>

    fun fetchWeatherData(
        latitude: Float,
        longitude: Float,
        timezone: String
    )
}