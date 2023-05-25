package com.example.immo_prime


import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.immo_prime.Animations_object.SearchBar
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController
) {
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { TransparentBottomNavigation()} ,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) // Ceci est L'APP BAR contenant le nom de l'application et le bouton d'acces au Drawer
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
                        title = "Gestion de logement",
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
                    if(it.id == "logement") navController.navigate("list_logement")
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
                Spacer(modifier = Modifier.height(50.dp))
            }
        },
    )
}




@Composable
fun HeaderWithImage() {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ){
        // FOnd d'ecran de l'image
        Image(
            painter = painterResource(R.drawable.house2),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop // Remplit toute la Box grace a la propriete Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
            //.background(Color.Gray, shape = RoundedCornerShape(4.dp))

        ) {


            Text(
                text = "Dicover Your\nNew House",
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(),
                style = TextStyle(fontSize = 34.sp),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold
                )
            Text(
                text = "Let's to discover your ideal house",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )
            SearchBar() // Ceci une composante appellé et crée par moi meme
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
        items(images) {
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