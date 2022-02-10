package com.uniumuniu.simplestreaming.data.remote

import com.uniumuniu.simplestreaming.data.remote.dto.EventDto
import com.uniumuniu.simplestreaming.data.remote.dto.ScheduleEventDto
import retrofit2.http.GET

interface IStreamingServiceApi {
    @GET("/getEvents")
    suspend fun getEvents(): List<EventDto>

    @GET("/getSchedule")
    suspend fun getSchedule(): List<ScheduleEventDto>
}
