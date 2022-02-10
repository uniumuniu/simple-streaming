package com.uniumuniu.simplestreaming.presentation.events

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uniumuniu.simplestreaming.common.encodeUrl
import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.presentation.Screen
import java.time.ZonedDateTime

@Composable
fun EventsScreen(navController: NavController?, viewModel: EventsViewModel = hiltViewModel()) {
    val state = viewModel.state
    EventsScreenStateless(
        events = state.value.events,
        onNavigate = { route -> navController?.navigate(route) })

    if (state.value.error.isNotBlank()) {
        Toast.makeText(LocalContext.current, state.value.error, Toast.LENGTH_LONG).show()
    }
}

@Composable
fun EventsScreenStateless(
    events: List<Event>,
    onNavigate: (route: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(events) { event ->
            EventListItem(
                event = event,
                clickableEnabled = true
            ) {
                onNavigate(Screen.PlaybackScreen.route + "/${event.videoUrl.encodeUrl()}")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun EventsScreenPreview() {
    EventsScreenStateless(
        listOf(
            Event(
                date = ZonedDateTime.now(),
                id = "1",
                imageUrl = testImageUrl,
                subtitle = "Champions League",
                title = "Manchester vs Juventus",
                videoUrl = "https://test.com/video"
            ),
            Event(
                date = ZonedDateTime.now(),
                id = "2",
                imageUrl = testImageUrl,
                subtitle = "Champions League",
                title = "Manchester vs Milan",
                videoUrl = "https://test.com/video2"
            )
        ),
        onNavigate = {}
    )
}