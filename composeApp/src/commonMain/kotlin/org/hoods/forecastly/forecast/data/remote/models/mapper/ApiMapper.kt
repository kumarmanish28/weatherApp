package org.hoods.forecastly.forecast.data.remote.models.mapper

interface ApiMapper<Domain, Model> {
    fun mapToDomain(model: Model, timeZone: String = ""): Domain
}