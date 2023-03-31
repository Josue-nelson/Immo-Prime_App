package com.example.immo_prime.Authentication

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.immo_prime.R
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo
import com.example.immo_prime.ui.theme.WhiteImo

@Composable
fun RegisterScreen(){
    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(
                onClick = {  },
                modifier = Modifier.size(40.dp)
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
                modifier = Modifier.padding(start = 8.dp)
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
                    fontSize = 30.sp
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
                var username by remember { mutableStateOf("") }
                var email by remember { mutableStateOf("") }
                var password by rememberSaveable { mutableStateOf("") }
                var passwordVisibility by remember { mutableStateOf(false) }

                val icon = if (passwordVisibility)
                    painterResource(id = R.drawable.password_eye)
                else
                    painterResource(id = R.drawable.baseline_visibility_off_24)

                OutlinedTextField(
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
                )

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
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Navigation vers un autre écran */ },
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
                            .background(DarkBlueImo)
                            .padding(vertical = 8.dp),
                        color = WhiteImo
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}