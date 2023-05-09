package ca.josue_lubaki.kmmexperiments


import Detail
import Home
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMovieUseCase
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMoviesUseCase
import ca.josue_lubaki.kmmexperiments.presentation.common.MovieAppBar
import ca.josue_lubaki.kmmexperiments.presentation.detail.DetailScreen
import ca.josue_lubaki.kmmexperiments.presentation.detail.DetailViewModel
import ca.josue_lubaki.kmmexperiments.presentation.home.HomeScreen
import ca.josue_lubaki.kmmexperiments.presentation.home.HomeViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.ViewModel
import moviesDestination

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

@Composable
fun MovieSetup(
    navigator: Navigator
) {
//    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()

    val isSystemDark= isSystemInDarkTheme()
    val statusBarColor = if (isSystemDark) {
        MaterialTheme.colors.primaryVariant
    } else {
        Color.Transparent
    }

//    SideEffect {
//        systemUiController.setStatusBarColor(
//            color = statusBarColor,
//            darkIcons = !isSystemDark
//        )
//    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                title = "Movies",
                onNavigateBack = {
                    navigator.goBack()
                }
            )
        }
    ) { innerPaddings ->
        NavHost(
            navigator = navigator,
            initialRoute = Home.route,
            modifier = Modifier.padding(innerPaddings)
        ){
            scene(route = Home.route) {
                val homeViewModel = HomeViewModel()
                HomeScreen(
                    viewModel = homeViewModel,
                    navigateToDetails = { movie ->
                        navigator.navigate("${Detail.route}/${movie.id}")
                    }
                )
            }

            scene(route = "${Detail.route}/{movieId}") {
                val movieId: Int = it.path<Int>("movieId") ?: 0
                val detailViewModel = DetailViewModel()
                DetailScreen(
                    viewModel = detailViewModel,
                    movieId = movieId
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun MovieAppPreview() {
//    MovieSetup()
//}
