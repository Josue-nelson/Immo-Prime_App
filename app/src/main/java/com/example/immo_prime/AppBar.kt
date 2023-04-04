package com.example.immo_prime

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
//    TopAppBar(
//        title = {
//            Text(text = stringResource(id = R.string.app_name))
//        },
//        backgroundColor = MaterialTheme.colors.primary,
//        contentColor = MaterialTheme.colors.onPrimary,
//        navigationIcon = {
//            IconButton(onClick = onNavigationIconClick) {
//                Icon(
//                    imageVector = Icons.Default.Menu,
//                    contentDescription = "Toggle drawer"
//                )
//            }
//        }
//    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left content
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logo1),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "IMMO-PRIME,", fontSize = 16.sp, color = Color.Gray)
                // Text(text = "Carolina Terner", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }

        // Right content
        Box {

            IconButton(onClick = onNavigationIconClick) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "This is a profile picture",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(50.dp))
                )
            }


        }
    }

}