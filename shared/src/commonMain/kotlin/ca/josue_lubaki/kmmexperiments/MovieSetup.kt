package ca.josue_lubaki.kmmexperiments


import Destination
import Detail
import Home
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ca.josue_lubaki.kmmexperiments.presentation.common.MovieAppBar
import ca.josue_lubaki.kmmexperiments.presentation.navigation.NavGraph
import ca.josue_lubaki.kmmexperiments.presentation.navigation.currentRoute
import moe.tlaster.precompose.navigation.Navigator

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

@Composable
fun MovieSetup(navigator: Navigator) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                title = Home.title,
                onNavigateBack = {
                    navigator.goBack()
                },
                iconVisible = navigator.currentRoute()?.route != Home.route
            )
        }
    ) { innerPaddings ->
        NavGraph(
            navigator = navigator,
            modifier = Modifier.padding(innerPaddings)
        )
    }
}