package com.example.immo_prime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MysScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painterResource(id = R.drawable.bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Button(onClick = { /*TODO*/ },
                    shape = CircleShape,
                    modifier = Modifier.size(50.dp).background(Color.Transparent)) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Button(onClick = { /*TODO*/ },
                    shape = CircleShape,
                    modifier = Modifier.size(50.dp).background(Color.Transparent)) {
                Icon(Icons.Filled.Favorite, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }

        // Box 3: Description with price
        Box(modifier = Modifier.weight(1f)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Appartement",
                    style = MaterialTheme.typography.h4,
                    color = Color.Blue,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Description Description Description Description",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = "50,000.0 FCFA",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }

        // Box 2: TabBar with map and localisation
        Box(modifier = Modifier.weight(1f)) {
            val tabs = listOf("MAP", "INFORMATIONS")
            var selectedTabIndex by remember { mutableStateOf(0) }
            TabRow(selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index }
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> Image(
                    painter = painterResource(R.drawable.map),
                    contentDescription = "map_img",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 40.dp),
                    contentScale = ContentScale.Crop
                )
                1 -> Text(
                    text = "Cette Maison  est situé à Douala plus précisement à Logbessou derrière iuc à 100m de la route",
                    modifier = Modifier.padding(50.dp)
                )
            }
        }

        // Box 4: Description with price
        Box(modifier = Modifier.weight(1f)) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "Description",
                    color = Color.Blue,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Ici on va faire une courte  et breve description de la maison",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }

        //Reciclerview horizontal

        //boutons de navigation
        BottomNavigation {
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                //label = { Text("Home") },
                selected = true,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Search, contentDescription = null) },
                //label = { Text("Recherch") },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.ShoppingBasket, contentDescription = null) },
                //label = { Text("Market") },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                //label = { Text("Settings") },
                selected = false,
                onClick = {}
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.LocationOn, contentDescription = null) },
                //label = { Text("Localize") },
                selected = false,
                onClick = {}
            )
        }
    }
}

/*@Composable
fun LazyRowWithImageTitleDescription() {
    LazyRow{
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text ="Titre",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Description",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}*/







@Composable
fun MylListItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Beautiful apartment near the beach",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(text = "Price: \$1000/month")
        Text(
            text = "This is a description of the apartment.",
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondsScreenPreview(){
    MysScreen()
    //MylListItem()
}