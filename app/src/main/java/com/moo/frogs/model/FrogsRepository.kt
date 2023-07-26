package com.moo.frogs.model

import com.moo.frogs.util.Resource
import javax.inject.Inject

class FrogsRepository @Inject constructor(private val service: FrogsService) {
    suspend fun getPhotos(): Resource<List<Image>> {
        return try {
            Resource.Success(
                data = service.getPhotos()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error has occurred.")
        }
    }

    suspend fun updateRating(id: Int, rating: Int): Resource<RatingResponse> {
        return try {
            Resource.Success(
                data = service.updateRating(id, RatingRequest(rating))
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error has occurred.")
        }
    }
}