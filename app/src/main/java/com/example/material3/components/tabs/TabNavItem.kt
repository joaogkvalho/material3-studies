package com.example.material3.components.tabs

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.material3.R

sealed class TabNavItem(
    val type: TabType,
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {

    data object Videos : TabNavItem(
        type = TabType.VIDEO,
        title = R.string.tab_item_videos,
        selectedIcon = R.drawable.ic_video_fill,
        unselectedIcon = R.drawable.ic_video_line,
    )

    data object Photos : TabNavItem(
        type = TabType.PHOTO,
        title = R.string.tab_item_photos,
        selectedIcon = R.drawable.ic_photo_fill,
        unselectedIcon = R.drawable.ic_photo_line,
    )

    data object Audios : TabNavItem(
        type = TabType.AUDIO,
        title = R.string.tab_item_audios,
        selectedIcon = R.drawable.ic_audio_fill,
        unselectedIcon = R.drawable.ic_audio_line,
    )

    enum class TabType {
        VIDEO,
        PHOTO,
        AUDIO
    }

    companion object {
        val items = listOf(
            Videos,
            Photos,
            Audios
        )
    }

}