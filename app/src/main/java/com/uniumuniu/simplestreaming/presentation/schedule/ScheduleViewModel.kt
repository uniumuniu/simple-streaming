package com.uniumuniu.simplestreaming.presentation.schedule

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uniumuniu.simplestreaming.common.Resource
import com.uniumuniu.simplestreaming.domain.use_case.GetScheduleEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    getScheduleEventsUseCase: GetScheduleEventsUseCase
): ViewModel() {

    private val _state: MutableState<ScheduleState> = mutableStateOf(ScheduleState())
    val state: State<ScheduleState> = _state

    init {
        getScheduleEventsUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.also { _state.value = ScheduleState(it) }
                }
                is Resource.Error -> {
                    result.message?.also { _state.value = ScheduleState(error = it) }
                }
            }
        }.launchIn(viewModelScope)
    }
}