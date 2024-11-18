package com.example.material3.features.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.material3.components.drawer.NavigationDrawerItem
import com.example.material3.components.drawer.NavigationDrawerUI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerScreen(
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    var drawerIndex by remember { mutableIntStateOf(0) }

    NavigationDrawerUI(
        modifier = modifier,
        drawerState = drawerState,
        drawerIndex = drawerIndex,
        items = NavigationDrawerItem.items,
        onDrawerItemClick = { index ->
            drawerIndex = index
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Feed",
                                modifier = Modifier
                                    .fillMaxWidth(),
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Color(0xFFd9fdd3)
                        ),
                    )
                },
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                    ) {

                    }
                }
            )
        }
    )
}