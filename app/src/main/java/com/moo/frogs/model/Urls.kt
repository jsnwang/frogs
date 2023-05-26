package com.moo.frogs.model

import androidx.annotation.Keep

@Keep
data class Urls(
    val raw: String,
    val full: String,
    val regular: String,
    val small: String,
    val thumb: String,
)