package com.example.material3.components.bottomBar

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.material3.components.divider.VerticalDividerUI
import com.example.material3.navigation.host.BottomAppBarHost
import com.example.material3.navigation.item.BottomNavItem
import com.example.material3.navigation.routes.BottomAppBarRoutes

@Composable
fun MyBottomAppBar(
    navHostController: NavHostController
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
           AnimatedVisibility(
               visible = isBottomAppBar(currentDestination),
               content = {
                   BottomAppBar(
                       actions = {
                           BottomNavItem.itens.forEachIndexed { index, item ->
                               NavItem(
                                   item = item,
                                   currentDestination = currentDestination,
                                   navHostController = navHostController
                               )

                               if (index < BottomNavItem.itens.size - 1) {
                                   VerticalDividerUI(
                                       modifier = Modifier
                                           .height(32.dp),
                                       color = Color(0xFF16603e)
                                   )
                               }
                           }
                       },
                       modifier = Modifier
                           .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                       containerColor = Color.White,
                   )
               }
           )
        },
        containerColor = Color(0XFFd9fdd3)
    ) { innerPadding ->
        BottomAppBarHost(
            modifier = Modifier
                .padding(innerPadding),
            navHostController = navHostController,
            startDestination = BottomAppBarRoutes.Feed.route
        )
    }
}

private fun isBottomAppBar(currentDestination: NavDestination?): Boolean {
    return when (currentDestination?.route) {
        BottomAppBarRoutes.Feed.route,
        BottomAppBarRoutes.Search.route,
        BottomAppBarRoutes.Friends.route,
        BottomAppBarRoutes.Profile.route -> true
        else -> false
    }
}