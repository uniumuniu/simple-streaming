package com.uniumuniu.simplestreaming.presentation.playback

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PlaybackScreen(viewModel: PlaybackViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = viewModel.state.value ?: "")
    }
}