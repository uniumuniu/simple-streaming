package com.uniumuniu.simplestreaming.presentation

sealed class Screen(val route: String) {
    object EventsScreen: Screen("events_screen")
    object ScheduleScreen: Screen("schedule_screen")
    object PlaybackScreen: Screen("playback_screen")
}
