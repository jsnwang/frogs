package com.moo.frogs.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class FrogsViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FrogsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FrogsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}