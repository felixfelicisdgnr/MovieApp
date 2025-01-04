package com.doganur.movieapp.common

sealed interface Resource<out T> {
    data class Success<out T : Any>(val data: T) : Resource<T>
    data class Fail(val message: String) : Resource<Nothing>
}