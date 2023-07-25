package com.moo.frogs.util

import com.moo.frogs.model.Image

data class FrogsState(
    val images: List<Image>? = null,
    val currentImage: String? = null,
    val loading: Boolean = false,
    val error: String? = null,
    val imageId: Int = 0,
)
