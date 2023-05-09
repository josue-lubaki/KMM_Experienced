package ca.josue_lubaki.kmmexperiments.presentation.home

import ca.josue_lubaki.kmmexperiments.domain.model.Movie

data class HomeState(
    var loading: Boolean = false,
    var refreshing: Boolean = false,
    var movies: List<Movie> = listOf(),
    var errorMessage: String? = null,
    var loadFinished: Boolean = false,
)
