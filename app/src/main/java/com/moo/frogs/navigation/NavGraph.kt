package com.moo.frogs.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moo.frogs.ui.Leaderboard
import com.moo.frogs.ui.Home
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun NavGraph(navController: NavHostController){
    val viewModel: FrogsViewModel = hiltViewModel()
    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        composable(Destinations.Home.route) { Home(viewModel = viewModel) }
        composable(Destinations.Collection.route) { Leaderboard(viewModel = viewModel) }
    }
}