package com.example.immo_prime.OtherScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TermsAppScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", modifier = Modifier.size(35.dp))
            Text(text = "Terms & Condition", fontSize = 20.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold,modifier = Modifier.fillMaxWidth().padding(end = 16.dp))
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Les conditions\nd’utilisation", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(start = 30.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "si vous rencontrez des problemes lie au produit\n" +
                "bienvouloir nous contacter au ", modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Les termes et condition", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Derniere mise a jour le 20 janvier", modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "S’il vous plait , bien vouloir lire ces termes et condion\n" +
                "d’utilistion avant de continuer a utiliser l’application\n" +
                "afin d’eviter d’enfreidre les regles de la communaute",  modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "S’il vous plait , bien vouloir lire ces termes et condion\n" +
                "d’utilistion avant de continuer a utiliser l’application\n" +
                "afin d’eviter d’enfreidre les regles de la communaute",  modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "S’il vous plait , bien vouloir lire ces termes et condion\n" +
                "d’utilistion avant de continuer a utiliser l’application\n" +
                "afin d’eviter d’enfreidre les regles de la communaute",  modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "S’il vous plait , bien vouloir lire ces termes et condion\n" +
                "d’utilistion avant de continuer a utiliser l’application\n" +
                "afin d’eviter d’enfreidre les regles de la communaute",  modifier = Modifier.padding(start = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun TermsAppScreenPreview(){
    TermsAppScreen()
}