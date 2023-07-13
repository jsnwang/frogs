package com.moo.frogs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moo.frogs.ui.Collection
import com.moo.frogs.ui.Home

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        composable(Destinations.Home.route) { Home() }
        composable(Destinations.Collection.route) { Collection() }
    }
}