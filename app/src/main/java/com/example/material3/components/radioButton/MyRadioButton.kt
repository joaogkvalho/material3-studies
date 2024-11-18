package com.example.material3.components.radioButton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyRadioButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    RadioButton(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = RadioButtonDefaults.colors(
            selectedColor = Color(0xFF61BD8B),
            unselectedColor = Color(0xFF0CBB6A)
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun MyRadioButtonPreview() {
    val options = listOf(1, 2, 3)

    var radioState by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ProfileScreen")

        options.forEach { item ->
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyRadioButton(
                    selected = item == radioState,
                    onClick = {
                        radioState = item
                    }
                )

                Text(text = "Option $item")
            }
        }
    }
}