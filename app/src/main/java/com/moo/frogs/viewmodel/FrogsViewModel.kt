package com.moo.frogs.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moo.frogs.model.FrogsRepository
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
            }

            is Resource.Error -> {
                state = state.copy(images = null, loading = false, error = response.message)
            }
        }
    }

    fun getNextImage() {
        num = (0 until state.images?.size!!).random()
        state = state.copy(currentImage = state.images!![num].url, imageId = state.images!![num].id)
    }

    fun updateRating(id: Int, rating: Int) {
        viewModelScope.launch {
            state = state.copy(
                error = null
            )
            repository.updateRating(
                id,
                rating,
            )
        }
        getNextImage()
    }
}