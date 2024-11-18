package com.example.material3.navigation.item

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.material3.R
import com.example.material3.navigation.routes.BottomAppBarRoutes

sealed class BottomNavItem(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {
    data object Feed: BottomNavItem(
        route = BottomAppBarRoutes.Feed.route,
        title = R.string.bottom_bar_item_feed,
        selectedIcon = R.drawable.ic_home_fill,
        unselectedIcon = R.drawable.ic_home_line
    )

    data object Search: BottomNavItem(
        route = BottomAppBarRoutes.Search.route,
        title = R.string.bottom_bar_item_search,
        selectedIcon = R.drawable.ic_search_fill,
        unselectedIcon = R.drawable.ic_search_line
    )

    data object Friends: BottomNavItem(
        route = BottomAppBarRoutes.Friends.route,
        title = R.string.bottom_bar_item_friends,
        selectedIcon = R.drawable.ic_friends_fill,
        unselectedIcon = R.drawable.ic_friends_line
    )

    data object Profile: BottomNavItem(
        route = BottomAppBarRoutes.Profile.route,
        title = R.string.bottom_bar_item_profile,
        selectedIcon = R.drawable.ic_user_settings_fill,
        unselectedIcon = R.drawable.ic_user_settings_line
    )

    companion object {
        val itens = listOf(
            Feed,
            Search,
            Friends,
            Profile
        )
    }
}