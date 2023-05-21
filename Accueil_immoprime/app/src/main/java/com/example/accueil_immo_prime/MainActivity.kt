package com.example.accueil_immo_prime

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.accueil_immo_prime.ui.theme.Accueil_immoprimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Accueil_immoprimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    MyScreen()

                }
            }
        }
    }

}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScreen() {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            Surface(
                elevation = 4.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(16.dp)
                        .background(color = Color.Transparent)
                        .fillMaxWidth(),

                ) {
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription ="",Modifier.size(50.dp))

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(onClick = { /* Do something */ }) {
                        Icon(Icons.Filled.Person, "Profile")
                    }
                }
            }
        },
        content = {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                HeaderWithImage()
                HorizontalImageList()
                HorizontalImageList2()

                CardWithImageAndText()
                NavigationBar()


            }
        }

    )
}



@Composable
fun NavigationBar() {
    BottomNavigation {

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorite") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Cart") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            selected = false,
            onClick = {}
        )
    }
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
                modifier = Modifier.padding(16.dp)
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
fun HorizontalImageList() {
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
        items(images) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 8.dp,
                onClick = {},
                //shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.width(200.dp)) {

                    Image(

                        painterResource(id = R.drawable.house1),
                        contentDescription = "Appartemenent a louer situer a douala-logbessou",
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                        //.clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                        // contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Appartement",
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 10.dp)
                    )
                    Text(
                        text="For Sale",
                        color = Color.Blue,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp, horizontal = 10.dp)


                    )
                    Text(
                        text = "Appartemenent a louer situer a douala-logbessou",
                        textAlign = TextAlign.Left,
                        fontSize = 14.sp,
                        color=Color.Gray,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Text(
                        text="50.000f",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 5.dp)
                            .padding(vertical = 5.dp, horizontal = 10.dp)


                    )

                }
            }
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
            Button(modifier = Modifier.align(Alignment.End),
                onClick = { /* Do something */ }) {
                Text("Read More")
''
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
                modifier = Modifier.padding(vertical = 3.dp).padding(end = 5.dp)



            )
            Button(onClick = { /* Do something */ }, modifier = Modifier.align(Alignment.End)) {
                Text("Read More")
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HorizontalImageList2() {
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
            text = "Similar House You May Location",
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
        items(images) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = 8.dp,
                onClick = {},
                //shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.width(200.dp)) {

                    Image(

                        painterResource(id = R.drawable.house4),
                        contentDescription = "Appartemenent a louer situer a douala-logbessou",
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                        //.clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                        // contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Appartement",
                        textAlign = TextAlign.Left,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 10.dp)
                    )
                    Text(
                        text="Location",
                        color = Color.Blue,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp, horizontal = 10.dp)


                    )
                    Text(
                        text = "Appartemenent a louer situer a douala-logbessou",
                        textAlign = TextAlign.Left,
                        fontSize = 14.sp,
                        color = Color.DarkGray,

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp, horizontal = 10.dp)
                    )
                    Text(
                        text="1.000.000f",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp, horizontal = 10.dp)


                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Accueil_immoprimeTheme {
        Greeting("Android")
    }
}