package com.example.immo_prime.Utility

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.*

class sharedViewModel(): ViewModel() {

    private val fireStoreRef = Firebase.firestore
        .collection("logements")
    private val storage = FirebaseStorage.getInstance()
    // Ajouter un logement
    fun saveLogement(
        logement: Logement,
        imageUri: Uri?,
        context: Context
    ) = CoroutineScope(Dispatchers.IO).launch {

        // Initialisation de la connexion avec le FireStore
        // val fireStoreRef = Firebase.firestore
           // .collection("logements")

        try {
            val id = getNextId()

            fireStoreRef.document(id.toString()).set(logement.copy(id = id))
                .addOnSuccessListener {
                    Toast.makeText(context, "Ajout du logement avec succes", Toast.LENGTH_SHORT).show()
                }

            val uploadTask = FirebaseStorage
                .getInstance()
                .reference
                .child("images/${id}")
                .putFile(imageUri!!)

            uploadTask.addOnSuccessListener { imageUri ->
                // MEttre a jour l'URL de l'image dans les logements
                //val logementAvecImage =
            }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }

            /*.document(logement.id.toString())

        // Ceci est une gestion des exceptions qui permettra d'ajouter dans la collection logement de firestore ddes infos
        try {

            fireStoreRef.set(logement)
                .addOnSuccessListener {
                    Toast.makeText(context, "Ajout du logement avec succes", Toast.LENGTH_SHORT).show()
                }

        } catch (e: Exception){
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
        }
*/
    }

    suspend fun getNextId(): Int{

        val querySnapShot = fireStoreRef
            .orderBy("id", Query.Direction.DESCENDING)
            .limit(1)
            .get().await()
        val lastLogement = querySnapShot.documents.firstOrNull()?.toObject(Logement::class.java)
        val lastId = lastLogement?.id ?: 0
        return lastId + 1
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

    private val firestore = FirebaseFirestore.getInstance()
    private val ImageStorage = FirebaseStorage.getInstance()
    private val collectionName = "logements"
    private val storagePath = "images"

    fun ajouterLogement(logement: Logement2, imageUri: Uri, context: Context) {
        try {
            // Générer un nouvel ID pour le logement
            val newLogementId = firestore.collection(collectionName).document().id

            // Créer une nouvelle instance de Logement avec l'ID généré
            val logementAvecId = logement.copy(id = newLogementId.toInt())

            // Insérer le logement dans Firestore
            firestore.collection(collectionName)
                .document(newLogementId)
                .set(logementAvecId)
                .addOnSuccessListener {
                    // Succès de l'ajout du logement dans Firestore

                    // Télécharger l'image vers Firebase Storage
                    val storageRef = storage.reference.child("$storagePath/${UUID.randomUUID()}")
                    val uploadTask = storageRef.putFile(imageUri)

                    uploadTask.addOnSuccessListener { taskSnapshot ->
                        // Récupérer l'URL de téléchargement de l'image depuis Firebase Storage
                        storageRef.downloadUrl.addOnSuccessListener { imageUrl ->
                            // Mettre à jour l'URL de l'image dans le logement
                            val logementAvecImage = logementAvecId.copy(Picture = imageUrl.toString())

                            // Mettre à jour le logement dans Firestore avec l'URL de l'image
                            firestore.collection(collectionName)
                                .document(newLogementId)
                                .set(logementAvecImage)
                                .addOnSuccessListener {
                                    // Succès de la mise à jour de l'URL de l'image dans Firestore

                                }
                                .addOnFailureListener { exception ->
                                    // Erreur lors de la mise à jour de l'URL de l'image dans Firestore
                                    Toast.makeText(context, "Erreur lors de la mise à jour de l'URL de l'image", Toast.LENGTH_SHORT).show()
                                }
                        }
                    }
                        .addOnFailureListener { exception ->
                            // Erreur lors du téléchargement de l'image vers Firebase Storage
                            // Gérer l'erreur ici
                            Toast.makeText(context, "Erreur lors du téléchargement de l'image", Toast.LENGTH_SHORT).show()
                        }
                }
                .addOnFailureListener { exception ->
                    // Erreur lors de l'ajout du logement dans Firestore
                    // Gérer l'erreur ici
                    Toast.makeText(context, "Erreur lors de l'ajout du logement", Toast.LENGTH_SHORT).show()
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