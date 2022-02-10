package com.uniumuniu.simplestreaming.presentation.tabs

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

//@ExperimentalPagerApi
//@Composable
//fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
//    HorizontalPager(state = pagerState, count = tabs.size) { page ->
//        tabs[page].screen()
//    }
//}
//
//@ExperimentalPagerApi
//@Preview(showBackground = true)
//@Composable
//fun TabsContentPreview() {
//    val tabs = listOf(
//        TabItem.Events(null),
//        TabItem.Schedule(null),
//    )
//    val pagerState = rememberPagerState()
//    TabsContent(tabs = tabs, pagerState = pagerState)
//}