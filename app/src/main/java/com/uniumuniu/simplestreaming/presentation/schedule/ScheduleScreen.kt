package com.uniumuniu.simplestreaming.presentation.schedule

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.uniumuniu.simplestreaming.presentation.events.EventListItem

@Composable
fun ScheduleScreen(viewModel: ScheduleViewModel = hiltViewModel()) {
    val state = viewModel.state
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(state.value) { scheduleEvent ->
            EventListItem(
                event = scheduleEvent,
                clickableEnabled = false,
                onItemClicked = {}
            )
        }
    }
}

@Preview
@Composable
fun ScheduleScreenPreview() {
    ScheduleScreen()
}