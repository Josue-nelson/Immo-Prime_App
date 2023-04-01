package com.example.immo_prime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.WhiteImo


@Composable
fun FirstSection(
    navController: NavController
){
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.size(400.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                      navController.navigate("register_screen")
            },
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkBlueImo
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = stringResource(R.string.inscription),
                modifier = Modifier
                    .background(DarkBlueImo)
                    .padding(vertical = 8.dp),
                color = WhiteImo
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.avoircompte),
                modifier = Modifier.padding(8.dp)
            )
            ClickableText(
                text = AnnotatedString(stringResource(R.string.connexion)),
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    color = DarkBlueImo
                ),
                onClick = {
                    navController.navigate("login_screen")
                },

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview(){
    val navController = rememberNavController()
    FirstSection(navController = navController)
}