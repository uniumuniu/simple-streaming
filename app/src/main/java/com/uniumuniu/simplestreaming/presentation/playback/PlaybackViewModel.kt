package com.uniumuniu.simplestreaming.presentation.playback

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.uniumuniu.simplestreaming.common.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaybackViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    val state: State<String?>

    init {
        val videoUrl = savedStateHandle.get<String>(Constants.VIDEO_URL_KEY)
        state = mutableStateOf(videoUrl)
    }
}
