package com.moo.frogs.ui

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.moo.frogs.viewmodel.FrogsViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun Home(
    viewModel: FrogsViewModel = hiltViewModel()
) {
    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.1f))

            if (viewModel.state.loading) {
                CircularProgressIndicator(modifier = Modifier.weight(0.8f))
            } else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(viewModel.state.currentImage?.url)
                        .crossfade(true)
                        .build()
                    ,
                    contentDescription = "Frog",
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offsetX,
                            translationY = offsetY,
                        )
                        .pointerInput(Unit) {
                            coroutineScope {
                                detectTransformGestures { _, pan, zoom, _ ->
                                    val newScale = scale * zoom
                                    if (newScale >= 1f) {
                                        scale = newScale
                                        offsetX += pan.x
                                        offsetY += pan.y
                                    }
                                    val bounds = 1000f * (scale - 1)
                                    offsetX = offsetX.coerceIn(-bounds, bounds)
                                    offsetY = offsetY.coerceIn(-bounds, bounds)
                                }
                                detectDragGestures { change, dragAmount ->
                                    launch {
                                        change.consume()
                                        // Reset image when drag ends
                                        if (change.pressed.not()) {
                                            scale = 1f
                                            offsetX = 0f
                                            offsetY = 0f
                                        }
                                    }
                                }
                            }
                        }
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f),
                horizontalArrangement = Arrangement.SpaceAround
                )
             {
                 StarButton(1, viewModel)
                 StarButton(2, viewModel)
                 StarButton(3, viewModel)
                 StarButton(4, viewModel)
                 StarButton(5, viewModel)
            }

            Spacer(modifier = Modifier.weight(0.2f))
        }
    }
}