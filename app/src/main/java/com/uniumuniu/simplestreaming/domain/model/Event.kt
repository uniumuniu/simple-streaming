package com.uniumuniu.simplestreaming.domain.model

import java.time.ZonedDateTime

data class Event(
    override val date: ZonedDateTime,
    override val id: String,
    override val imageUrl: String,
    override val subtitle: String,
    override val title: String,
    val videoUrl: String
): IBaseEventData
