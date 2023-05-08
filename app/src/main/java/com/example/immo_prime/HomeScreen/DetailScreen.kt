package com.example.immo_prime.HomeScreen

import android.widget.Space
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.SquareFoot
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.immo_prime.R
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo
import com.example.immo_prime.ui.theme.DarkGrayImo2
import com.example.immo_prime.ui.theme.Shapes

@Composable
fun DetailScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ParallaxToolBar()
        Spacer(modifier = Modifier.height(12.dp))
        LogementDescription()
        Spacer(modifier = Modifier.height(20.dp))
        LocalInformation()
    }
}

@Composable
private fun ParallaxToolBar() {
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
                onClick = { /*TODO*/ },
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
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
            ){
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
                text = "900 sqft",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun LocalInformation() {
    Text(
        text = "Local Information",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Row (
        modifier = Modifier
            .fillMaxWidth()
            ){
        var selectedTab by remember { mutableStateOf("Map") }

        TabRow(selectedTab = selectedTab) { tab ->
            selectedTab = tab
        }
        Spacer(modifier = Modifier.height(9.dp))
        Image(
            painter = painterResource(id = R.drawable.house3),
            contentDescription = "map",
            modifier = Modifier.height(300.dp)
        )
    }
}

@Composable
fun TabRow(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.Transparent)
            .padding(start = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Tab(
            text = "Map",
            isSelected = selectedTab == "Map",
            onClick = { onTabSelected("Map") }
        )
        Tab(
            text = "Information",
            isSelected = selectedTab == "Information",
            onClick = { onTabSelected("Information") }
        )
    }
}

@Composable
fun Tab(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .border(if (isSelected) 2.dp else 0.dp, DarkBlueImo, shape = Shapes.large)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            color = if (isSelected) DarkBlueImo else Color.Gray,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    DetailScreen()
}