package com.uniumuniu.simplestreaming.presentation.playback

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.uniumuniu.simplestreaming.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaybackViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state: PlaybackStateContainer = PlaybackStateContainer()

    init {
        val videoUrl = savedStateHandle.get<String>(Constants.VIDEO_URL_KEY)
        state.videoUrl.value = videoUrl ?: ""
    }

    fun onCreate(exoPlayer: ExoPlayer) {
        exoPlayer.seekTo(state.videoPosition.value)
    }

    fun onStart(exoPlayer: ExoPlayer) {
        exoPlayer.play()
    }

    fun onStop(exoPlayer: ExoPlayer) {
        exoPlayer.pause()
    }

    fun onDestroy(exoPlayer: ExoPlayer) {
        state.videoPosition.value = exoPlayer.currentPosition
    }
}

data class PlaybackStateContainer(
    var videoUrl: MutableState<String> = mutableStateOf(""),
    var videoPosition: MutableState<Long> = mutableStateOf(0),
)