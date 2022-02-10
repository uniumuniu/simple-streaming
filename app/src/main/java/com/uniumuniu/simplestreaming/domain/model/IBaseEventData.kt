package com.uniumuniu.simplestreaming.domain.model

import java.time.ZonedDateTime

interface IBaseEventData {
    val date: ZonedDateTime
    val id: String
    val imageUrl: String
    val subtitle: String
    val title: String
}