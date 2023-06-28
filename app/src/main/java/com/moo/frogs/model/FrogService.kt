package com.moo.frogs.model

import retrofit2.http.GET

interface FrogService {
    @GET("images")
    suspend fun getPhotos(
    ): List<Image>
}