package com.example.immo_prime.Payement

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.R

@ExperimentalAnimationApi
@Composable
fun AddPaymentCard(navController: NavController) {
    var nameText by remember { mutableStateOf(TextFieldValue()) }
    var cardNumber by remember { mutableStateOf(TextFieldValue()) }
    var expiryNumber by remember { mutableStateOf(TextFieldValue()) }
    var cvcNumber by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize()) {
        PaymentCard(
            nameText,
            cardNumber,
            expiryNumber,
            cvcNumber
        )
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item {
                InputItem(
                    textFieldValue = nameText,
                    label = stringResource(id = R.string.card_holder_name),
                    onTextChanged = { nameText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }

            item {
                InputItem(
                    textFieldValue = cardNumber,
                    label = stringResource(id = R.string.card_holder_number),
                    keyboardType = KeyboardType.Number,
                    onTextChanged = { cardNumber = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    visualTransformation = CreditCardFilter
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InputItem(
                        textFieldValue = expiryNumber,
                        label = stringResource(id = R.string.expiry_date),
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { expiryNumber = it },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )
                    InputItem(
                        textFieldValue = cvcNumber,
                        label = stringResource(id = R.string.cvc),
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { cvcNumber = it },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )
                }
            }

            item {
                val context = LocalContext.current
                Button(
                    onClick = {
                            makeToastAddSuccess(context)
                            navController.navigate("detail_screen")
                        },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.save),
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp)
                    )
                }
            }


            item {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp)
                ){
                    Text(
                        text = "Autres moyens de payement ",
                        style = MaterialTheme.typography.h6,
                        color = Color.Blue,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .background(Color.White)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .width(100.dp)
                            .background(Color.White)
                    ) {
                        Button(
                            onClick = { navController.navigate("momo_payment_screen") },
                            modifier = Modifier
                                .fillMaxSize()
                                .height(48.dp)
                                .background(Color.White)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.momo),
                                contentDescription = "Button 1 Image",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Button(
                            onClick = { navController.navigate("om_payment_screen") },
                            modifier = Modifier
                                .fillMaxSize()
                                .height(48.dp)
                                .background(Color.White)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.orage_money),
                                contentDescription = "Button 2 Image",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

fun makeToastAddSuccess(context: Context){
    Toast.makeText(context, "Paiement effectuer avec succes", Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun AddPaymentCardPreview(){
    AddPaymentCard(navController = rememberNavController())
}

