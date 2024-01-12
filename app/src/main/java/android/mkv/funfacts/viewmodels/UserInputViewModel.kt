package android.mkv.funfacts.viewmodels

import android.mkv.funfacts.data.UserDataUiEvents
import android.mkv.funfacts.data.UserInputScreenState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())


    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    name = event.name
                )
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalName
                )
            }
        }
    }

    fun showButton(): Boolean =
        uiState.value.name.isNotEmpty() && uiState.value.animalSelected.isNotEmpty()


}


