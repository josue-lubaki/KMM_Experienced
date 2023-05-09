package ca.josue_lubaki.kmmexperiments.presentation.detail

import ca.josue_lubaki.kmmexperiments.domain.model.Movie

sealed class DetailState {
    object Idle: DetailState()
    object Loading: DetailState()
    data class Success(val movie: Movie): DetailState()
    data class Error(val errorMessage: String?): DetailState()
}