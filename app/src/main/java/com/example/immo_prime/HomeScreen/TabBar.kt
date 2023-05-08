package com.example.immo_prime.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyBottomNavigation(
    items: List<NavItem>,
    modifier: Modifier = Modifier,
    //onItemClick: (NavItem) -> Unit
) {
    BottomNavigation (
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 8.dp
            ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = false,
                onClick = { /*onItemClick(item)*/ },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label
                        )
                        if(item.selected){
                            Text(
                                text = item.label,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            )
        }
    }
}

data class NavItem(val label: String, val icon: ImageVector, val selected: Boolean)

@Preview(showBackground = true)
@Composable
fun MyBottomNavigationPreview(){
    MyBottomNavigation(
        items = listOf(
            NavItem(
                "Home",
                Icons.Default.Home,
                true
            ),
            NavItem(
                "Profile",
                Icons.Default.Person,
                false
            ),
            NavItem(
                "Setting",
                Icons.Default.Settings,
                false
            ),
            NavItem(
                "test",
                Icons.Default.Deblur,
                false
            ),
            NavItem(
                "test",
                Icons.Default.DeleteForever,
            false
            ),
        ),
        //onItemClick =
    )
}