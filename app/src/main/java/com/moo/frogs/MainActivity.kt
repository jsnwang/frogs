package com.moo.frogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.moo.frogs.ui.theme.FrogsTheme
import com.moo.frogs.viewmodel.FrogsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: FrogsViewModel by viewModels()
        setContent {
            FrogsTheme {
                Frogs(viewModel)
            }
        }
    }
}
