package com.example.material3.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NavigationDrawerUI(
    modifier: Modifier = Modifier,
    drawerState: DrawerState = rememberDrawerState(DrawerValue.Closed),
    drawerIndex: Int,
    items: List<NavigationDrawerItem>,
    onDrawerItemClick: (Int) -> Unit,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))

                items.forEachIndexed { index, drawerItem ->
                    NavigationDrawerItem(
                        label = { Text(text = stringResource(id = drawerItem.title)) },
                        selected = drawerIndex == index,
                        onClick = { onDrawerItemClick(index) },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        icon = {
                            Icon(
                                painter = if (drawerIndex == index) {
                                    painterResource(id = drawerItem.selectedIcon)
                                } else {
                                    painterResource(id = drawerItem.unselectedIcon)
                                },
                                contentDescription = stringResource(id = drawerItem.title)
                            )
                        },
                        badge = {
                            if (drawerItem.badge > 0) {
                                Text(text = drawerItem.badge.toString(),)
                            }
                        }
                    )
                }
            }
        },
        modifier = modifier,
        drawerState = drawerState,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
private fun NavigationDrawerUIPreview() {
    val drawerState = rememberDrawerState(DrawerValue.Open)
    var drawerIndex by remember { mutableIntStateOf(0) }

    NavigationDrawerUI(
        drawerState = drawerState,
        drawerIndex = drawerIndex,
        items = NavigationDrawerItem.items,
        onDrawerItemClick = { index ->
            drawerIndex = index
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Content")
            }
        }
    )
}