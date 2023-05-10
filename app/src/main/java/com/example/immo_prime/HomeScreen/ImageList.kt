package com.example.immo_prime.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage


@Preview(showBackground = true)
@Composable
fun ImageList() {
     val storageReference = Firebase.storage.reference
     val images = listOf(
          "image/house1.jpeg",
          "image/house2.jpeg",
          "image/house3.jpeg"
     )

     LazyColumn(modifier = Modifier.fillMaxSize()) {
          items(images) { image ->
               val imageUrl = storageReference.child(image).downloadUrl.toString()
               Image(
                    painter = rememberImagePainter(
                         data = imageUrl,
                         builder = {
                              crossfade(true)
                         }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                         .fillMaxWidth()
                         .height(200.dp),
                    contentScale = ContentScale.Crop
               )
          }
     }
}