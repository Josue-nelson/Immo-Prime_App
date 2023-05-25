package com.example.immo_prime.LogementScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun ListLogementScreen(){
    val db = Firebase.firestore
    val collecionRef = db.collection("logements")

    var documents by remember { mutableStateOf(listOf<DocumentSnapshot>()) }

    LaunchedEffect(Unit) {
        collecionRef.get().addOnSuccessListener { querySnapShot ->
            documents = querySnapShot.documents
        }
    }

    LazyColumn{
        items(documents){ document ->
            document.getString("id")?.let { Text(text = it) }
        }
    }
}

@Preview
@Composable
fun ListLogementScreenPReview(){
    ListLogementScreen()
}