package com.example.immo_prime

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo
import com.example.immo_prime.ui.theme.Shapes
import com.example.immo_prime.ui.theme.WhiteImo

@Composable
fun ChoiceAccountType(navController: NavController){
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoimmo),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth,
            alpha = 0.5f,
        )

        // Ajouter le reste des éléments de votre écran ici
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Choisissez votre compte",
            color = DarkBlueImo,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            modifier = Modifier.fillMaxWidth())

            var clicked by remember { mutableStateOf(false) }
            var accountType by remember { mutableStateOf("") }

            Button(
                onClick = {
                    accountType = "Proprietaire"
                    Log.i(accountType, "account type : ")
                    navController.navigate("login_screen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = if (clicked) {
                    ButtonDefaults.buttonColors(
                        backgroundColor = DarkGrayImo
                    )
                } else ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlueImo
                ),
                shape = CircleShape
            ) {
                Text(
                    text = stringResource(R.string.proprietaire),
                    color = WhiteImo
                )
            }
            Button(
                onClick = {
                    accountType = "Client"
                    Log.i(accountType, "account type : ")
                    navController.navigate("login_screen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlueImo
                ),
                shape = CircleShape
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
    val navController = rememberNavController()
    ChoiceAccountType(navController = navController)
}