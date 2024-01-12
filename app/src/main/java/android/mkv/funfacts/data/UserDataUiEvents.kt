package android.mkv.funfacts.data

sealed class UserDataUiEvents {

    data class UserNameEntered(var name: String) : UserDataUiEvents()
    data class AnimalSelected(var animalName: String) : UserDataUiEvents()

}