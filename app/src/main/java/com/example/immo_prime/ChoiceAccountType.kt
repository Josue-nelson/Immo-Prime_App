package com.example.immo_prime

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo
import com.example.immo_prime.ui.theme.Shapes
import com.example.immo_prime.ui.theme.WhiteImo

@Composable
fun ChoiceAccountType(){
    Column(
        Modifier.fillMaxSize()
    ) {
        var clicked by  remember { mutableStateOf(false) }
        Button(
            onClick = { clicked != clicked },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = if (clicked){
                ButtonDefaults.buttonColors(
                    backgroundColor = DarkGrayImo
                )
                } else ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlueImo
                ),
            shape = Shapes.medium
        ) {
            Text(
                text = stringResource(R.string.proprietaire),
                color = WhiteImo
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkBlueImo
            ),
            shape = Shapes.medium
        ) {
            Text(
                text = stringResource(R.string.client),
                color = WhiteImo
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChoiceAccountTypePreview(){
    ChoiceAccountType()
}