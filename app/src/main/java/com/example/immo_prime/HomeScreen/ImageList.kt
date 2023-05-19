package com.example.immo_prime.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.firebase.storage.FirebaseStorage

@Composable
fun ImageList(images: List<String>, imageWidth: Int, imageHeight: Int){
     val context = LocalContext.current
     LazyColumn(modifier = Modifier.padding(8.dp)){
          items(images){ imageRef ->
               Image(
                    painter = rememberImagePainter(
                         data = imageRef.toString(),
                         builder = {
                              crossfade(true)
                         }
                    ),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                         .width(imageWidth.dp)
                         .height(imageHeight.dp)
               )
          }
     }
}

@Preview
@Composable
fun ListAllImages(){
     val firebaseStorage = FirebaseStorage.getInstance()
     val imageUrls = listOf(
          "https://firebasestorage.googleapis.com/v0/b/immo-prime.appspot.com/o/house1.jpg?alt=media&token=ebfcc758-458b-48c3-a6ee-f3bed31a9cb5",
          "https://firebasestorage.googleapis.com/v0/b/immo-prime.appspot.com/o/house2.jpg?alt=media&token=d0359865-c739-4a01-a95d-87bf1708dc2b",
          "https://firebasestorage.googleapis.com/v0/b/immo-prime.appspot.com/o/house3.jpg?alt=media&token=808c1cbe-1312-429e-bc7d-1bf6833885c1"
     )
     ImageList(
          images = imageUrls,
          imageWidth = 200,
          imageHeight = 200
     )

}