package com.ibrahimcanerdogan.jetboruto.presentation.screens.home

import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ibrahimcanerdogan.jetboruto.ui.theme.topAppBarContentColor
import com.ibrahimcanerdogan.jetboruto.R
import com.ibrahimcanerdogan.jetboruto.ui.theme.revTopAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Boruto",
                color = topAppBarContentColor
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = revTopAppBarContentColor
        ),
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        }
    )
}


@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar {}
}
