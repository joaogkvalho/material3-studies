package com.example.material3.components.drawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.material3.R

sealed class NavigationDrawerItem(
    val type: NavigationDrawerType,
    val badge: Int,
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {
    data object Videos : NavigationDrawerItem(
        type = NavigationDrawerType.VIDEO,
        badge = 0,
        title = R.string.nav_item_videos,
        selectedIcon = R.drawable.ic_video_fill,
        unselectedIcon = R.drawable.ic_video_line
    )

    data object Photos : NavigationDrawerItem(
        type = NavigationDrawerType.PHOTO,
        badge = 5,
        title = R.string.nav_item_photos,
        selectedIcon = R.drawable.ic_photo_fill,
        unselectedIcon = R.drawable.ic_photo_line
    )

    data object Audios : NavigationDrawerItem(
        type = NavigationDrawerType.AUDIO,
        badge = 0,
        title = R.string.nav_item_audios,
        selectedIcon = R.drawable.ic_audio_fill,
        unselectedIcon = R.drawable.ic_audio_line
    )

    data object Info : NavigationDrawerItem(
        type = NavigationDrawerType.INFO,
        badge = 0,
        title = R.string.nav_item_about,
        selectedIcon = R.drawable.ic_search_fill,
        unselectedIcon = R.drawable.ic_search_line
    )

    enum class NavigationDrawerType {
        VIDEO,
        PHOTO,
        AUDIO,
        INFO,
    }

    companion object {
        val items = listOf(
            Videos,
            Photos,
            Audios,
            Info
        )
    }
}