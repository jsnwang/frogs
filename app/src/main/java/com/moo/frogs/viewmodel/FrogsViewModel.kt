package com.moo.frogs.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moo.frogs.model.FrogsRepository
import com.moo.frogs.model.Image
import com.moo.frogs.util.FrogsState
import com.moo.frogs.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FrogsViewModel @Inject constructor(private val repository: FrogsRepository) : ViewModel() {

    var state by mutableStateOf(FrogsState())
        private set

    private var num = 0

    lateinit var sortedImages: List<Image>
    init {
        getImages()
    }

    private fun getImages() = viewModelScope.launch {
        state = state.copy(
            loading = true,
            error = null
        )

        when (val response = repository.getPhotos()) {
            is Resource.Success -> {
                state = state.copy(images = response.data, loading = false, error = null)
                getNextImage()
                sortedImages = state.images!!.sortedByDescending { it.rating }
            }

            is Resource.Error -> {
                state = state.copy(images = null, loading = false, error = response.message)
            }
        }
    }

    private fun getNextImage() {
        val currentImageId = state.imageId
        val availableImages = state.images?.filter { it.id != currentImageId }

        if (availableImages.isNullOrEmpty()) {
            // Handle the case when all images have been rated
            state = state.copy(currentImage = null, imageId = 0)
        } else {
            num = (availableImages.indices).random()
            state = state.copy(
                currentImage = availableImages[num].url,
                imageId = availableImages[num].id,
            )
        }
        println("${state.imageId} ${state.currentImage}")
    }

    fun updateRating(id: Int, rating: Int) {
        viewModelScope.launch {
            state = state.copy(
                error = null,
            )
            when (val response = repository.updateRating(
                id,
                rating,
            )) {
                is Resource.Success -> {
                    state = state.copy(loading = false, error = null)
                }

                is Resource.Error -> {
                    state = state.copy(loading = false, error = response.message)
                }
            }

            getNextImage()
        }
    }
}