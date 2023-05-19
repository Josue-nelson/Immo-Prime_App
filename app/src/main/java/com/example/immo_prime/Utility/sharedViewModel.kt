package com.example.immo_prime.Utility

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class sharedViewModel(): ViewModel() {

    // Ajouter un logement
    fun saveLogement(
        logement: Logement,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        // Initialisation de la connexion avec le FireStore
        val fireStoreRef = Firebase.firestore
            .collection("logement")
            .document(logement.id.toString())

        // Ceci est une gestion des exceptions qui permettra d'ajouter dans la collection logement de firestore ddes infos
        try {

            fireStoreRef.set(logement)
                .addOnSuccessListener {
                    Toast.makeText(context, "Ajout du logement avec succes", Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

    }

    // Modifier un logement
    fun EditLogemet(
        logementID: Int,
        context: Context,
        data: (Logement) -> Unit
    ) = CoroutineScope(Dispatchers.IO).launch{

        // Initialisation de la connexion avec le FireStore
        val fireStoreRef = Firebase.firestore
            .collection("logement")
            .document(logementID.toString())

        // Ceci est une gestion des exceptions qui permettra d'ajouter dans la collection logement de firestore ddes infos
        try {

            fireStoreRef.get()
                .addOnSuccessListener {
                    if (it.exists()){
                        var logement = it.toObject<Logement>()!!
                        data(logement)
                    } else {
                        Toast.makeText(context, "Pas de logement trouvé", Toast.LENGTH_SHORT).show()
                    }
                }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

    }

    // Supprimer logement
    fun deleteLogement(
        logementID: Int,
        context: Context,
        navController: NavController
    ) = CoroutineScope(Dispatchers.IO).launch {

        // Initialisation de la connexion avec le FireStore
        val fireStoreRef = Firebase.firestore
            .collection("logement")
            .document(logementID.toString())

        // Ceci est une gestion des exceptions qui permettra d'ajouter dans la collection logement de firestore ddes infos
        try {

            fireStoreRef.get()
                .addOnSuccessListener {
                    Toast.makeText(context, "Logement supprimer avec succes", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

    }

    // Afficher la liste des logements
    fun AfficherAllLogement(){
        // Initialisation de la connexion avec le FireStore
        val fireStoreRef = Firebase.firestore

        // C'est fort on vera sa plus tard

    }

}