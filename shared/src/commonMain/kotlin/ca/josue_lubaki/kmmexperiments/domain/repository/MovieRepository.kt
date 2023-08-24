package ca.josue_lubaki.kmmexperiments.domain.repository

import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo
import ca.josue_lubaki.kmmexperiments.util.network.DataState
import kotlinx.coroutines.flow.Flow

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal interface MovieRepository {
    suspend fun getMovies(page: Int = 1) : Flow<DataState<List<Movie>>>
    suspend fun getMovie(id: Int) : DataState<Movie>
    suspend fun getMovieVideos(id: Int) : DataState<MovieVideo>
}