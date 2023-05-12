package com.example.immo_prime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.Authentication.LoginScreen
import com.example.immo_prime.Authentication.RegisterScreen
import com.example.immo_prime.DetaillScreen.DetailScreen
import com.example.immo_prime.ui.theme.IMMOPRIMETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMMOPRIMETheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "splash_screen", builder = {
                    composable("splash_screen", content = { SplashScreen(navController = navController) })
                    composable("first_screen", content = { FirstSection(navController = navController) })
                    composable("login_screen", content = { LoginScreen(navController =   navController) })
                    composable("register_screen", content = { RegisterScreen(navController = navController) })
                    composable("home_screen", content = { HomeScreen(navController=navController) })
                    composable("choice_account", content = { ChoiceAccountType(navController = navController) })
                    composable("detail_screen" , content={ DetailScreen(navController=navController) })
                },
                modifier = Modifier.background(Color.White)
                )
            }
        }
    }
}