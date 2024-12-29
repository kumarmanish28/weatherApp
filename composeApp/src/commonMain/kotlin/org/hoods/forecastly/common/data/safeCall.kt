package org.hoods.forecastly.common.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ResponseException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException
import org.hoods.forecastly.utils.Response


inline fun <reified D, reified E> HttpClient.safeRequest(
    crossinline block: HttpRequestBuilder.() -> Unit,
): Flow<Response<D, E>> = flow {
    emit(Response.Loading)
    val response = request { block() }
    emit(Response.Success(response.body<D>()))
}.catch { e->
    e.printStackTrace()
}

suspend inline fun <reified E> ResponseException.errorBody(): E? =
    try {
        response.body()
    } catch (e: SerializationException) {
        null
    }