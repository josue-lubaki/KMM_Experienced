package ca.josue_lubaki.kmmexperiments.presentation.lecture

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.kmmexperiments.data.mockup.customVideo
import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo
import ca.josue_lubaki.kmmexperiments.util.VideoPlayer
import ca.josue_lubaki.kmovies.android.ui.theme.Colors
import kotlinx.coroutines.delay

/**
 * created by Josue Lubaki
 * date : 2023-08-24
 * version : 1.0.0
 */

@Composable
fun LectureScreen(
    viewModel : LectureViewModel,
    modifier: Modifier = Modifier,
    movieId : Int
) {

    val movieVideo = remember { viewModel.movieVideo }
    val error = remember { viewModel.error }

    LaunchedEffect(Unit) {
        viewModel.loadMovieVideo(movieId)
    }

    LectureContent(
        movie = movieVideo.value,
        error = error.value,
        modifier = modifier,
    )
}

@Composable
fun LectureContent(
    movie: MovieVideo?,
    error : String?,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        movie?.let {
            VideoPlayer(
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f, false),
                url = customVideo(movie.key)
            )
        }

        error?.let {
            Text(
                text = error,
                style = MaterialTheme.typography.h6,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }

        if (movie == null && error == null) {
            CircularProgressIndicator(
                color = Color.Red,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}
