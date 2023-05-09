package ca.josue_lubaki.kmmexperiments.data.datasourceimpl

import ca.josue_lubaki.kmmexperiments.data.api.MovieService
import ca.josue_lubaki.kmmexperiments.data.datasource.RemoteDataSource
import ca.josue_lubaki.kmmexperiments.data.model.MovieApiResponse
import ca.josue_lubaki.kmmexperiments.data.model.MovieRemote
import io.ktor.util.logging.Logger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
//import ca.josue_lubaki.kmmexperiments.util.Dispatcher
import kotlinx.coroutines.withContext

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal class RemoteDataSourceImpl(
    private val movieService: MovieService = MovieService()
) : RemoteDataSource {

    override suspend fun getMovie(id: Int): MovieRemote {
        return withContext(Dispatchers.Main) {
            movieService.getMovie(id)
        }
    }

    override suspend fun getMovies(page: Int): MovieApiResponse {
        return withContext(Dispatchers.Main) {
            movieService.getMovies(page)
        }
    }
}