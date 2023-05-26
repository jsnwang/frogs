package com.moo.frogs.model

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface UnsplashService {
    @GET("photos/random")
    suspend fun getPhotos(
        @Query("query") query: String = "frog",
        @Query("count") count: Int = 30,
        @Header("Authorization") authHeader: String,
    ): List<Photo>
}