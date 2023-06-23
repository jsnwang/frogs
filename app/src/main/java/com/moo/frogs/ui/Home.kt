package com.moo.frogs.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun Home(viewModel: FrogsViewModel) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.2f))

            if (viewModel.isLoading.value) {
                CircularProgressIndicator()
            } else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(viewModel.currentImage.value)
                        .crossfade(true)
                        .build()
                    ,
                    contentDescription = "Frog",
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .weight(0.4f)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f),
                horizontalArrangement = Arrangement.SpaceEvenly
                )
             {
                IconButton(
                    onClick = { viewModel.getNextImage() },
                ) {
                    Icon(Icons.Rounded.Delete, contentDescription = "Next", modifier = Modifier.size(30.dp))
                }
                IconButton(
                    onClick = { viewModel.getNextImage() },
                ) {
                    Icon(Icons.Rounded.ThumbUp, contentDescription = "Next", modifier = Modifier.size(30.dp))
                }


            }

            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}