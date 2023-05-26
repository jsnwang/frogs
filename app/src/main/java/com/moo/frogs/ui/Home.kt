package com.moo.frogs.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun Home(viewModel: FrogsViewModel) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.2f))

            if (viewModel.isLoading.value) {
                CircularProgressIndicator()
            } else {
                val painter = rememberAsyncImagePainter(model = viewModel.currentImage.value)
                Image(
                    painter = painter,
                    contentDescription = "Frog",
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .weight(0.4f)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            IconButton(onClick = { viewModel.getNextImage() }, modifier = Modifier.weight(0.2f)) {
                Icon(Icons.Rounded.ArrowForward, contentDescription = "Next")
            }

            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}