package com.example.immo_prime.LogementScreen

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.immo_prime.R
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.Shapes
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListLogementScreen(navController: NavController){
   // Acces a FireStore instance from your activity
    val db = Firebase.firestore
    // La collection Logement
    val logements = remember { mutableStateListOf<DocumentSnapshot>() }

    db.collection("logements")
        .get()
        .addOnSuccessListener { documents ->
            for (document in documents){
                Log.d(TAG, "${document.id} => ${document.data}")
                logements.add(document)
            }
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents: ", exception)
        }

    /*LazyColumn {
        items(logements) { logement ->
            Card(
                modifier = Modifier.padding(16.dp),
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Image(
                        painter = rememberImagePainter(logement["picture"]),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }
        }
    }*/

    LazyColumn(
        modifier = Modifier.padding(20.dp)
    ) {
        stickyHeader {
            Column(modifier = Modifier.background(Color.White)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,// Disposition des elements dans une row
                    modifier = Modifier.padding(16.dp).background(Color.White)
                ) {
                    IconButton(
                        onClick = { navController.popBackStack() },// Navigation vers le premier ecran
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth().background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Liste des logements",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,

                        )
                }
            }
        }
        items(logements) { logement ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
//        elevation = 8.dp
            ) {

//
//

                    Column(modifier = Modifier.padding(16.dp)
                    ) {

//                Text(text = "${logement.prix} €")
                        Text(text = "Superficie : ${logement["superficie"]} m²")
                        Text(text = "Nb Douches : ${logement["nb_douches"]}")
                        Text(text = "Prix : ${logement["prix"]} FCFA")
                        Text(text = "Nb Chambres : ${logement["nb_chambres"]}")
                        Text(text = "Description : ${logement["description"]}")
                        Text(text = "Type : ${logement["type"]}")

                        Image(
                            painter = rememberImagePainter(logement["picture"]),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                    }


            }
        }
        item {
            TextButton(
                onClick = { navController.navigate("add_logement") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
//                        ButtonColors = ButtonDefaults.colorTextField,
                    contentColor = Color.White,
                    backgroundColor = DarkBlueImo
                ),
                shape = Shapes.medium
            ) {
                Text(text = "Publier", fontSize = 20.sp)
            }
        }
    }
}

@Preview
@Composable
fun ListLogementScreenPReview(){
    ListLogementScreen(navController = rememberNavController())
}