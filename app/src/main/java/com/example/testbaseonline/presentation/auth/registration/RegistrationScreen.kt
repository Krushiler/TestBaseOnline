package com.example.testbaseonline.presentation.auth.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.testbaseonline.presentation.auth.AuthNavigationDestinations
import com.example.testbaseonline.presentation.root.RootNavigationDestinations
import com.example.testbaseonline.ui.views.PasswordField

@Composable
fun RegistrationScreen(
    rootNavController: NavController,
    authNavController: NavController,
    viewModel: RegistrationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    var loginText by rememberSaveable {
        mutableStateOf("")
    }
    var passwordText by rememberSaveable {
        mutableStateOf("")
    }

    if (state.success) {
        rootNavController.navigate(RootNavigationDestinations.HOME) {
            popUpTo(0)
        }
    }

    Scaffold { padding ->
        if (state.loading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = loginText,
                onValueChange = { loginText = it },
                label = { Text(text = "Login") }
            )
            Spacer(modifier = Modifier.height(32.dp))
            PasswordField(
                value = passwordText,
                onValueChange = { passwordText = it },
                label = { Text(text = "Password") },
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = {
                viewModel.register(
                    login = loginText,
                    password = passwordText
                )
            }) {
                Text(text = "Register")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = {
                authNavController.navigate(AuthNavigationDestinations.SIGN_IN)
            }) {
                Text(text = "Sign in")
            }
        }
    }
}