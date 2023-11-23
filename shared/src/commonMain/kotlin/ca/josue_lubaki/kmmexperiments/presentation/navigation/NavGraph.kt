package ca.josue_lubaki.kmmexperiments.presentation.navigation

import Detail
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import ca.josue_lubaki.kmmexperiments.presentation.detail.DetailScreen
import ca.josue_lubaki.kmmexperiments.presentation.detail.DetailViewModel
import ca.josue_lubaki.kmmexperiments.presentation.home.HomeScreen
import ca.josue_lubaki.kmmexperiments.presentation.home.HomeViewModel
import ca.josue_lubaki.kmmexperiments.presentation.lecture.LectureScreen
import ca.josue_lubaki.kmmexperiments.presentation.lecture.LectureViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.route.Route
import moe.tlaster.precompose.navigation.transition.NavTransition

/**
 * created by Josue Lubaki
 * date : 2023-05-10
 * version : 1.0.0
 */

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navigator : Navigator
) {
    NavHost(
        navigator = navigator,
        initialRoute = Home.route,
        modifier = modifier,
        navTransition = NavTransition(
            createTransition = fadeIn(animationSpec = tween(200, delayMillis = 90)),
            destroyTransition = fadeOut(animationSpec = tween(200)),
        )
    ){
        scene(route = Home.route) {
            val homeViewModel = HomeViewModel()
            HomeScreen(
                viewModel = homeViewModel,
                navigateToDetails = { movie ->
                    navigator.navigate("${Detail.route}/${movie.id}")
                },
            )
        }

        scene(route = Detail.routeWithArgs) {
            val movieId: Int = it.path<Int>(Detail.argsName) ?: 0
            val detailViewModel = DetailViewModel()
            DetailScreen(
                viewModel = detailViewModel,
                movieId = movieId,
                onNavigateToLecture = { id : Int ->
                    navigator.navigate("${Lecture.route}/${id}")
                }
            )
        }

        scene(route = Lecture.routeWithArgs) {
            val movieId: Int = it.path<Int>(Lecture.argsName) ?: 0
            val lectureViewModel = LectureViewModel()
            LectureScreen(
                viewModel = lectureViewModel,
                movieId = movieId,
                navigator = navigator
            )
        }
    }
}

@Composable
fun Navigator.currentRoute(): Route? {
    return currentEntry.collectAsState(null).value?.route
}