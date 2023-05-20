package com.example.immo_prime.LogementScreen

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.immo_prime.Utility.Logement
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ListLogementScreen(){
    val context = LocalContext.current
    val fireStoreRef = FirebaseFirestore.getInstance()

    var logementItems = mutableListOf<Logement?>()
    fireStoreRef.collection("documents").get()
        .addOnSuccessListener { querySnapshots ->
            if (!querySnapshots.isEmpty){
                val list = querySnapshots.documents
                for (d in list){
                    val c : Logement? = d.toObject(Logement::class.java)
                    logementItems.add(c)
                }
            } else{
                Toast.makeText(
                    context,
                    "Votre liste de logement est vide",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.addOnFailureListener {
            Toast.makeText(
                context,
                "Nous n'arrivos pas a charger la liste de vos logements",
                Toast.LENGTH_SHORT
            ).show()
        }

    // Interface
    LazyColumn(modifier = Modifier.fillMaxSize()){
        itemsIndexed(logementItems){index, item ->
            Column {
                if (logementItems.isEmpty()){
                    logementItems[index]?.id?.let {
                        Text(
                            text = AnnotatedString(it.toString()),
                            Modifier
                                .width(100.dp)
                                .border(1.dp, Color.LightGray, RoundedCornerShape(20.dp))
                                .clip(RoundedCornerShape(20.dp))
                                .padding(10.dp),
                            textAlign = TextAlign.Center
                        )
                }
            } else {
                    Text(text = "Rien")
                }
            }
        }
    }
}

@Preview
@Composable
fun ListLogementScreenPReview(){
    ListLogementScreen()
}