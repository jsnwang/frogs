package com.moo.frogs.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.moo.frogs.navigation.Destinations

@Composable
fun BottomAppBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Collection")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    when (index) {
                        0 -> Icon(Icons.Rounded.Home, contentDescription = item)
                        1 -> Icon(Icons.Rounded.Favorite, contentDescription = item)
                    }
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    when (index) {
                        0 -> if (navController.currentDestination?.route != Destinations.Home.route) navController.navigate(
                            Destinations.Home.route
                        )

                        1 -> if (navController.currentDestination?.route != Destinations.Collection.route) navController.navigate(
                            Destinations.Collection.route
                        )
                    }
                }
            )
        }
    }
}