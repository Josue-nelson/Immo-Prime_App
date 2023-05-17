package com.example.immo_prime.LogementScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.Animations_object.ImagePicker
import com.example.immo_prime.Animations_object.dropDownMenu
import com.example.immo_prime.Utility.Logement
import com.example.immo_prime.Utility.sharedViewModel
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo

@Composable
fun AddLogement(
    navController: NavController,
    sharedViewModel: sharedViewModel
) {
    val id: String by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var priceDouble by remember { mutableStateOf(0.0) }
    var description by remember { mutableStateOf("") }
    val picture by remember{ mutableStateOf(null)}
    var nbreDouche by remember { mutableStateOf("") }
    var nbreDoucheInt by remember { mutableStateOf(0) }
    var nbreChambre by remember { mutableStateOf("") }
    var nbreChambreInt by remember { mutableStateOf(0) }
    var superficie by remember { mutableStateOf("") }
    var superficieDouble by remember { mutableStateOf(0.0) }

    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        // back button
        Row(modifier = Modifier
            .padding(start = 15.dp, top = 15.dp, end = 15.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
            Text(
                text = "Ajoutez un logement",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
            // add data Layout
            Spacer(modifier = Modifier.height(20.dp))
            // Image
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                ImagePicker()
            }
            // Type
            dropDownMenu()
            // Price
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = price,
                onValueChange = {
                    price = it
                    if (price.isNotEmpty()) {
                        priceDouble = price.toDouble()
                    }
                },
                label = {
                    Text(text = "Prix")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = DarkGrayImo,
                    cursorColor = DarkBlueImo,
                    focusedLabelColor = DarkBlueImo,
                    focusedIndicatorColor = DarkBlueImo
                )
            )
            // Description
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = description,
                onValueChange = {
                    description = it
                },
                label = {
                    Text(text = "Description")
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = DarkGrayImo,
                    cursorColor = DarkBlueImo,
                    focusedLabelColor = DarkBlueImo,
                    focusedIndicatorColor = DarkBlueImo
                )
            )
            // Nombre de douche
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = nbreDouche,
                onValueChange = {
                    nbreDouche = it
                    if (nbreDouche.isNotEmpty()) {
                        nbreDoucheInt = nbreDouche.toInt()
                    }
                },
                label = {
                    Text(text = "Nombre de douche")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = DarkGrayImo,
                    cursorColor = DarkBlueImo,
                    focusedLabelColor = DarkBlueImo,
                    focusedIndicatorColor = DarkBlueImo
                )
            )
            // Nombre de chambre
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = nbreChambre,
                onValueChange = {
                    nbreChambre = it
                    if (nbreChambre.isNotEmpty()) {
                        nbreChambreInt = nbreChambre.toInt()
                    }
                },
                label = {
                    Text(text = "Nombre de chambre")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = DarkGrayImo,
                    cursorColor = DarkBlueImo,
                    focusedLabelColor = DarkBlueImo,
                    focusedIndicatorColor = DarkBlueImo
                )
            )
            // Superficie
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = superficie,
                onValueChange = {
                    superficie = it
                    if (superficie.isNotEmpty()) {
                        superficieDouble = price.toDouble()
                    }
                },
                label = {
                    Text(text = "Superficie")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = DarkGrayImo,
                    cursorColor = DarkBlueImo,
                    focusedLabelColor = DarkBlueImo,
                    focusedIndicatorColor = DarkBlueImo
                )
            )
            // save Button
            Button(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 50.dp)
                    .height(40.dp)
                    .fillMaxWidth(),
                onClick = {
                    val userData = Logement(
                        type = type,
                        price = priceDouble,
                        //Picture = rememberImagePainter(data = ""),
                        description = description,
                        nbreDouche = nbreDoucheInt,
                        nbreChambre = nbreChambreInt,
                        superficie = superficieDouble
                    )

                    sharedViewModel.saveLogement(logement = userData, context = context)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkBlueImo,
                )
            ) {
                Text(text = "Enregistrer", color = Color.White)
            }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AddLogementPreview(){
    AddLogement(navController = rememberNavController(), sharedViewModel = sharedViewModel())
}