package org.hoods.forecastly.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.hoods.forecastly.common.data.HttpClientFactory
import org.hoods.forecastly.common.data.Mapper
import org.hoods.forecastly.forecast.data.remote.ForecastRemoteApiService
import org.hoods.forecastly.forecast.data.remote.ForecastRemoteApiServiceImpl
import org.hoods.forecastly.forecast.data.remote.models.CurrentDto
import org.hoods.forecastly.forecast.data.remote.models.DailyDto
import org.hoods.forecastly.forecast.data.remote.models.HourlyDto
import org.hoods.forecastly.forecast.data.remote.models.WeatherDto
import org.hoods.forecastly.forecast.data.remote.models.mapper.ApiMapper
import org.hoods.forecastly.forecast.data.remote.models.mapper.ApiWeatherMapper
import org.hoods.forecastly.forecast.data.remote.models.mapper.ApiDailyWeatherMapper
import org.hoods.forecastly.forecast.data.remote.models.mapper.ApiHourlyMapper
import org.hoods.forecastly.forecast.data.remote.models.mapper.CurrentWeatherMapper
import org.hoods.forecastly.forecast.domain.models.CurrentWeather
import org.hoods.forecastly.forecast.domain.models.Daily
import org.hoods.forecastly.forecast.domain.models.Hourly
import org.hoods.forecastly.forecast.domain.models.Weather
import org.hoods.forecastly.forecast.domain.repository.ForecastRepository
import org.hoods.forecastly.forecast.data.repository.ForecastRepositoryImpl
import org.hoods.forecastly.geo_location.data.locals.DatabaseFactory
import org.hoods.forecastly.geo_location.data.locals.GeoLocationDb
import org.hoods.forecastly.geo_location.data.locals.GeoLocationEntity
import org.hoods.forecastly.geo_location.data.remote.GeoLocationRemoteApiService
import org.hoods.forecastly.geo_location.data.remote.models.GeoLocationRemoteApiServiceImpl
import org.hoods.forecastly.geo_location.domain.models.GeoLocation
import org.hoods.forecastly.geo_location.data.mapper.GeoLocationMapper
import org.hoods.forecastly.geo_location.data.repository.GeoLocationRepositoryImpl
import org.hoods.forecastly.utils.provideExternalCoroutineScope
import org.hoods.forecastly.geo_location.domain.repository.GeoLocationRepository
import org.hoods.forecastly.ui.home.HomeViewModel
import org.hoods.forecastly.ui.forecast.ForecastViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platFormModule: Module

val sharedModule = module {
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<GeoLocationDb>().getGeoLocationDao() }
    single { HttpClientFactory.create(get()) }
    single { provideExternalCoroutineScope() }.bind()
    singleOf(::GeoLocationRemoteApiServiceImpl).bind<GeoLocationRemoteApiService>()
    singleOf(::GeoLocationRepositoryImpl).bind<GeoLocationRepository>()
    singleOf(::GeoLocationMapper).bind<Mapper<GeoLocation, GeoLocationEntity>>()

    singleOf(::ForecastRemoteApiServiceImpl).bind<ForecastRemoteApiService>()
    singleOf(::ApiWeatherMapper).bind<ApiMapper<Weather, WeatherDto>>()
    singleOf(::ApiDailyWeatherMapper).bind<ApiMapper<Daily, DailyDto>>()
    singleOf(::ApiHourlyMapper).bind<ApiMapper<Hourly, HourlyDto>>()
    singleOf(::CurrentWeatherMapper).bind<ApiMapper<CurrentWeather, CurrentDto>>()
    singleOf(::ForecastRepositoryImpl).bind<ForecastRepository>()

    viewModelOf(::HomeViewModel)
    viewModelOf(::ForecastViewModel)
}
