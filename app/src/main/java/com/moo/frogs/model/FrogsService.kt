package com.moo.frogs.model

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FrogsService {
    @GET("images")
    suspend fun getPhotos(
    ): List<Image>

    @POST("images/{id}/rating")
    suspend fun updateRating(
        @Path("id") imageId: Int,
        @Body rating: RatingRequest,
    ): RatingResponse
}