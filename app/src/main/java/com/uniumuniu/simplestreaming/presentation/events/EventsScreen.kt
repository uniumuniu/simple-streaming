package com.uniumuniu.simplestreaming.presentation.events

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.uniumuniu.simplestreaming.presentation.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun EventsScreen(navController: NavController?, viewModel: EventsViewModel = hiltViewModel()) {
    val state = viewModel.state
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(state.value) { event ->
            EventListItem(
                event = event,
                clickableEnabled = true
            ) {
                val encodedUrl = URLEncoder.encode(event.videoUrl, StandardCharsets.UTF_8.toString())
                navController?.navigate(Screen.PlaybackScreen.route + "/$encodedUrl")
            }
        }
    }
}

@Preview
@Composable
fun EventsScreenPreview() {
    EventsScreen(navController = null)
}