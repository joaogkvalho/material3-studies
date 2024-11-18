package com.example.material3.components.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TabsUI(
    modifier: Modifier = Modifier
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState {
        TabNavItem.items.size
    }

    LaunchedEffect(tabIndex) {
        pagerState.animateScrollToPage(tabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        tabIndex = pagerState.currentPage
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            modifier = modifier,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .padding(horizontal = 32.dp)
                        .clip(CircleShape),
                    color = Color(0xFF16603e)
                )
            },
            divider = {},
            tabs = {
                TabNavItem.items.forEachIndexed { index, tab ->
                    Tab(
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        text = {
                            Text(
                                text = stringResource(id = tab.title),
                                style = TextStyle(
                                    fontSize = 12.sp
                                )
                            )
                        },
                        icon = {
                            Icon(
                                painter =if (tabIndex == index) {
                                    painterResource(id = tab.selectedIcon)
                                } else {
                                    painterResource(id = tab.unselectedIcon)
                                },
                                contentDescription = stringResource(id = tab.title)
                            )
                        },
                        unselectedContentColor = Color(0xFF16603e),
                        selectedContentColor = Color(0xFF16603e)
                    )
                }
            }
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
            pageContent = { tabPosistion ->
                val tab = TabNavItem.items[tabPosistion]
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(id = tab.title))
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TabsUIPreview() {
    TabsUI()
}