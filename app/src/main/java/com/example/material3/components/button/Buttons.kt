package com.example.material3.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    outlined: Boolean = false,
    onClick: () -> Unit
) {
    if (outlined) {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFF9C27B0),
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color(0xFF673AB7),
            ),
            border = if (enabled) {
                BorderStroke(1.dp, Color(0xFF9C27B0))
            } else {
                BorderStroke(1.dp, Color(0xFF673AB7))
            },
            content = {
                Text(
                    text = text
                )
            }
        )
    } else {
        Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color(0xFF3F51B5),
                disabledContainerColor = Color(0xFF2196F3),
                disabledContentColor = Color.White.copy(0.6F)
            ),
            content = {
                Text(
                    text = text
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonsPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleButton(
            onClick = {},
            text = "Login",
            modifier = Modifier
                .fillMaxWidth(),
            enabled = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        SimpleButton(
            onClick = {},
            text = "Login",
            modifier = Modifier
                .fillMaxWidth(),
            enabled = false,
            outlined = true
        )
    }
}