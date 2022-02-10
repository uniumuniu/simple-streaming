package com.uniumuniu.simplestreaming.presentation.events

import com.uniumuniu.simplestreaming.domain.model.Event

data class EventsState(
    val events: List<Event> = listOf(),
    val error: String = ""
)