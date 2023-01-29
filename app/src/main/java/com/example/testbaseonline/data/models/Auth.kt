package com.example.testbaseonline.data.models

data class RegistrationResult(
    val success: Boolean = false,
    val errorMessage: String? = null
)

data class SignInResult(
    val success: Boolean = false,
    val errorMessage: String? = null
)