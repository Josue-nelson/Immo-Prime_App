package com.example.immo_prime


import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.immo_prime.DetaillScreen.TransparentBottomNavigation
import com.example.immo_prime.HomeScreen.CardLogement
import com.example.immo_prime.ui.theme.DarkBlueImo
import kotlinx.coroutines.launch

//@Composable
//fun HomeScreen(navController: NavController){
//    MaterialTheme {
//        Column {
//            Text("Bonjour et bienvenue!")
//        }
//    }
//}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()



    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { TransparentBottomNavigation()} ,

//        topBar = {
//            Surface(
//                elevation = 4.dp,
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .background(color = Color.Transparent)
//                        .fillMaxWidth()
//                ) {
//                    IconButton(onClick = onNavigationIconClick) {
//                        Icon(Icons.Filled.Person, "Profile")
//                    }
//
//                    Spacer(modifier = Modifier.weight(1f))
//
//                    IconButton(onClick = { /* Do something */ }) {
//                        Icon(Icons.Filled.Favorite, "Application logo")
//                    }
//                }
//            }
//
//
//        },

        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },

        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            NavigationDrawer(

                // AvatarUrl = "https://plus.unsplash.com/premium_photo-1684093759271-1ec27d9f0dac?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1374&q=80",
                AvatarUrl = painterResource(id = R.drawable.yvanac),
                name = "yvana cabrelle",
                email = "tchindayvana@gmail.com",
                Icon =   painterResource(id = R.drawable.yvanac),
                items = listOf<MenuItem>().toList()
            )
//code pour l'affichage de la liste des menus a l'ecran
            DrawerBody(
                items = listOf(
                    MenuItem(
                        id = "home",
                        title = "Home",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.Home
                    ),

                    MenuItem(
                        id = "account",
                        title = "Account",
                        contentDescription = "Get help",
                        icon = Icons.Default.AccountBox
                    ),
                    MenuItem(
                        id = "favorites",
                        title = "Favorites",
                        contentDescription = "Get help",
                        icon = Icons.Default.LocalFlorist
                    ),

                    MenuItem(
                        id = "logement",
                        title = "Logement",
                        contentDescription = "logement",
                        icon = Icons.Default.Apartment,
                    ),
                    MenuItem(
                        id = "settings",
                        title = "Settings",
                        contentDescription = "Go to settings screen",
                        icon = Icons.Default.Settings
                    ),
                    MenuItem(
                        id = "help",
                        title = "Help",
                        contentDescription = "Get help",
                        icon = Icons.Default.Info
                    )


                ),
                onItemClick = {
                    println("Clicked on ${it.title}")
                    if(it.id == "logement") navController.navigate("add_logement")
                }

            )

            DrawerBody1(

                items = listOf(
                    MenuItem(
                        id = "terms",
                        title = "Terms & condition",
                        contentDescription = "Go to home screen",
                        icon = Icons.Default.GraphicEq
                    ),
                    MenuItem(
                        id = "settings",
                        title = "Bank account details",
                        contentDescription = "Go to settings screen",
                        icon = Icons.Default.Home
                    )

                ),
                onItemClick = {
                    println("Clicked on ${it.title} ")
                    if(it.id == "terms") navController.navigate("terms_app_screen")
                }

            )

        },




        content = {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                HeaderWithImage()
                HorizontalImageList(navController = navController)
                CardWithImageAndText()
                CardWithImageAndText()



            }
        },
    )
}



@Composable
fun ParallaxTopAppBar(
    title: String,

    actions: @Composable () -> Unit = {}
) {
    Box() {
        TopAppBar(
            title = { Text(title) },

            elevation = 0.dp,
            navigationIcon = null,

            )
    }
}


@Composable
fun HeaderWithImage() {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(R.drawable.house2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(20.dp)
                .padding(vertical = 4.dp)
                .fillMaxWidth()
            //.background(Color.Gray, shape = RoundedCornerShape(4.dp))

        ) {
            Text(
                text = "Dicover Your Favorite House",
                modifier = Modifier.padding(vertical = 5.dp),
                style = TextStyle(fontSize = 34.sp),
                color = Color.Black,


                )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 80.dp),
            // .border(1.dp, Color.Gray, shape = RoundedCornerShape(16.dp)),
            verticalAlignment = Alignment.Bottom,
        ) {
            TextField(

                value = "",
                onValueChange = {  },
                label = { Text("Search") },
                modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.body2.copy(color = Color.Black),

                )

        }
    }
}
@Composable
fun HousePurchaseCard() {
    Card(
        modifier = Modifier
            .width(20.dp)
            .padding(16.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Image(
                painterResource(id = R.drawable.house1),
                contentDescription = "Appartemenent a louer situer a douala-logbessou ",
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "50.000f",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(end = 5.dp)
            )

            Text(
                text = "Pour acheter une maison, il est important de déterminer votre budget, de trouver une propriété qui répond à vos besoins et à vos critères, de faire une offre et de négocier le contrat de vente. Vous devrez également organiser une inspection de la maison et obtenir une assurance habitation. N'oubliez pas les coûts supplémentaires tels que les frais de clôture et les taxes foncières.",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            )
        }
    }
}

