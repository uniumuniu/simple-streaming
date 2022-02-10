package com.uniumuniu.simplestreaming.presentation.schedule

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uniumuniu.simplestreaming.common.Resource
import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent
import com.uniumuniu.simplestreaming.domain.use_case.GetScheduleEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    getScheduleEventsUseCase: GetScheduleEventsUseCase
): ViewModel() {

    private val _state: MutableState<List<ScheduleEvent>> = mutableStateOf(listOf<ScheduleEvent>())
    val state: State<List<ScheduleEvent>> = _state

    init {
        getScheduleEventsUseCase.invoke().onEach { result ->
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