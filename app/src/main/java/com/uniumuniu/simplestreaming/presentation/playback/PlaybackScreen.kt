package com.uniumuniu.simplestreaming.presentation.playback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun PlaybackScreen(viewModel: PlaybackViewModel = hiltViewModel()) {
    PlaybackScreenStateless(viewModel.state.value ?: "")
}

@Composable
fun PlaybackScreenStateless(
    videoUrl: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        val exoPlayer = remember {
            ExoPlayer.Builder(context).build().apply {
                this.setMediaItem(MediaItem.fromUri(videoUrl))
                this.prepare()
                this.playWhenReady
            }
        }

        val lifecycle = LocalLifecycleOwner.current.lifecycle
        DisposableEffect(
            exoPlayer
        ) {
            val lifecycleObserver = LifecycleEventObserver { _, event ->
                when (event) {
                    Lifecycle.Event.ON_START -> exoPlayer.play()
                    Lifecycle.Event.ON_STOP -> exoPlayer.pause()
                }
            }

            lifecycle.addObserver(lifecycleObserver)
            onDispose {
                lifecycle.removeObserver(lifecycleObserver)
                exoPlayer.release()
            }
        }

        AndroidView(factory = {
            PlayerView(context).apply {
                this.player = exoPlayer
            }
        })
    }
}
