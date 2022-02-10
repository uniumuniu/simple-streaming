package com.uniumuniu.simplestreaming.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.uniumuniu.simplestreaming.ui.theme.SimpleStreamingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleStreamingTheme {
                MainScreen()
            }
        }
    }
}