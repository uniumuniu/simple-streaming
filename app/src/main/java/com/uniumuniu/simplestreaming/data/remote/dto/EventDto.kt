package com.uniumuniu.simplestreaming.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.uniumuniu.simplestreaming.common.Constants
import com.uniumuniu.simplestreaming.domain.model.Event
import java.time.ZonedDateTime

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
    @SerializedName(Constants.VIDEO_URL_KEY)
    val videoUrl: String
)

fun EventDto.toEvent(): Event {
    return Event(
        date = ZonedDateTime.parse(date),
        id = id,
        imageUrl = imageUrl,
        subtitle = subtitle,
        title = title,
        videoUrl = videoUrl
    )
}