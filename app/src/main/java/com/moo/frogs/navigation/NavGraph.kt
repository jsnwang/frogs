package com.moo.frogs.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moo.frogs.ui.Collection
import com.moo.frogs.ui.Home
import com.moo.frogs.viewmodel.FrogsViewModel
import com.moo.frogs.viewmodel.FrogsViewModelFactory

@Composable
fun NavGraph(navController: NavHostController){
    val viewModel: FrogsViewModel = viewModel(factory = FrogsViewModelFactory())

    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        composable(Destinations.Home.route) { Home(viewModel = viewModel) }
        composable(Destinations.Collection.route) { Collection() }
    }
}