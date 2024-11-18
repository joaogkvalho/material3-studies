package com.example.material3.features.friends

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.material3.components.button.SimpleButton
import com.example.material3.components.card.CardUI

@Composable
fun FriendsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(42.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("FriendsScreen")

        Spacer(modifier = Modifier.height(16.dp))

        SimpleButton(
            text = "João Gabriel",
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {}
        )

        SimpleButton(
            text = "Lucas Carvalho",
            modifier = Modifier
                .fillMaxWidth(),
            outlined = true,
            onClick = {}
        )
    }
}