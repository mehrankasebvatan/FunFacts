package android.mkv.funfacts.ui

import android.mkv.funfacts.ui.screens.UserInputScreen
import android.mkv.funfacts.ui.screens.WelcomeScreen
import android.mkv.funfacts.viewmodels.UserInputViewModel
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.User_INPUT_SCREEN) {
        composable(Routes.User_INPUT_SCREEN) {
            UserInputScreen(navController, userInputViewModel)
        }
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(navController, userInputViewModel)
        }
    }
}

