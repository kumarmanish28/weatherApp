package org.hoods.forecastly.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.hoods.forecastly.geo_location.data.locals.DatabaseFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platFormModule: Module
    get() = module {
        single<HttpClientEngine> { Darwin.create() }
        single { DatabaseFactory() }
    }