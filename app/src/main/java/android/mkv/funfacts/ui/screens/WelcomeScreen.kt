package android.mkv.funfacts.ui.screens

import android.mkv.funfacts.ui.TextComponent
import android.mkv.funfacts.ui.TopBar
import android.mkv.funfacts.viewmodels.UserInputViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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

@Preview(showBackground = true)
@Composable
fun WelcomeScreen(
    navController: NavHostController = rememberNavController(),
    userInputViewModel: UserInputViewModel = viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {

            TopBar(value = "Welcome ${userInputViewModel.uiState.value.name}")
            Spacer(modifier = Modifier.height(5.dp))

            TextComponent(value = "Thank you! for sharing your data", size = 24.sp)

            Spacer(modifier = Modifier.height(60.dp))
            val emoji =
                if (userInputViewModel.uiState.value.animalSelected == "Dog") "\uD83D\uDC36" else "\uD83D\uDC31"

            TextComponent(value = "You are a ${userInputViewModel.uiState.value.animalSelected} lover! $emoji",
                size = 24.sp)

        }


    }
}

