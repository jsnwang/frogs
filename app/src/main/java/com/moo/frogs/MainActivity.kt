package com.moo.frogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.moo.frogs.ui.theme.FrogsTheme
import com.moo.frogs.viewmodel.FrogsViewModel
import com.moo.frogs.viewmodel.FrogsViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModelFactory = FrogsViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory)[FrogsViewModel::class.java]
        setContent {
            FrogsTheme {
                Frogs()
            }
        }
    }
}
