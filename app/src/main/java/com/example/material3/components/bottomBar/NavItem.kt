package com.example.material3.components.bottomBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.material3.navigation.item.BottomNavItem
import com.example.material3.util.NoRippleInteractionSource

@Composable
fun RowScope.NavItem(
    item: BottomNavItem,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true

    NavigationBarItem(
        selected = selected,
        onClick = {
            navHostController.navigate(item.route)
        },
        icon = {
            Icon(
                painter = if (selected) {
                    painterResource(id = item.selectedIcon)
                } else {
                    painterResource(id = item.unselectedIcon)
                },
                contentDescription = stringResource(id = item.title)
            )
        },
        label = {
            Text(
                text = stringResource(id = item.title),
                fontWeight = if (selected) {
                    FontWeight.SemiBold
                } else {
                    FontWeight.Normal
                }
            )
        },
        alwaysShowLabel = true,
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color(0XFFd9fdd3),
            selectedIconColor = Color(0xFF16603e)
        ),
        interactionSource = NoRippleInteractionSource()
    )
}