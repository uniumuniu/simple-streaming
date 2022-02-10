package com.uniumuniu.simplestreaming.domain.model

data class Event(
    override val date: String,
    override val id: String,
    override val imageUrl: String,
    override val subtitle: String,
    override val title: String,
    val videoUrl: String
): IBaseEventData

interface IBaseEventData {
    val date: String
    val id: String
    val imageUrl: String
    val subtitle: String
    val title: String
}
