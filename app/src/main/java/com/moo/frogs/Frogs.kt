package com.moo.frogs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.moo.frogs.navigation.NavGraph
import com.moo.frogs.ui.components.Scaffold
import com.moo.frogs.viewmodel.FrogsViewModel

@Composable
fun Frogs(viewModel: FrogsViewModel) {
    val navController = rememberNavController()
    Scaffold(navController) {
        NavGraph(viewModel , navController)
    }
}