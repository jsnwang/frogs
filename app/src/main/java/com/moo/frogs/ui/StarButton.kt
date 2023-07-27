package com.moo.frogs.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moo.frogs.R
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun StarButton(rating: Int, viewModel: FrogsViewModel) {
    IconButton(
        onClick = {
            viewModel.updateRating(viewModel.state.currentImage?.id!!, rating)
        },
    ) {
        Icon(painter = painterResource(id = R.drawable.round_star_24), contentDescription = "Star", modifier = Modifier.size(30.dp))
    }
}