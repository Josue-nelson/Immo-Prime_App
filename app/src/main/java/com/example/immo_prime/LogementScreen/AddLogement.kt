package com.example.immo_prime.LogementScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.Animations_object.dropDownMenu
import com.example.immo_prime.Utility.Logement
import com.example.immo_prime.Utility.sharedViewModel

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
//    var picture: String by remember { mutableStateOf("") }
//    var picturePainter: Painter by remember { mutableStateOf(null) }
    var nbreDouche by remember { mutableStateOf("") }
    var nbreDoucheInt by remember { mutableStateOf(0) }
    var nbreChambre by remember { mutableStateOf("") }
    var nbreChambreInt by remember { mutableStateOf(0) }
    var superficie by remember { mutableStateOf("") }
    var superficieDouble by remember { mutableStateOf(0.0) }
//    var age: String by remember { mutableStateOf("") }
//    var ageInt: Int by remember { mutableStateOf(0) }

    val context = LocalContext.current

    // main Layout
    Column(modifier = Modifier.fillMaxSize()) {
        // back button
        Row(modifier = Modifier
            .padding(start = 15.dp, top = 15.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = { navController.popBackStack() }
            ) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back_button")
            }
        }
        // add data Layout
        Column(
            modifier = Modifier
                .padding(start = 60.dp, end = 60.dp, bottom = 50.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Id
//            OutlinedTextField(
//                modifier = Modifier.fillMaxWidth(),
//                value = id,
//                onValueChange = {
//                    id = it
//                },
//                label = {
//                    Text(text = "Id")
//                }
//            )
            // Type
            dropDownMenu()
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = type,
                onValueChange = {
                    type = it
                },
                label = {
                    Text(text = "Type")
                }
            )
            // Price
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = price,
                onValueChange = {
                    price = it
                    if (price.isNotEmpty()) {
                        priceDouble = price.toDouble()
                    }
                },
                label = {
                    Text(text = "Price")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            // Description
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = description,
                onValueChange = {
                    description = it
                },
                label = {
                    Text(text = "Description")
                }
            )
            // Nombre de douche
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // Nombre de chambre
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            // Superficie
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
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
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )
            // save Button
            Button(
                modifier = Modifier
                    .padding(top = 50.dp)
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
                }
            ) {
                Text(text = "Publier")
                Text(text = "Save")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddLogementPreview(){
    AddLogement(navController = rememberNavController(), sharedViewModel = sharedViewModel())
}