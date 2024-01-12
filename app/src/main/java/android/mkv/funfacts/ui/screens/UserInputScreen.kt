package android.mkv.funfacts.ui.screens

import android.mkv.funfacts.R
import android.mkv.funfacts.data.UserDataUiEvents
import android.mkv.funfacts.ui.AnimalCard
import android.mkv.funfacts.ui.ButtonComponent
import android.mkv.funfacts.ui.Routes
import android.mkv.funfacts.ui.TextComponent
import android.mkv.funfacts.ui.TextFieldComponent
import android.mkv.funfacts.ui.TopBar
import android.mkv.funfacts.viewmodels.UserInputViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun UserInputScreen(
    navController: NavHostController,
    userInputViewModel: UserInputViewModel,
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            TopBar("Hi there \uD83D\uDE0A")
            TextComponent(
                value = "Let's learn about You!",
                size = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(
                value = "This app will prepare a details page based on input provided by you!",
                size = 18.sp
            )

            Spacer(modifier = Modifier.height(60.dp))

            TextComponent(
                value = "Name",
                size = 18.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextFieldComponent(default = userInputViewModel.uiState.value.name, onTextEntered = {
                userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
            })

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(value = "What do you like?")

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceEvenly
            ) {


                AnimalCard(
                    R.drawable.dog,
                    userInputViewModel.uiState.value.animalSelected == "Dog",
                    onAnimalSelected = {
                        userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                    })
                AnimalCard(
                    R.drawable.cat,
                    userInputViewModel.uiState.value.animalSelected == "Cat",
                    onAnimalSelected = {
                        userInputViewModel.onEvent(UserDataUiEvents.AnimalSelected(it))
                    })
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.showButton()) ButtonComponent() {
                navController.navigate(Routes.WELCOME_SCREEN)
            }

        }
    }

}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(
        navController = rememberNavController(),
        userInputViewModel = viewModel()
    )
}