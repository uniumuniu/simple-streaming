package com.uniumuniu.simplestreaming.domain.model

data class ScheduleEvent(
    override val date: String,
    override val id: String,
    override val imageUrl: String,
    override val subtitle: String,
    override val title: String
) : IBaseEventData
