package com.uniumuniu.simplestreaming.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.uniumuniu.simplestreaming.domain.model.Event

data class EventDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("videoUrl")
    val videoUrl: String
)

fun EventDto.toEvent(): Event {
    return Event(
        date = date,
        id = id,
        imageUrl = imageUrl,
        subtitle = subtitle,
        title = title,
        videoUrl = videoUrl
    )
}