package com.uniumuniu.simplestreaming.common

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


fun ZonedDateTime.customFormatDate(): String {
    val todayDate = DateProvider.getNow()
    val yesterdayDate = todayDate.minusDays(1)
    val tomorrowDate = todayDate.plusDays(1)

    val localDateTime = this.toLocalDateTime()
    val localDate = localDateTime.toLocalDate()

    val isToday: Boolean = localDate.equals(todayDate)
    val isYesterday: Boolean = localDate.equals(yesterdayDate)
    val isTomorrow: Boolean = localDate.equals(tomorrowDate)
    return when {
        isToday -> {
            localDateTime.format(DateTimeFormatter.ofPattern("'Today', HH:mm"))
        }
        isYesterday -> {
            localDateTime.format(DateTimeFormatter.ofPattern("'Yesterday', HH:mm"))
        }
        isTomorrow -> {
            localDateTime.format(DateTimeFormatter.ofPattern("'Tomorrow', HH:mm"))
        }
        else -> {
            localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        }
    }
}

fun ZonedDateTime.isTomorrow(): Boolean {
    val tomorrowDate = DateProvider.getNow().plusDays(1)
    val localDate = this.toLocalDate()
    return localDate.equals(tomorrowDate)
}