package ca.josue_lubaki.kmmexperiments.domain.usecases

import ca.josue_lubaki.kmmexperiments.data.repository.MovieRepositoryImpl
import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import ca.josue_lubaki.kmmexperiments.domain.repository.MovieRepository
import ca.josue_lubaki.kmmexperiments.util.network.DataState
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

class GetMovieUseCase : KoinComponent {
    private val movieRepositoryImpl by inject<MovieRepository>()

    @Throws(Exception::class)
    suspend operator fun invoke(id: Int) : DataState<Movie> = movieRepositoryImpl.getMovie(id)
}
