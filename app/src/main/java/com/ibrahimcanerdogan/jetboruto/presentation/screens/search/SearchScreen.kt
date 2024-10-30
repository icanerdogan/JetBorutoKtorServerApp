package com.ibrahimcanerdogan.jetboruto.presentation.screens.search

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.ibrahimcanerdogan.jetboruto.presentation.common.ListContent
import com.ibrahimcanerdogan.jetboruto.ui.theme.statusBarColor
import com.ibrahimcanerdogan.jetboruto.ui.theme.topAppBarBackgroundColor
import com.ibrahimcanerdogan.jetboruto.ui.theme.topAppBarContentColor

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as Activity
    val searchQuery = searchViewModel.searchQuery
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()
    val systemBarColor = statusBarColor.toArgb()
    val keyboardController = LocalSoftwareKeyboardController.current

    SideEffect { activity.window.statusBarColor = systemBarColor }

    Scaffold(
        topBar = {
            SearchTopBar(
                stateText = searchQuery,
                onTextChange = {
                    searchViewModel.searchHeroes(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                    keyboardController?.hide()
                }
            )
        }
    ) { contentPadding ->
        Surface(
            modifier = Modifier.fillMaxSize().padding(contentPadding),
            color = topAppBarBackgroundColor
        ) {
            ListContent(heroes = heroes, navController = navController)
        }
    }
}