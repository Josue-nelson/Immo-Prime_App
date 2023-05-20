package com.example.immo_prime

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.Authentication.LoginScreen
import com.example.immo_prime.Authentication.RegisterScreen
import com.example.immo_prime.DetaillScreen.DetailScreen
import com.example.immo_prime.LogementScreen.AddLogement
import com.example.immo_prime.Payement.AddPaymentCard
import com.example.immo_prime.Payement.MyMomoBox
import com.example.immo_prime.Payement.MyOmBox
import com.example.immo_prime.Utility.sharedViewModel
import com.example.immo_prime.ui.theme.IMMOPRIMETheme
import com.example.immo_prime.ui.theme.Payement

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
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
                    composable("payment", content = { Payement() })
                    composable("add_logement", content = { AddLogement(navController = navController, sharedViewModel = sharedViewModel()) })
                    composable("payment_screen", content = { AddPaymentCard(navController = navController) })
                    composable("om_payment_screen", content = { MyOmBox(navController = navController) })
                    composable("momo_payment_screen", content = { MyMomoBox(navController = navController) })
                },
                modifier = Modifier.background(Color.White)
                )
            }
        }
    }
}

fun makeToastConnection(context: Context){
    Toast.makeText(context, "ERREUR DE CONNEXION A INTERNET", Toast.LENGTH_LONG).show()
}

fun isInternetConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}