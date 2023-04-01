package com.example.immo_prime

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavController
){
    LaunchedEffect(key1 = true){
        delay(5000L)
        navController.navigate("first_screen")
    }
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
            ){
        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = stringResource(id = R.string.imgLog))
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenDefault(){
    //SplashScreen()
}