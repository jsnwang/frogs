package com.moo.frogs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.moo.frogs.navigation.NavGraph
import com.moo.frogs.ui.components.Scaffold

@Composable
fun Frogs() {
    val navController = rememberNavController()
    Scaffold(navController) {
        NavGraph(navController)
    }
}