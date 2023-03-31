package com.example.immo_prime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.Authentication.LoginScreen
import com.example.immo_prime.Authentication.RegisterScreen
import com.example.immo_prime.ui.theme.IMMOPRIMETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IMMOPRIMETheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "first_screen", builder = {
                    composable("first_screen", content = { FirstSection(navController = navController) })
                    composable("login_screen", content = { LoginScreen(navController =   navController) })
                    composable("register_screen", content = { RegisterScreen(navController = navController) })
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IMMOPRIMETheme {

    }
}