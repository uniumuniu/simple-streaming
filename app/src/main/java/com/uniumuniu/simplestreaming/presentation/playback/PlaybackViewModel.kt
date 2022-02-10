package com.uniumuniu.simplestreaming.presentation.playback

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlaybackViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    val state: State<String?>

    init {
        val videoUrl = savedStateHandle.get<String>("videoUrl")
        state = mutableStateOf(videoUrl)
    }
}
