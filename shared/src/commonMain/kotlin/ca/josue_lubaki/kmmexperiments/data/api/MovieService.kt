package ca.josue_lubaki.kmmexperiments.data.api

import ca.josue_lubaki.kmmexperiments.data.model.MovieApiResponse
import ca.josue_lubaki.kmmexperiments.data.model.MovieRemote
import ca.josue_lubaki.kmmexperiments.data.model.MovieVideoResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.delay

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal class MovieService : KtorApi() {
    suspend fun getMovies(page: Int = 1) : MovieApiResponse = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(id: Int) : MovieRemote = client.get {
        pathUrl("movie/$id")
    }.body()

    suspend fun getMovieVideos(id: Int) : MovieVideoResponse = client.get {
        delay(1000)
        pathUrl("movie/$id/videos")
    }.body()
}