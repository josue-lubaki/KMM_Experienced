package ca.josue_lubaki.kmmexperiments.presentation.lecture

import androidx.compose.runtime.mutableStateOf
import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo
import ca.josue_lubaki.kmmexperiments.domain.usecases.GetMovieVideoUseCase
import ca.josue_lubaki.kmmexperiments.presentation.detail.DetailState
import ca.josue_lubaki.kmmexperiments.util.network.DataState
import kotlinx.coroutines.CoroutineDispatcher
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
 * date : 2023-08-24
 * version : 1.0.0
 */

class LectureViewModel : ViewModel(), KoinComponent {

    private val getMovieVideoUseCase by inject<GetMovieVideoUseCase>()
    private val dispatcher : CoroutineDispatcher by inject()
    val movieVideo = mutableStateOf<MovieVideo?>(null)
    val error = mutableStateOf<String?>(null)

    fun loadMovieVideo(id: Int) {
        viewModelScope.launch(dispatcher){
            when(val result = getMovieVideoUseCase(id)){
                is DataState.Success -> {
                    movieVideo.value = result.data
                }
                is DataState.Error -> {
                    error.value = result.exception.message
                }
                else -> {
                    error.value = null
                }
            }
        }
    }
}