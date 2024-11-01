package com.ibrahimcanerdogan.jetboruto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val statusBarColor
    @Composable
    get() = Color.Black

val welcomeScreenBackgroundColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.Black

val titleColor
    @Composable
    get() = if (!isSystemInDarkTheme()) DarkGray else LightGray

val descriptionColor
    @Composable
    get() = if (!isSystemInDarkTheme()) DarkGray.copy(alpha = 0.5f)
    else LightGray.copy(alpha = 0.5f)

val activeIndicatorColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple500 else Purple700

val inactiveIndicatorColor
    @Composable
    get() = if (!isSystemInDarkTheme()) LightGray else DarkGray

val buttonBackgroundColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Purple500 else Purple700

val topAppBarContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.Gray else Color.White

val revTopAppBarContentColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.Black

val topAppBarBackgroundColor: Color
    @Composable
    get() = Color.Transparent
    // get() = if (!isSystemInDarkTheme()) Purple500 else Color.Black