package com.example.immo_prime.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bathroom
import androidx.compose.material.icons.rounded.SingleBed
import androidx.compose.material.icons.rounded.SquareFoot
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.immo_prime.R
import com.example.immo_prime.Utility.Logement
import com.example.immo_prime.ui.theme.BorderCardImo
import com.example.immo_prime.ui.theme.DarkBlueImo
import com.example.immo_prime.ui.theme.DarkGrayImo

@Composable
fun CardLogement(
    logement: Logement
){
    Column(
        modifier = Modifier
            .height(250.dp)
            .width(200.dp)
            .border(1.dp, BorderCardImo, RoundedCornerShape(10.dp))
            .background(DarkGrayImo, RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = R.drawable.house5),
            contentDescription = null,
            modifier = Modifier
                .height(149.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row (
            modifier = Modifier.padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_square_box),
                contentDescription = null,
                tint = DarkBlueImo
            )
            Text(
                text = logement.type,
                fontSize = 7.sp,
                modifier = Modifier.padding(start = 3.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
                ){
            Text(
                text = "${logement.price} Fcfa"
            )
            Image(
                painter = painterResource(id = R.drawable.ic_for_sale_3),
                contentDescription = null,
                modifier = Modifier.size(17.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = logement.description,
            fontSize = 9.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
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
                    modifier = Modifier.size(7.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Bathroom,
                        contentDescription = stringResource(id = R.string.back_icon),
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "${logement.nbreDouche}ba",
                    fontSize = 7.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier.size(7.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.SingleBed,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "${logement.nbreChambre}ba",
                    fontSize = 7.sp
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {  },
                    modifier = Modifier.size(7.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.SquareFoot,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "${logement.superficie}sqft",
                    fontSize = 7.sp
                )
            }
        }
    }
    Spacer(modifier = Modifier.width(10.dp))
}

@Preview(showBackground = true)
@Composable
fun CardLogementPreview(){
    CardLogement(logement = Logement(1,"Appartement", 50000.0,"Rue des palmier Nkolmesseng-Yaounde\n" +
            "A 100m de Cyntiche Lounge", painterResource(id = R.drawable.house4), 2, 2, 900.0)
    )
}