//Reciclerview horizontal
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HorizontalImageList(navController: NavController) {
    val images = listOf(
        ImageWithText(R.drawable.house3, "Titre 1"),
        ImageWithText(R.drawable.house4, "Titre 2"),
        ImageWithText(R.drawable.house3, "Titre 3")
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 15.dp),

        verticalAlignment = Alignment.Bottom,
    ){
        Text(
            text = "The House You May Buy",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,

            color=Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
    }

    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(images) {
            Card(onClick = { navController.navigate("payment_screen") }){
                CardLogement("Appartement",
                    50000.0,
                    "Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge",
                    2,
                    2,
                    900.0,
                    image = painterResource(id = R.drawable.house3),
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Card (
                onClick = { navController.navigate("payment_screen") }
            ){
                CardLogement("Appartement",
                    50000.0,
                    "Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge",
                    2,
                    2,
                    900.0,
                    image = painterResource(id = R.drawable.house6),
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Card(
                onClick = { navController.navigate("payment_screen") }
            ) {
                CardLogement("Appartement",
                    50000.0,
                    "Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge",
                    2,
                    2,
                    900.0,
                    image = painterResource(id = R.drawable.house7),
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

data class ImageWithText(val image: Int, val title: String)

@Composable
fun CardWithImageAndText() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 15.dp),

        verticalAlignment = Alignment.Bottom,
    ){
        Text(
            text = "Similar Home you may like",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,

            color=Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
    }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.houseback),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Appartement",
                textAlign = TextAlign.Left,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text="For Sale",
                color = Color.Blue,
                fontSize = 10.sp,
                modifier = Modifier.padding(vertical = 2.dp)
            )
            Text(
                text="50.000f",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 3.dp)


            )
            Button(onClick = { /* Do something */ }, modifier = Modifier.align(Alignment.End),colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkBlueImo
            )) {
                Text("Read More")
            }
        }
    }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(R.drawable.house8),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Appartement",
                textAlign = TextAlign.Left,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                text="For Sale",
                color = Color.Blue,
                fontSize = 10.sp,
                modifier = Modifier.padding(vertical = 2.dp)


            )
            Text(
                text="50.000f",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(vertical = 3.dp)
                    .padding(end = 5.dp)



            )
            Button(onClick = { /* Do something */ }, modifier = Modifier.align(Alignment.End), colors = ButtonDefaults.buttonColors(
                backgroundColor = DarkBlueImo
            )) {
                Text("Read More")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HorizontalImageList2(
    navController: NavController
) {
    val images = listOf(
        ImageWithText(R.drawable.house3, "Titre 1"),
        ImageWithText(R.drawable.house4, "Titre 2"),
        ImageWithText(R.drawable.house3, "Titre 3")
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 15.dp),

        verticalAlignment = Alignment.Bottom,
    ) {
        Text(
            text = "Similar House You May Location",
            textAlign = TextAlign.Left,
            fontSize = 30.sp,

            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
    }

    LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
        items(images) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 8.dp,
                onClick = { navController.navigate("detail_screen") },
                //shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.width(200.dp)) {

                    CardLogement("Appartement",
                        50000.0,
                        "Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge",
                        2,
                        2,
                        900.0,
                        image = painterResource(id = R.drawable.house3),
                    )

                    CardLogement("Appartement",
                        50000.0,
                        "Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge",
                        2,
                        2,
                        900.0,
                        image = painterResource(id = R.drawable.house4)
                    )
                    CardLogement("Appartement",
                        50000.0,
                        "Rue des palmier Nkolmesseng-Yaounde\nA 100m de Cyntiche Lounge",
                        2,
                        2,
                        900.0,
                        image = painterResource(id = R.drawable.houseback),
                    )

                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    Accueil_immoprimeTheme {
//        Greeting("Android")
//    }
//}