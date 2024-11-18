package com.example.material3.navigation.host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.material3.features.drawer.DrawerScreen
import com.example.material3.features.feed.FeedScreen
import com.example.material3.features.friends.FriendsScreen
import com.example.material3.features.profile.ProfileScreen
import com.example.material3.features.search.SearchScreen
import com.example.material3.navigation.routes.BottomAppBarRoutes

@Composable
fun BottomAppBarHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = BottomAppBarRoutes.Feed.route) {
            FeedScreen(
                navigateToDrawerScreen = {
                    navHostController.navigate("DrawerScreen")
                }
            )
        }

        composable(route = BottomAppBarRoutes.Search.route) {
            SearchScreen()
        }

        composable(route = BottomAppBarRoutes.Friends.route) {
            FriendsScreen()
        }

        composable(route = BottomAppBarRoutes.Profile.route) {
            ProfileScreen()
        }

        composable(route = "DrawerScreen") {
            DrawerScreen()
        }
    }
}