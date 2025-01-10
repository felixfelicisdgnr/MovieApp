package com.doganur.movieapp.common

fun Double?.orZero(): Double = this ?: 0.0
fun Int?.orZero(): Int = this ?: 0

val String.Companion.EMPTY: String get() = ""

fun searchQuery(query: String, word: String) = word.lowercase().contains(query.lowercase()) ||
        query.lowercase().contains(word.lowercase())
