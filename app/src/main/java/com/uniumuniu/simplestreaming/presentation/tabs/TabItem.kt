package com.uniumuniu.simplestreaming.presentation.tabs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.uniumuniu.simplestreaming.presentation.Screen


sealed class TabItem(var icon: ImageVector, var title: String, var route: String) {
    object Events : TabItem(
        Icons.Outlined.Home,
        "Events",
        Screen.EventsScreen.route)

    object Schedule : TabItem(
        Icons.Outlined.DateRange,
        "Schedule",
        Screen.ScheduleScreen.route)
}