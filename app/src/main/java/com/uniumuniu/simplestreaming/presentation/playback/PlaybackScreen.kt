package com.uniumuniu.simplestreaming.presentation.playback

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PlaybackScreen(viewModel: PlaybackViewModel = hiltViewModel()) {
    PlaybackScreenStateless(viewModel.state.value ?: "")
}

@Composable
fun PlaybackScreenStateless(
    videoUrl: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = videoUrl)
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PlaybackScreenPreview() {
    PlaybackScreenStateless(videoUrl = "https://test.com")
}