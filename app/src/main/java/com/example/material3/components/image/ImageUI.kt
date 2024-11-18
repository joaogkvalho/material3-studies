package com.example.material3.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.material3.R

@Composable
fun ImageUI() {
    Image(
        painter = painterResource(R.drawable.jetpack_compose),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )

//    AsyncImage(
//        model = "https://blog.stylingandroid.com/wp-content/uploads/2021/05/jetpack-compose-icon_RGB-277x300.png",
//        contentDescription = null,
//    )
}

@Preview(showBackground = true)
@Composable
private fun ImageUIPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageUI()
    }
}