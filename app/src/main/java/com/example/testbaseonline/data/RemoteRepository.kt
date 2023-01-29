package com.example.testbaseonline.data

import com.example.testbaseonline.data.models.RegistrationResult
import com.example.testbaseonline.data.models.SignInResult
import kotlinx.coroutines.delay
import javax.inject.Inject

interface RemoteRepository {
    suspend fun signIn(login: String, password: String): SignInResult
    suspend fun register(login: String, password: String): RegistrationResult
}

class RealRemoteRepository @Inject constructor() : RemoteRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        delay(1500)
        return SignInResult(success = true)
    }

    override suspend fun register(login: String, password: String): RegistrationResult {
        delay(1500)
        return RegistrationResult(success = true)
    }
}