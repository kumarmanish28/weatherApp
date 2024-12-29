package org.hoods.forecastly.forecast.data.remote

import kotlinx.coroutines.flow.Flow
import org.hoods.forecastly.forecast.data.remote.models.WeatherDto
import org.hoods.forecastly.utils.ApiErrorResponse
import org.hoods.forecastly.utils.Response

interface ForecastRemoteApiService {
    fun fetchForecast(
        latitude: Float = -6.23f, // Latitude for New Delhi, India
        longitude: Float = 39.28f, // Longitude for New Delhi, India
        daily: Array<String> = arrayOf(
            "weather_code",
            "temperature_2m_max",
            "temperature_2m_min",
            "wind_speed_10m_max",
            "wind_direction_10m_dominant",
            "sunrise",
            "sunset",
            "uv_index_max"
        ),
        currentWeather: Array<String> = arrayOf(
            "temperature_2m",
            "is_day",
            "weather_code",
            "wind_speed_10m",
            "wind_direction_10m"
        ),
        hourlyWeather: Array<String> = arrayOf(
            "temperature_2m", "weather_code"
        ),
        timeformat: String = "unixtime", // Use ISO 8601 format
        timeZone: String = "Africa/Dar_es_Salaam" // Indian Standard Time (IST)
    ): Flow<Response<WeatherDto, ApiErrorResponse>>
}
