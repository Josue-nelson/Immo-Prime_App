package com.example.immo_prime.DetaillScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Bathroom
import androidx.compose.material.icons.rounded.SingleBed
import androidx.compose.material.icons.rounded.SquareFoot
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.HomeScreen.CardLogement
import com.example.immo_prime.HomeScreen.RowCardLogementPreview
import com.example.immo_prime.R
import com.example.immo_prime.Utility.Logement
import com.example.immo_prime.ui.theme.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        bottomBar = { TransparentBottomNavigation() },
        scaffoldState = scaffoldState,
        modifier = Modifier
    ) {
        Body(navController = navController)
    }
}

@Composable
fun Body(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ParallaxToolBar(navController = navController)
        Spacer(modifier = Modifier.height(12.dp))
        LogementDescription()
        Spacer(modifier = Modifier.height(20.dp))
        LocalInformation()
        Spacer(modifier = Modifier.height(20.dp))
        DescriptionText()
        Spacer(modifier = Modifier.height(20.dp))
        OtherHome()
        Spacer(modifier = Modifier.height(20.dp))
        HomeNearby(
            listOf(
                Logement(2,"Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0),
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
private fun ParallaxToolBar(navController: NavController) {
    Box(
        modifier = Modifier
    ) {
        Image(
            painterResource(id = R.drawable.bg_detail_screen),
            contentDescription = "background",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Button(
                onClick = { navController.popBackStack() },
                shape = CircleShape,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkGrayImo
                )
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = DarkGrayImo2)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = CircleShape,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = DarkGrayImo
                )
            ) {
                Icon(Icons.Filled.Favorite, contentDescription = null, tint = DarkGrayImo2)
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
fun LogementDescription() {
    Row (
        modifier = Modifier.padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.CropSquare,
            contentDescription = null,
            tint = DarkBlueImo,
            modifier = Modifier
                .size(20.dp)
                .background(DarkBlueImo)
        )
        Text(
            text = " Appartement",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 3.dp)
        )
    }
    Row(
        modifier = Modifier
            .padding(start = 20.dp, top = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Rue de Palmiers Nkolmesseng - Yaounde" + "\n A 100m de Cyntiche Lounge",
            fontSize = 14.sp
        )
        Image(painter = painterResource(id = R.drawable.ic_for_sale_2), contentDescription = null, modifier = Modifier.padding(end = 5.dp))
    }
    Row (
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
    ){
        Text(text = "50,000,0 Fcfa", fontSize = 30.sp)
    }
    Row (
        modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 10.dp)
            ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier.size(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Bathroom,
                        contentDescription = stringResource(id = R.string.back_icon),
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "2ba",
                    fontSize = 16.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier.size(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.SingleBed,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "2ba",
                    fontSize = 16.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier.size(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.SquareFoot,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "500sqft",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun LocalInformation() {
    Text(
        text = "Local Information",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp),
        color = DarkGreenImo
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row (
        modifier = Modifier
            .fillMaxWidth()
            ){
        TabRow()
    }
}


@Composable
fun DescriptionText() {
    Text(
        text = "Desription",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp),
        color = DarkGreenImo
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = "Hi, original neighborhood photos," +
            " resident re, original neighborhood photos, " +
            "resident.,Hi, original neighborhood photos, " +
            "resident re, original neighborhood photos, " +
            "resident. In arcu risus vestibulum sollicitudin " +
            "elit sed sed convallis tincidunt. Risus turpis hac metus " +
            "facilisi ut enim massa eu. Dolor suscipit sit velit massa adipiscing" +
            " adipiscing vulputate feugiat turpis. Fames sed ut dignissim tincidunt metus. " +
            "Morbi varius quis enim gravida....",
        fontSize = 14.sp,
        modifier = Modifier.padding(start = 20.dp, end = 10.dp)
    )
}

@Composable
fun OtherHome() {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ){
        RowCardLogementPreview()
    }
}


@Composable
fun HomeNearby(items: List<Logement>) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ){
        Text(
            text = "Home Nearby",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGreenImo
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow{
            items(items){
                CardLogement(logement = Logement(3, "Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0))
                CardLogement(logement = Logement(4,"Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0))
                CardLogement(logement = Logement(5,"Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge", painterResource(id = R.drawable.house3), 2, 2, 900.0))
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    DetailScreen(navController = rememberNavController())
}

@Composable
fun TabRow(){
    var selectedTab by remember {
        mutableStateOf("Map")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                ){
            ClickableText(text = AnnotatedString("Map"), onClick = { selectedTab = "Map" }, modifier = if (selectedTab == "Map") Modifier
                .border(BorderStroke(2.dp, DarkBlueImo), shape = MaterialTheme.shapes.medium)
                .padding(horizontal = 16.dp, vertical = 8.dp) else Modifier,
                style = TextStyle(
                    color = if (selectedTab == "Map") DarkBlueImo else Color.Black
                )
            )
            ClickableText(text = AnnotatedString("Information"), onClick = { selectedTab = "Information" }, modifier = if (selectedTab == "Information") Modifier
                .border(BorderStroke(2.dp, DarkBlueImo), shape = MaterialTheme.shapes.medium)
                .padding(horizontal = 16.dp, vertical = 8.dp) else Modifier,
                style = TextStyle(
                    color = if (selectedTab == "Information") DarkBlueImo else Color.Black
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        if(selectedTab == "Map"){
            Image(
                painter = painterResource(id = R.drawable.mapf),
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
                    .border(BorderStroke(1.dp, Color.Black)),
                contentScale = ContentScale.Crop
            )
        } else {
            Text(
                text = "Cette Maison  est situé à Douala plus précisement à Logbessou derrière iuc à 100m de la route",
                modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            )
        }
    }
}

@Composable
fun TransparentBottomNavigation() {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 0.dp, // remove the shadow below the bottom navigation bar
    ) {
        Row {
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                selected = true,
                onClick = { /*TODO*/ },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                //label = { Text(text = "Home") }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
                selected = false,
                onClick = { /*TODO*/ },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                //label = { Text(text = "Search") }
            )
            BottomNavigationItem(
                icon = {
                    Icon(
                        Icons.Filled.ShoppingCart,
                        contentDescription = "Favorites"
                    )
                },
                selected = false,
                onClick = { /*TODO*/ },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                //label = { Text(text = "Favorites") }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Tag, contentDescription = "Downloads") },
                selected = false,
                onClick = { /*TODO*/ },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                //label = { Text(text = "Downloads") }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                selected = false,
                onClick = { /*TODO*/ },
                selectedContentColor = Color.DarkGray,
                unselectedContentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                //label = { Text(text = "Profile") }
            )
        }
    }
}