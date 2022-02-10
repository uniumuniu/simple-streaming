package com.uniumuniu.simplestreaming.common

import io.mockk.every
import io.mockk.mockkObject
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime


class ZonedDateTimeExtensionsKtTest {

    private val defaultDate = LocalDate.of(2022, 10,1)

    @Test
    fun formatTodayDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val dateTime = ZonedDateTime.of(2022, 10, 1, 14, 30, 0, 0, ZoneId.systemDefault())
        val formatted = dateTime.customFormatDate()
        assertEquals("Today, 14:30", formatted)
    }

    @Test
    fun formatYesterdayDate() {
        fail()
    }

    @Test
    fun formatTomorrowDate() {
        fail()
    }

    @Test
    fun checkIfItsTomorrowDate() {
        fail()
    }
}