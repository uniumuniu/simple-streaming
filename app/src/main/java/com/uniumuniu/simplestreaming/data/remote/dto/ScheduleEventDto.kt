package com.uniumuniu.simplestreaming.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent

data class ScheduleEventDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)

fun ScheduleEventDto.toScheduleEvent(): ScheduleEvent {
    return ScheduleEvent(
        date = date,
        id = id,
        imageUrl = imageUrl,
        subtitle = subtitle,
        title = title
    )
}