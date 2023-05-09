package ca.josue_lubaki.kmmexperiments

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.rememberNavigator

/**
 * created by Josue Lubaki
 * date : 2023-05-05
 * version : 1.0.0
 */

@Composable
internal fun App() {
    val navigator = rememberNavigator()
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MovieSetup(navigator)
        }
    }
}