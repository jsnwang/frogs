package com.moo.frogs.model

import retrofit2.http.GET

interface FrogsService {
    @GET("images")
    suspend fun getPhotos(
    ): List<Image>
}