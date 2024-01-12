package android.mkv.funfacts.ui

import android.mkv.funfacts.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun TopBar(value: String = "Hello world!") {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TextComponent(
    value: String = "Hello world!",
    size: TextUnit = 16.sp,
    weight: FontWeight = FontWeight.Light
) {
    Text(
        text = value,
        fontSize = size,
        fontWeight = weight,
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponent(default: String = "", onTextEntered: (String) -> Unit = {}) {
    var currentValue by remember {
        mutableStateOf(default)
    }
    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = currentValue,
        onValueChange = { changedValue ->
            currentValue = changedValue
            onTextEntered.invoke(changedValue)
        },
        placeholder = {
            Text(text = "Enter your name...", fontSize = 16.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }

    )
}

@Preview(showBackground = true)
@Composable
fun AnimalCard(
    image: Int = R.drawable.cat,
    selected: Boolean = false,
    onAnimalSelected: (String) -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(120.dp)
            .clickable {
                val animalName = if (image == R.drawable.cat) "Cat" else "Dog"
                onAnimalSelected.invoke(animalName)
            },
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                painter = painterResource(id = image),
                contentScale = ContentScale.Fit,
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonComponent(
    goToDetailsScreen: () -> Unit = {}
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToDetailsScreen()
        }) {
        Text(
            text = "Go to details screen",
            fontSize = 18.sp,
            modifier = Modifier.padding(10.dp)
        )

    }
}