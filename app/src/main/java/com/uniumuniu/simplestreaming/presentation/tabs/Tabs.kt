package com.uniumuniu.simplestreaming.presentation.tabs

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

//@ExperimentalPagerApi
//@ExperimentalMaterialApi
//@Composable
//fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
//    val scope = rememberCoroutineScope()
//    TabRow(
//        selectedTabIndex = pagerState.currentPage,
//        backgroundColor = colorResource(id = com.uniumuniu.simplestreaming.R.color.purple_700),
//        contentColor = Color.White,
//        indicator = { tabPositions ->
//            TabRowDefaults.Indicator(
//                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
//            )
//        }
//    ) {
//        tabs.forEachIndexed { index, tabItem ->
//            Tab(
//                selected = pagerState.currentPage == index,
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(index)
//                    }
//                },
//                text = {
//                    Text(tabItem.title)
//                },
//                icon = {
//                    Icon(painter = painterResource(id = tabItem.icon), contentDescription = "")
//                }
//            )
//        }
//    }
//}
//
//
//@ExperimentalPagerApi
//@ExperimentalMaterialApi
//@Preview(showBackground = true)
//@Composable
//fun TabsPreview() {
//    val tabs = listOf(
//        TabItem.Events(null),
//        TabItem.Schedule(null),
//    )
//    val pagerState = rememberPagerState()
//    Tabs(tabs = tabs, pagerState = pagerState)
//}