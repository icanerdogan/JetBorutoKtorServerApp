package com.ibrahimcanerdogan.jetboruto.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.ibrahimcanerdogan.jetboruto.presentation.screens.details.DetailsScreen
import com.ibrahimcanerdogan.jetboruto.presentation.screens.home.HomeScreen
import com.ibrahimcanerdogan.jetboruto.presentation.screens.search.SearchScreen
import com.ibrahimcanerdogan.jetboruto.presentation.screens.welcome.WelcomeScreen
import com.ibrahimcanerdogan.jetboruto.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController = navController)
        }
    }
}