package com.uniumuniu.simplestreaming.presentation.events


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.domain.model.IBaseEventData

@Composable
fun EventListItem(
    event: IBaseEventData,
    clickableEnabled: Boolean,
    onItemClicked: (IBaseEventData) -> Unit
) {
    // TODO - move to dimensions
    val bigPadding = 12.dp
    val smallPadding = 6.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                PaddingValues(
                    start = bigPadding,
                    top = smallPadding,
                    end = bigPadding,
                    bottom = smallPadding
                )
            )
            .clickable(enabled = clickableEnabled) {
                onItemClicked(event)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {

            Image(
                painter = rememberImagePainter(event.imageUrl),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Text(
                        text = event.title,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = event.subtitle,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                Text(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = event.date,
                    style = MaterialTheme.typography.body2
                )
            }

        }

    }
}

@Composable
@Preview
fun EventListItemPreview() {
    EventListItem(
        event = Event(
            date = "Yesterday, 10:30",
            id = "1",
            imageUrl = "",
            subtitle = "Champions League",
            title = "Manchester vs Juventus",
            videoUrl = "",
        ),
        clickableEnabled = false
    ) {}
}
