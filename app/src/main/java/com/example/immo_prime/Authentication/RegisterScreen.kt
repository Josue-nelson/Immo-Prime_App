package com.example.immo_prime.Authentication

import android.content.ContentValues.TAG
import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.R
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo
import com.example.immo_prime.ui.theme.WhiteImo
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun RegisterScreen(navController: NavController){ // Ecran d'inscription
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {

        Row(
            verticalAlignment = Alignment.CenterVertically,// Disposition des elements dans une row
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(
                onClick = { navController.navigate("first_screen") },// Navigation vers le premier ecran
                modifier = Modifier.size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_icon),
                    tint = MaterialTheme.colors.onSurface
                )
            }
            Text(
                text = stringResource(id = R.string.back),
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 20.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row( modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth() ) {
                Text(
                    text = stringResource(R.string.entrez_vos_infos),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    ){
                Text(
                    text = stringResource(id = R.string.description_text)
                )
            }
            Column( modifier = Modifier.fillMaxWidth() ) {
                /**
                 * Dans cette partie le principe est le meme que pour le "LoginScreen" mais y'a une difference
                 * la verification est plus stricte et le bouton de validation restera desactiver tant que l'utilisateur n'aura
                 * pas entrer les elements correct
                 * */
                //var username by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }
                var confirmpassword by remember { mutableStateOf("") }
                var confirmpasswordVisibility by remember { mutableStateOf(false) }
                var passwordVisibility by remember { mutableStateOf(false) }
                var isButtonEnabled by remember { mutableStateOf(false) } // Rendre le bouton touchable "false" par default
                var passwordError by remember { mutableStateOf(false) } // Cela conserne le champs de texte que s'active si les criteres de mot de passe n'est pas remplit

                val icon = if (passwordVisibility)
                    painterResource(id = R.drawable.password_eye) // Meme principe expliquer dans le loginScreen
                else
                    painterResource(id = R.drawable.baseline_visibility_off_24)
                val icon2 = if (confirmpasswordVisibility)
                    painterResource(id = R.drawable.password_eye)
                else
                    painterResource(id = R.drawable.baseline_visibility_off_24)

                val isPasswordValid = password.isNotBlank() && password == confirmpassword && password.length > 6 // On definit que le mot de passe est valide si les criters suivant sont remplit
                val isEmailValid = email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches() // On se sert de la syntaxe par defaut d'u email
                isButtonEnabled = isPasswordValid && isEmailValid // Le bouton est activer si le les conditions suivantes sont a "true"

                /*OutlinedTextField(
                    value = username,
                    onValueChange = {
                        username = it
                    },
                    placeholder = { Text(text = stringResource(R.string.username_placeholder)) },
                    label = { Text(text = stringResource(R.string.usernamelabel)) },
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_person),
                                contentDescription = stringResource(R.string.personicon)
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .background(DarkGrayImo)
                )*/

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
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = DarkGrayImo,
                        cursorColor = DarkBlueImo,
                        focusedLabelColor = DarkBlueImo,
                        focusedIndicatorColor = DarkBlueImo
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        passwordError = it.length < 6
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
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = DarkGrayImo,
                        cursorColor = DarkBlueImo,
                        focusedLabelColor = DarkBlueImo,
                        focusedIndicatorColor = DarkBlueImo
                    )
                )
                if (passwordError) {
                    Text(
                        text = "Le mot de passe doit contenir au moins 6 caractères",
                        color = Color.Red,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                OutlinedTextField(
                    value = confirmpassword,
                    onValueChange = {
                        confirmpassword = it
                    },
                    placeholder = { Text(text = stringResource(R.string.confirmpasswordplaceholder)) },
                    label = { Text(text = stringResource(R.string.confirmpasswordlabel)) },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmpasswordVisibility = !confirmpasswordVisibility
                        }) {
                            Icon(
                                painter = icon2,
                                contentDescription = stringResource(R.string.visibilityicon)
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (confirmpasswordVisibility) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = DarkGrayImo,
                        cursorColor = DarkBlueImo,
                        focusedLabelColor = DarkBlueImo,
                        focusedIndicatorColor = DarkBlueImo
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                           createUser(email, password , navController)
                    },
                    enabled = isButtonEnabled,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = DarkBlueImo
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.soumettre),
                        modifier = Modifier
                            .padding(vertical = 8.dp),
                        color = WhiteImo
                    )
                }
            }
        }
    }
}

fun createUser( // Cette fonction envoie les données ecrit dans le FireStore d'authentification
    email: String,
    password: String,
    navController: NavController

){
    println("L'email est $email, et le mot de passe est $password")

    val auth = Firebase.auth
    try {
        auth.createUserWithEmailAndPassword(email, password) // On prend L'email et le mot de passe
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    navController.navigate("login_screen") // naviguer vers la page de connexion


                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                }
            }
    } catch (e: Exception) {
        println("Erreur : $e.message")
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    val navController = rememberNavController()
    RegisterScreen(navController)
}