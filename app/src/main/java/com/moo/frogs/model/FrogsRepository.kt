package com.moo.frogs.model

import javax.inject.Inject

class FrogsRepository @Inject constructor(private val service: FrogsService) {

    suspend fun getPhotos(): List<Image> {
        return service.getPhotos()
    }
}