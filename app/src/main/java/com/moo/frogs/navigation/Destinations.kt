package com.moo.frogs.navigation

sealed class Destinations(val route: String) {
    object Home: Destinations("home")
    object Collection: Destinations("collection")
    data class Detail(val itemId: String): Destinations("detail/$itemId")
}