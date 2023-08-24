package ca.josue_lubaki.kmmexperiments.presentation.lecture

import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo

/**
 * created by Josue Lubaki
 * date : 2023-08-24
 * version : 1.0.0
 */

data class LectureState(
    var movie: MovieVideo? = null,
    var errorMessage: String? = null,
    var isLoading: Boolean = false,
)