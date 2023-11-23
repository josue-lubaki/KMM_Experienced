package ca.josue_lubaki.kmmexperiments.presentation.detail

import androidx.compose.runtime.mutableStateOf
import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMovieUseCase
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMoviesUseCase
import ca.josue_lubaki.kmmexperiments.util.network.DataState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * created by Josue Lubaki
 * date : 2023-05-02
 * version : 1.0.0
 */

class DetailViewModel : ViewModel(), KoinComponent {

    private val getMovieUseCase: GetMovieUseCase by inject()
    private val dispatchers : CoroutineDispatcher by inject()

    private var _state = MutableStateFlow<DetailState>(DetailState.Idle)
    val state: StateFlow<DetailState> = _state.asStateFlow()
    val movieDetails = mutableStateOf<Movie?>(null)

    fun loadMovie(movieId: Int) {
        _state.value = DetailState.Loading
        viewModelScope.launch(dispatchers) {
            when(val result = getMovieUseCase(movieId)){
                is DataState.Error -> {
                    _state.value = DetailState.Error(
                        errorMessage = result.exception.message,
                    )
                }
                is DataState.Loading -> {
                    _state.value = DetailState.Loading
                }
                is DataState.Success -> {
                    movieDetails.value = result.data
                    println("xxxx : ${result.data}")
                    _state.value = DetailState.Success(
                        movie = result.data
                    )
                }
            }
        }
    }
}