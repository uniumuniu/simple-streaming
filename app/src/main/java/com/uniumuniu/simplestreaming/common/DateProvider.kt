package com.uniumuniu.simplestreaming.common

import java.time.LocalDate

object DateProvider {

    fun getNow(): LocalDate {
        return LocalDate.now()
    }
}