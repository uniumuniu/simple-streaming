package com.uniumuniu.simplestreaming.presentation.schedule

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.uniumuniu.simplestreaming.domain.model.ScheduleEvent
import com.uniumuniu.simplestreaming.presentation.events.EventListItem
import java.time.ZonedDateTime

@Composable
fun ScheduleScreen(viewModel: ScheduleViewModel = hiltViewModel()) {
    val state = viewModel.state
    ScheduleScreenStateless(events = state.value.events)

    if (state.value.error.isNotBlank()) {
        Toast.makeText(LocalContext.current, state.value.error, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun ScheduleScreenStateless(
    events: List<ScheduleEvent>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(events) { scheduleEvent ->
            EventListItem(
                event = scheduleEvent,
                clickableEnabled = false,
                onItemClicked = {}
            )
        }
    }
}

@Composable
@Preview
fun ScheduleScreenPreview() {
    ScheduleScreenStateless(
        listOf(
            ScheduleEvent(
                date = ZonedDateTime.now(),
                id = "1",
                imageUrl = "https://test.com/image",
                subtitle = "Champions League",
                title = "Manchester vs Juventus",
            ),
            ScheduleEvent(
                date = ZonedDateTime.now(),
                id = "2",
                imageUrl = "https://test.com/image2",
                subtitle = "Champions League",
                title = "Manchester vs Milan",
            )
        )
    )
}