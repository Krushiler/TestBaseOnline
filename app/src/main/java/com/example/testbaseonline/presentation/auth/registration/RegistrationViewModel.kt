package com.example.testbaseonline.presentation.auth.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testbaseonline.data.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationViewState())
    val state: StateFlow<RegistrationViewState>
        get() = _state

    fun register(login: String, password: String) {
        viewModelScope.launch {
            _state.emit(
                RegistrationViewState(
                    loading = true
                )
            )
            val registerResult = remoteRepository.register(login, password)
            _state.emit(
                RegistrationViewState(
                    success = registerResult.success
                )
            )
        }
    }
}

data class RegistrationViewState(
    val loading: Boolean = false,
    val success: Boolean = false
)

sealed class RegistrationViewEffect {
    data class ShowError(val message: String) : RegistrationViewEffect()
}