package com.moo.frogs.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.gowtham.ratingbar.RatingBar
import com.moo.frogs.R
import com.moo.frogs.model.Image
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun Leaderboard(viewModel: FrogsViewModel = hiltViewModel()) {
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
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                model = image.url,
                contentScale = ContentScale.Crop,
                contentDescription = "Image"
            )
        }
//        Spacer(modifier = Modifier.size(8.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            RatingBar(
                value = image.rating,
                painterEmpty = painterResource(R.drawable.round_star_unfilled_24),
                painterFilled = painterResource(R.drawable.round_star_24),
                onValueChange = { },
                onRatingChanged = { },
            )

            Text(text = "${image.rating}")
        }

    }
}
