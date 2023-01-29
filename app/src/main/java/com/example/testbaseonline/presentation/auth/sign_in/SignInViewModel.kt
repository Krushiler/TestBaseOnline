package com.example.testbaseonline.presentation.auth.sign_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testbaseonline.data.RemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SignInViewState())
    val state: StateFlow<SignInViewState>
        get() = _state

    fun signIn(login: String, password: String) {
        viewModelScope.launch {
            _state.emit(
                SignInViewState(
                    loading = true
                )
            )
            val signInResult = remoteRepository.signIn(login, password)
            _state.emit(
                SignInViewState(
                    success = signInResult.success
                )
            )
        }
    }
}

data class SignInViewState(
    val loading: Boolean = false,
    val success: Boolean = false
)

sealed class SignInViewEffect {
    data class ShowError(val message: String) : SignInViewEffect()
}