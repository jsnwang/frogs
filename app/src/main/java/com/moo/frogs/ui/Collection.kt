package com.moo.frogs.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.moo.frogs.model.Image
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun Collection(viewModel: FrogsViewModel = hiltViewModel()) {
    LazyColumn {
        items(viewModel.sortedImages) { image ->
            LeaderboardItem(image = image)
            Divider()
        }
    }
}

@Composable
fun LeaderboardItem(image: Image) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start,
        ) {
        AsyncImage(modifier = Modifier
            .size(100.dp)
            .weight(3f),
            model = image.url,
            contentDescription = "Image")
        Text(modifier = Modifier.weight(1f),
            text = image.rating.toString())
    }
}