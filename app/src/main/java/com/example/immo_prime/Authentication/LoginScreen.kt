@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package com.example.immo_prime.Authentication


import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.R
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo
import com.example.immo_prime.ui.theme.Shapes
import com.example.immo_prime.ui.theme.WhiteImo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


@Composable
fun LoginScreen(navController: NavController){
    Column (
        Modifier.fillMaxSize()
            ){
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = stringResource(R.string.imgLog),
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(DarkBlueImo)
          )
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var email by remember { mutableStateOf("") }
            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisibility by remember { mutableStateOf(false) }
            
            val icon = if (passwordVisibility)
                painterResource(id = R.drawable.password_eye)
            else 
                painterResource(id = R.drawable.baseline_visibility_off_24)
            
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = { Text(text = stringResource(R.string.emailplaceholder)) },
                label = { Text(text = stringResource(R.string.emaillabel)) },
                trailingIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = stringResource(R.string.emailicon)
                        )
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(DarkGrayImo)
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = { Text(text = stringResource(R.string.passwordplaceholder)) },
                label = { Text(text = stringResource(R.string.passwordlabel)) },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = stringResource(R.string.visibilityicon)
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(DarkGrayImo)
            )

            ClickableText(
                text = AnnotatedString(stringResource(R.string.mot_passe_oublie)),
                style = TextStyle(
                    color = DarkBlueImo,
                    textAlign = TextAlign.Left
                ),
                onClick = { },
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth()
                )

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Text(text = stringResource(id = R.string.avoircompte), modifier = Modifier.padding(8.dp))
                ClickableText(
                    text = AnnotatedString(stringResource(R.string.creer)),
                    modifier = Modifier.padding(8.dp),
                    style = TextStyle(
                        color = DarkBlueImo
                    ),
                    onClick = { navController.navigate("register_screen") }
                    )
            }
            Button(
                onClick = { login(email, password , navController) },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlueImo
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = stringResource(R.string.connexion),
                    modifier = Modifier
                        .background(DarkBlueImo)
                        .padding(vertical = 8.dp),
                    color = WhiteImo
                )
            }
            GoogleButton(
                text = stringResource(id = R.string.connect_with_google),
                loadingText = stringResource(id = R.string.loading_connect),
                onClicked = {
                    Log.d("Boutton Google", "Cliquer")
                }
            )
        }
    }
}


@Composable
fun GoogleButton(
    text: String = stringResource(id = R.string.connect_with_google),
    loadingText: String = stringResource(id = R.string.loading_connect),
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClicked: () -> Unit
){
    var clicked by remember { mutableStateOf(false) }

    Surface(
        onClick = { clicked =! clicked },
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(painter = icon,
                contentDescription = stringResource(R.string.google_button),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else text)
            Spacer(modifier = Modifier.width(8.dp))
            if (clicked){
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                onClicked()
            }
        }
    }
}

fun login(
    email: String,
    password: String,
    navController: NavController

){
    val auth = Firebase.auth
    try {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    navController.navigate("home_screen") // naviguer vers la page de connexion


                } else{
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                }
            }
    } catch (e: Exception){
        println(e.message)
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}