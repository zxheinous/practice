package ci.nsu.mobile.main.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ci.nsu.mobile.main.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun login(
        login: String,
        password: String,
        onSuccess: () -> Unit
    ) {

        viewModelScope.launch {

            isLoading = true

            val result = repository.login(
                login,
                password
            )

            isLoading = false

            result.onSuccess {
                onSuccess()
            }

            result.onFailure {
                error = it.message
            }
        }
    }
}