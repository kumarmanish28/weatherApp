package org.hoods.forecastly.forecast.data.remote.models.mapper

import org.hoods.forecastly.forecast.data.remote.models.HourlyDto
import org.hoods.forecastly.forecast.domain.models.Hourly
import org.hoods.forecastly.utils.Util
import org.hoods.forecastly.utils.WeatherInfoItem

class ApiHourlyMapper : ApiMapper<Hourly, HourlyDto> {
    override fun mapToDomain(model: HourlyDto, timeZone: String): Hourly {
        return Hourly(
            temperature = model.temperature2m,
            time = parseTime(model.time, timeZone),
            weatherStatus = parseWeatherStatus(model.weatherCode)
        )
    }

    private fun parseTime(time: List<Long>, timeZone: String): List<String> {
        return time.map { Util.formatUnixToHour(it, timeZone) }
    }

    private fun parseWeatherStatus(code: List<Int>): List<WeatherInfoItem> {
        return code.map {
            Util.getWeatherInfo(it)
        }
    }
}