package com.uniumuniu.simplestreaming.common

import io.mockk.every
import io.mockk.mockkObject
import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime


class ZonedDateTimeExtensionsKtTest {

    private val defaultDate = LocalDate.of(2022, 2,9)

    @Test
    fun customFormatTodayDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val date = ZonedDateTime.of(2022, 2, 9, 14, 30, 0, 0, ZoneId.systemDefault())
        val formatted = date.customFormatDate()
        assertEquals("Today, 14:30", formatted)
    }

    @Test
    fun customFormatYesterdayDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val date = ZonedDateTime.of(2022, 2, 8, 15, 40, 0, 0, ZoneId.systemDefault())
        val formatted = date.customFormatDate()
        assertEquals("Yesterday, 15:40", formatted)
    }

    @Test
    fun customFormatTomorrowDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val date = ZonedDateTime.of(2022, 2, 10, 16, 50, 0, 0, ZoneId.systemDefault())
        val formatted = date.customFormatDate()
        assertEquals("Tomorrow, 16:50", formatted)
    }

    @Test
    fun customFormatFutureDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val date = ZonedDateTime.of(2022, 2, 14, 16, 50, 0, 0, ZoneId.systemDefault())
        val formatted = date.customFormatDate()
        assertEquals("14.02.2022", formatted)
    }

    @Test
    fun isTomorrowReturnsFalseForTodayDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val date = ZonedDateTime.of(2022, 2, 9, 11, 5, 0, 0, ZoneId.systemDefault())
        val isTomorrow = date.isTomorrow()
        assertFalse(isTomorrow)
    }

    @Test
    fun isTomorrowReturnsTrueForTomorrowDate() {
        mockkObject(DateProvider)
        every { DateProvider.getNow() } returns defaultDate
        val date = ZonedDateTime.of(2022, 2, 10, 12, 10, 0, 0, ZoneId.systemDefault())
        val isTomorrow = date.isTomorrow()
        assertTrue(isTomorrow)
    }
}