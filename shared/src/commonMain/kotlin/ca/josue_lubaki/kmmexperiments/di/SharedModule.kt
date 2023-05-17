package ca.josue_lubaki.kmmexperiments.di

import ca.josue_lubaki.kmmexperiments.data.api.MovieService
import ca.josue_lubaki.kmmexperiments.data.datasource.RemoteDataSource
import ca.josue_lubaki.kmmexperiments.data.datasourceimpl.RemoteDataSourceImpl
import ca.josue_lubaki.kmmexperiments.data.repository.MovieRepositoryImpl
import ca.josue_lubaki.kmmexperiments.domain.repository.MovieRepository
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMovieUseCase
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMoviesUseCase
import ca.josue_lubaki.kmmexperiments.util.provideDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.dsl.module

/**
 * created by Josue Lubaki
 * date : 2023-05-16
 * version : 1.0.0
 */

private val dataModule = module {
    factory { MovieService() }
    factory<RemoteDataSource> { RemoteDataSourceImpl(get(), get()) }
}

private val utilityModule = module {
    factory<CoroutineDispatcher> { provideDispatcher().dispatcher }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }

    single { GetMoviesUseCase() }
    single { GetMovieUseCase() }
}

private val _sharedModule = listOf(dataModule, utilityModule, domainModule)

fun getSharedModule() = _sharedModule
