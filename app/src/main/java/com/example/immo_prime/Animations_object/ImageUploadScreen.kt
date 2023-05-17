package com.example.immo_prime.Animations_object

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.immo_prime.ui.theme.DarkBlueImo


@Composable
fun ImagePicker() {
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (imageUri == null) {
            // Afficher un placeholder si aucune image n'est sélectionnée
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text("Sélectionner une image", color = Color.White)
            }
        } else {
            // Afficher l'image sélectionnée
            Image(
                painter = rememberImagePainter(imageUri),
                contentDescription = "Image sélectionnée",
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { result ->
            // Récupérer l'URI de l'image sélectionnée
            result.data?.data?.let { uri ->
                imageUri = uri
            }
        }

        Button(onClick = {
            // Ouvrir la galerie lorsqu'on clique sur le bouton
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "image/*"
            }
            launcher.launch(intent)
        },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkBlueImo
            )
        ) {
            Text("Sélectionner une image", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageUploadScreenPreview(){
    ImagePicker()
}