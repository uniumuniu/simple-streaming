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
import com.uniumuniu.simplestreaming.common.customFormatDate
import com.uniumuniu.simplestreaming.domain.model.Event
import com.uniumuniu.simplestreaming.domain.model.IBaseEventData
import java.time.ZonedDateTime

const val testImageUrl = "https://test.com/image"

@Composable
fun EventListItem(
    event: IBaseEventData,
    clickableEnabled: Boolean,
    onItemClicked: (IBaseEventData) -> Unit,
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
                painter = rememberImagePainter(
                    data = event.imageUrl,
                    builder = { if (event.imageUrl == testImageUrl) placeholder(com.uniumuniu.simplestreaming.R.drawable._10176837169_image_header_pdach_1554579780000) }
                ),
                contentDescription = "Event image",
                modifier = Modifier
                    .size(128.dp)
                    .padding(4.dp),
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp, bottom = 12.dp)
            ) {
                Column {
                    Text(
                        text = event.title,
                        style = MaterialTheme.typography.subtitle1
                    )
                    Text(
                        text = event.subtitle,
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                Text(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = event.date.customFormatDate(),
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
            date = ZonedDateTime.now(),
            id = "1",
            imageUrl = testImageUrl,
            subtitle = "Champions League",
            title = "Manchester vs Juventus",
            videoUrl = "https://test.com/video"
        ),
        clickableEnabled = false,
        onItemClicked = {}
    )
}
