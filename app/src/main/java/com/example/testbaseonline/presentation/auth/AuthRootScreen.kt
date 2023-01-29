package com.example.testbaseonline.presentation.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testbaseonline.presentation.auth.registration.RegistrationScreen
import com.example.testbaseonline.presentation.auth.sign_in.SignInScreen
import com.example.testbaseonline.presentation.root.RootNavigationDestinations


object AuthNavigationDestinations {
    const val REGISTRATION = "registration"
    const val SIGN_IN = "sign_in"
}

@Composable
fun AuthNavigationGraph(
    rootNavController: NavHostController,
    authNavController: NavHostController
) {
    NavHost(
        navController = authNavController,
        route = RootNavigationDestinations.AUTH,
        startDestination = AuthNavigationDestinations.SIGN_IN
    ) {
        composable(AuthNavigationDestinations.SIGN_IN) {
            SignInScreen(
                rootNavController = rootNavController,
                authNavController = authNavController
            )
        }
        composable(AuthNavigationDestinations.REGISTRATION) {
            RegistrationScreen(
                rootNavController = rootNavController,
                authNavController = authNavController
            )
        }
    }
}

@Composable
fun AuthRootScreen(navController: NavHostController) {
    val authNavController = rememberNavController()

    Scaffold {
        Box(modifier = Modifier.padding(it)) {
            AuthNavigationGraph(
                rootNavController = navController,
                authNavController = authNavController
            )
        }
    }
}