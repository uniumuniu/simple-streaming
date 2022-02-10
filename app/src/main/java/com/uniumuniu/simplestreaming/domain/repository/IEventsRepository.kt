package com.uniumuniu.simplestreaming.domain.repository

import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent

interface IEventsRepository {
    suspend fun getEvents(): List<Event>

    suspend fun getScheduleEvents(): List<ScheduleEvent>
}