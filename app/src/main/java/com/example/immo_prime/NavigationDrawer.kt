package com.example.immo_prime

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable

fun NavigationDrawer(

    name:String,
    email:String,
    items: List<MenuItem>,
    AvatarUrl: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(vertical = 48.dp)




    )

    {

        Image(painter = rememberImagePainter(data= AvatarUrl ) ,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .height(250.dp)

            //.background(shape =Purple500)
        )
        Text(text = name)
        Text(text = email)
        Divider()
        items.forEach{
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }
                .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically






            ) {
                Icon(imageVector = it.icon, contentDescription =it.title )
                Spacer(modifier = Modifier.width(32.dp))
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = it.title)
            }



            // Text(text = "yvana@gmail.com", fontSize = 20.sp)

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
}
@Composable
fun DrawerBody(
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
)
{
    LazyColumn(){
        items(items)
        {
                item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            )
            {
                Icon(imageVector = item.icon,
                    contentDescription= item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style= itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}