package ca.josue_lubaki.kmmexperiments.data.repository

import ca.josue_lubaki.kmmexperiments.data.datasource.RemoteDataSource
import ca.josue_lubaki.kmmexperiments.data.datasourceimpl.RemoteDataSourceImpl
import ca.josue_lubaki.kmmexperiments.data.mapper.toDomain
import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo
import ca.josue_lubaki.kmmexperiments.domain.repository.MovieRepository
import ca.josue_lubaki.kmmexperiments.util.network.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : MovieRepository {

    override suspend fun getMovies(page: Int): Flow<DataState<List<Movie>>> = flow {
        emit(DataState.Loading)
        try {
            val result = remoteDataSource.getMovies(page).results.map {
                it.toDomain()
            }
            emit(DataState.Success(result))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }

    override suspend fun getMovie(id: Int): DataState<Movie> {
        return try {
            val result = remoteDataSource.getMovie(id).toDomain()
            DataState.Success(result)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }

    override suspend fun getMovieVideos(id: Int): DataState<MovieVideo> {
        return try {
            val result = remoteDataSource.getMovieVideos(id).toDomain()
            DataState.Success(result)
        } catch (e: Exception) {
            DataState.Error(e)
        }
    }
}