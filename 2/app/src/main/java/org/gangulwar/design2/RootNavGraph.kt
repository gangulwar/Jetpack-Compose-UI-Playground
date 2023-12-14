package org.gangulwar.design2

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Screen.Host.route,
        startDestination = Screen.LogIn.route
    ) {
        composable(route = Screen.LogIn.route) {
            LoginScreen(navController) {
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route){
                        inclusive=true
                    }
                }
            }
        }
        composable(route = Screen.Home.route) {
            Home(navController){
              //navController.navigate()
            }
        }
    }
}

sealed class Screen(var route: String) {
    object LogIn : Screen("login")
    object Home : Screen("home")
    object Info : Screen("info")
    object Host:Screen("Host")
}