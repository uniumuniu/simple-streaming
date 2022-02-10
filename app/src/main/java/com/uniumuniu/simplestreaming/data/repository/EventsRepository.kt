package com.uniumuniu.simplestreaming.data.repository

import com.uniumuniu.simplestreaming.data.remote.IStreamingServiceApi
import com.uniumuniu.simplestreaming.data.remote.dto.toEvent
import com.uniumuniu.simplestreaming.data.remote.dto.toScheduleEvent
import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent
import com.uniumuniu.simplestreaming.domain.repository.IEventsRepository

class EventsRepository(private val api: IStreamingServiceApi): IEventsRepository {
    override suspend fun getEvents(): List<Event> {
        return api.getEvents().map { it.toEvent() }
    }

    override suspend fun getScheduleEvents(): List<ScheduleEvent> {
        return api.getSchedule().map { it.toScheduleEvent() }
    }
}