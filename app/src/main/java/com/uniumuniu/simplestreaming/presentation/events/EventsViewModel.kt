package com.uniumuniu.simplestreaming.presentation.events

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uniumuniu.simplestreaming.common.Resource
import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.domain.use_case.GetEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    getEventsUseCase: GetEventsUseCase
): ViewModel() {

    private val _state: MutableState<List<Event>> = mutableStateOf(listOf<Event>())
    val state: State<List<Event>> = _state

    init {
        getEventsUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.also { _state.value = it }
                }
                is Resource.Error -> {

                }
            }
        }.launchIn(viewModelScope)
    }
}