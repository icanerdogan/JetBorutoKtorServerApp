package com.ibrahimcanerdogan.jetboruto.presentation.screens.home

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.ibrahimcanerdogan.jetboruto.navigation.Screen
import com.ibrahimcanerdogan.jetboruto.presentation.common.ListContent
import com.ibrahimcanerdogan.jetboruto.ui.theme.statusBarColor
import com.ibrahimcanerdogan.jetboruto.ui.theme.topAppBarContentColor

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as Activity
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    val systemBarColor = statusBarColor.toArgb()

    SideEffect { activity.window.statusBarColor = systemBarColor }

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navController.navigate(Screen.Search.route)
                }
            )
        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier.fillMaxSize()
                .padding(contentPadding)
                .background(topAppBarContentColor)
        ) {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    }
}