package com.example.testbaseonline.presentation.root

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testbaseonline.presentation.auth.AuthRootScreen
import com.example.testbaseonline.presentation.home.HomeRootScreen

object RootNavigationDestinations {
    const val AUTH = "auth"
    const val HOME = "home"
}

@Composable
fun SetupRootNavigation(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(RootNavigationDestinations.AUTH) {
            AuthRootScreen(navController = navController)
        }
        composable(RootNavigationDestinations.HOME) {
            HomeRootScreen(navController = navController)
        }
    }
}

@Composable
fun RootScreen(
    viewModel: RootViewModel = hiltViewModel()
) {
    SetupRootNavigation(
        startDestination = RootNavigationDestinations.AUTH
    )
}