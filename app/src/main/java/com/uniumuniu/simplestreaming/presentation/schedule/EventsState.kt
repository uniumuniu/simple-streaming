package com.uniumuniu.simplestreaming.presentation.schedule

import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent

data class ScheduleState(
    val events: List<ScheduleEvent> = listOf(),
    val error: String = ""
)