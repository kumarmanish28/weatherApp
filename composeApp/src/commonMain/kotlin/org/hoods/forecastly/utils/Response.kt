package org.hoods.forecastly.utils

import coil3.map.Mapper

sealed class Response<out D, out E> {
    data class Success<out D>(val data: D): Response<D, Nothing>()
    sealed class Error<E> : Response<Nothing, E>(){
        /*
        * Represents server (50x) and client (40x) errors
        */
        data class HttpError<E>(val code: Int, val errorBody: E?) : Error<E>()

        /*
        * Represent IOException and connectivity issues
        * */
        data object NetworkError : Error<Nothing>()

        /*
        * Represent SerializationException
        * */
        data object SerializationError : Error<Nothing>()

        data object DefaultError: Error<Nothing>()
    }
    data object Loading: Response<Nothing, Nothing>()
}

inline fun <D, E, R> Response<D, E>.map(mapper: (D) -> R): Response<R, E> = when(this){
    is Response.Success -> Response.Success(mapper(data))
    is Response.Error -> this // propagate error as it is
    is Response.Loading -> this // propagate loading as it is
}