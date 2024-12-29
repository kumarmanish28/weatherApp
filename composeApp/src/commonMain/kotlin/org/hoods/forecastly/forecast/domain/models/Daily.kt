package org.hoods.forecastly.forecast.domain.models

import org.hoods.forecastly.utils.WeatherInfoItem


data class Daily(
    private val temperatureMax: List<Double>,
    private val temperatureMin: List<Double>,
    private val time: List<String>,
    private val weatherStatus: List<WeatherInfoItem>,
    private val windDirection: List<String>,
    private val windSpeed: List<Double>,
    private val sunrise: List<String>,
    private val sunset: List<String>,
    private val uvIndexMax: List<Double>
) {
    val weatherInfo: List<WeatherInfo>
        get() {
            val dailyWeatherInfo = mutableListOf<WeatherInfo>()
            for (i in temperatureMin.indices) {
                dailyWeatherInfo.add(
                    WeatherInfo(
                        temperatureMax = temperatureMax[i],
                        temperatureMin = temperatureMin[i],
                        time = time[i],
                        weatherStatus = weatherStatus[i],
                        windDirection = windDirection[i],
                        windSpeed = windSpeed[i],
                        sunrise = sunrise[i],
                        sunset = sunset[i],
                        uvIndexMax = uvIndexMax[i],
                    )
                )
            }
            return dailyWeatherInfo
        }

    data class WeatherInfo(
        val temperatureMax: Double,
        val temperatureMin: Double,
        val time: String,
        val weatherStatus: WeatherInfoItem,
        val windDirection: String,
        val windSpeed: Double,
        val sunrise: String,
        val sunset: String,
        val uvIndexMax: Double
    )
}

