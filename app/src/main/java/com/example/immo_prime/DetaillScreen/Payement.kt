package com.example.immo_prime.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.immo_prime.R



@Composable
fun Payement(){
       Column(
           modifier = Modifier
               .verticalScroll(rememberScrollState())
               .fillMaxSize()
       ){
           Header()
           MyScreenContent()
           My2ScreenContent()
           //NextButton()
           PaymentMethods()
           ThreeImageButtons()
       }
}
@Composable
fun Header(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(horizontal = 50.dp, vertical = 8.dp)
        ) {
            Button(onClick = { /*TODO*/ },
                shape = CircleShape,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Transparent)) {
                Icon(Icons.Filled.Close, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
            }

        }
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                text = "Entrer vos informations de payement pour pouvoir consulter les détails de logements qui coute ",
                color = Color.Gray,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "1000FCFA",
                color=  Color.Blue,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

    }


}
@Composable
fun TextFieldWithIcon(icon: ImageVector, label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        leadingIcon = { Icon(imageVector = icon, contentDescription = null) },
        visualTransformation = if (label == "Mot de passe") PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Composable
fun MyScreenContent() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(Modifier.padding(horizontal = 50.dp, vertical = 10.dp)) {
        TextFieldWithIcon(Icons.Filled.AccountCircle, "Nom d'utilisateur", username) {
            username = it

        }
        TextFieldWithIcon(Icons.Filled.Lock, "Mot de passe", password) {
            password = it
        }
    }
}

@Composable
fun TextfieldWithBottomBorder(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, style = MaterialTheme.typography.subtitle1)
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.border(
                BorderStroke(0.dp, Color.Transparent),
                RoundedCornerShape(0.dp, 0.dp, 4.dp, 4.dp)
            ),
            textStyle = MaterialTheme.typography.body1,
            placeholder = { Text(text = label) }
        )
    }
}

@Composable
fun My2ScreenContent() {
    var cardNumber by remember { mutableStateOf("") }
    var securityCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 30.dp)
            .fillMaxWidth()
    ) {
        TextfieldWithBottomBorder(
            label = "Card Number",
            value = cardNumber,
            onValueChange = { cardNumber = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextfieldWithBottomBorder(
            label = "Code de sécurité",
            value = securityCode,
            onValueChange = { securityCode = it }
        )
    }
}

/*@Composable
fun DateInput(onDateSelected: (LocalDate) -> Unit) {
    var dateText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Date d'expiration",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        TextField(
            value = dateText,
            onValueChange = { text ->
                // Format the text as a date (e.g. "DD/MM/YYYY")
                val formattedText = formatAsDate(text)
                dateText = formattedText

                // Parse the formatted text as a LocalDate
                val date = parseDate(formattedText)
                if (date != null) {
                    onDateSelected(date)
                }
            },
            visualTransformation = DateVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { /* Hide the keyboard */ }),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

private fun formatAsDate(text: String): String {
    // TODO: Implement date formatting logic
    return text
}

private fun parseDate(text: String): LocalDate? {
    // TODO: Implement date parsing logic
    return null
}

private class DateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmedText = text.text.trim()

        val newText = buildAnnotatedString {
            if (trimmedText.length >= 2) {
                append(trimmedText.substring(0, 2))
                append("/")
            }
            if (trimmedText.length >= 4) {
                append(trimmedText.substring(2, 4))
                append("/")
            }
            if (trimmedText.length >= 8) {
                append(trimmedText.substring(4, 8))
            }
        }

        val cursorPosition = newText.text.count { it == '/' } + minOf(2, newText.text.length)
        return TransformedText(newText, OffsetMapping { offset ->
            var transformedOffset = offset
            var originalOffset = 0

            while (originalOffset < trimmedText.length && transformedOffset > 0) {
                if (trimmedText[originalOffset] == '/') {
                    transformedOffset--
                }
                originalOffset++
            }

            transformedOffset
        }, cursorPosition)
    }
}*/

@Composable
fun NextButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Suivant", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PaymentMethods() {
    Text(
        "Autres moyens de paiement",
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ThreeImageButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ImageButton(
            image = painterResource(R.drawable.paypal),
            onClick = { /* handle button click */ }
        )
        ImageButton(
            image = painterResource(R.drawable.visa),
            onClick = { /* handle button click */ }
        )
        ImageButton(
            image = painterResource(R.drawable.master),
            onClick = { /* handle button click */ }
        )
    }
}

@Composable
fun ImageButton(image: Painter, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .size(64.dp)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InterfacePayement(){
    Payement()
}