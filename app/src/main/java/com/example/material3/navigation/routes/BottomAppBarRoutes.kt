package com.example.material3.navigation.routes

sealed class BottomAppBarRoutes(val route: String) {
    data object Feed: BottomAppBarRoutes("feed")
    data object Search: BottomAppBarRoutes("search")
    data object Friends: BottomAppBarRoutes("friends")
    data object Profile: BottomAppBarRoutes("profile")
}