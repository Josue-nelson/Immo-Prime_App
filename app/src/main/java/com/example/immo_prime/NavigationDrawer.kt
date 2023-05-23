package com.example.immo_prime

//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun NavigationDrawer(

    name:String,
    email:String,
    items: List<MenuItem>,
    AvatarUrl: Painter,
    Icon:Painter,
//onItemClick: (MenuItem) -> Unit
)/*{
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(vertical = 10.dp)


//affichage de l'image

    )*/ {

    Box(modifier = Modifier) {
        //verticalAlignment = Alignment.CenterVertically

        (Image
            (
            painter = painterResource(id = R.drawable.yvanac),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            // colorFilter= ColorFilter.blur(10f),
            modifier = Modifier

                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .height(250.dp)
                .blur(10.dp)



        ))


        Column(modifier = Modifier) {

            Image(

                painter = painterResource(id = R.drawable.yvanac),
                contentDescription = null, // optional
                modifier = Modifier
                    //alignement au centre en haut de l'écran


                    //.padding(top = 16.dp)
                    .size(80.dp)
                    .width(50.dp)
                    .clip(CircleShape)

            )


            Text(text = name, color = Color.Black, textAlign = TextAlign.End)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween ) {
                Text(text = email, color = Color.Black, textAlign = TextAlign.End)
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
            }


        }




        Divider()
        items.forEach {
            Row(modifier = Modifier
                .fillMaxWidth()

                .clickable() {



                }
                .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically)
            {
                Icon(imageVector = it.icon, contentDescription = it.title)
                Spacer(modifier = Modifier.width(36.dp))
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = it.title)
            }


            // Text(text = "yvana@gmail.com", fontSize = 20.sp)

        }


    }


}




// Image(
/* painter = painterResource(id=R.drawable.dome),
 contentDescription= null,
 modifier= Modifier
     .fillMaxSize()
     .padding(horizontal = 1.dp)
     .absolutePadding(top = 8.dp, right = 8.dp)*/


// )
fun Modifier.hover(onEnter: () -> Unit, onExit: () -> Unit): Modifier {
    // Logique de la méthode hover()
    return this
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn() {
        items(items)
        { item ->
            Box {
                // Utilisation d'une expression lambda dans run {}
                var (isHovered, setIsHovered) = run {
                    var isHovered by mutableStateOf(false)
                    Pair(isHovered, { value: Boolean -> isHovered = value })
                }
                Row(
                    modifier = Modifier
                        .background(color = if (isHovered) Color.Yellow else Color.Transparent)

                        .hover(
                            onEnter = {
                                isHovered = true
                                this.toString()
                            },
                            onExit = {
                                isHovered = false
                            }
                        )
                        .fillMaxWidth()
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(16.dp)
                )
                {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = item.title,
                        style = itemTextStyle,
                        modifier = Modifier.weight(1f)
                    )
                }

            }

        }
    }

}
@Composable
fun DrawerBody1(
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    Column(Modifier.padding(60.dp,50.dp)) {

    }
    LazyColumn(
        Modifier.fillMaxSize(),



        ) {
        items(items)
        { item ->
            Box {
                // Utilisation d'une expression lambda dans run {}
                val (isHovered, setIsHovered) = run {
                    var isHovered by mutableStateOf(false)
                    Pair(isHovered, { value: Boolean -> isHovered = value })
                }
                Row(
                    modifier = Modifier
                        .background(color = if (isHovered) Color.Black else Color.Transparent)

                        .hover(
                            onEnter = {
                                setIsHovered(true)
                                true
                            },
                            onExit = {
                                setIsHovered(false)
                                setIsHovered(false)
                                true
                            }
                        )
                        .fillMaxWidth()
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(16.dp)
                )
                {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = item.title,
                        style = itemTextStyle,
                        modifier = Modifier.weight(1f)
                    )
                }

            }

        }
    }

}
