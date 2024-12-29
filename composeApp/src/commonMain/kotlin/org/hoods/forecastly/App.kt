package org.hoods.forecastly

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import forecastly.composeapp.generated.resources.Res
import forecastly.composeapp.generated.resources.compose_multiplatform
import org.hoods.forecastly.ui.components.getNavigationType
import org.hoods.forecastly.ui.home.HomeScreen

@Composable
@Preview
fun App(windowWidthSizeClass: WindowWidthSizeClass) {
    MaterialTheme {
        HomeScreen(
            navigationType = getNavigationType(windowWidthSizeClass)

        )
    }
}