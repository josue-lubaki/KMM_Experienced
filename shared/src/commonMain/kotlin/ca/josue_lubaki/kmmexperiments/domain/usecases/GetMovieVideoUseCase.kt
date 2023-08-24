package ca.josue_lubaki.kmmexperiments.domain.usecases

import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo
import ca.josue_lubaki.kmmexperiments.domain.repository.MovieRepository
import ca.josue_lubaki.kmmexperiments.util.network.DataState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * created by Josue Lubaki
 * date : 2023-08-24
 * version : 1.0.0
 */

class GetMovieVideoUseCase : KoinComponent {
    private val movieRepositoryImpl by inject<MovieRepository>()

    @Throws(Exception::class)
    suspend operator fun invoke(id: Int) : DataState<MovieVideo> = movieRepositoryImpl.getMovieVideos(id)
}