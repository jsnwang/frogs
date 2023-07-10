package com.moo.frogs.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moo.frogs.model.FrogsRepository
import com.moo.frogs.model.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FrogsViewModel @Inject constructor(private val repository: FrogsRepository): ViewModel() {
    private var images = mutableStateOf<List<Image>>(emptyList())

    var isLoading = mutableStateOf(false)
        private set
    val currentImage = mutableStateOf("")
    var num = 0

    init {
        getImages()
    }

    private fun getImages() = viewModelScope.launch {
        isLoading.value = true
        try {
            val response = repository.getPhotos()
            images.value = images.value.plus(response)
            println("Another one!")
            getNextImage()
        } catch (e: Exception) {
            e.localizedMessage
        } finally {
            isLoading.value = false
        }
    }

    fun getNextImage() {
        num = (0 until images.value.size).random()
        currentImage.value = images.value[num].url
    }
}