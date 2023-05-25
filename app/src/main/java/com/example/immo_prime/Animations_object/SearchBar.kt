package com.example.immo_prime.Animations_object

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.immo_prime.R
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.Orange
import com.example.immo_prime.ui.theme.Shapes

@Composable
fun SearchBar(){
    var searchElement by remember { mutableStateOf("") }
    OutlinedTextField( // Champs email
        value = searchElement,
        onValueChange = {
            searchElement = it
        },
        placeholder = { Text(text = stringResource(R.string.element_rechercher)) },
        trailingIcon = {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .background(Orange, Shapes.medium)
                    .height(54.dp)
                    .width(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search),
                    tint = Color.White
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            cursorColor = DarkBlueImo,
            focusedLabelColor = DarkBlueImo,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = Shapes.medium
    )
}

@Preview(showBackground = true)
@Composable
fun SearhBarPreview(){
    SearchBar()
}