package com.moo.frogs.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun StarButton(rating: Int, viewModel: FrogsViewModel = hiltViewModel()) {
    IconButton(
        onClick = { viewModel.updateRating(viewModel.state.imageId, rating) },
    ) {
        Icon(Icons.Rounded.Star, contentDescription = "Star", modifier = Modifier.size(30.dp))
    }
}