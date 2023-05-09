package ca.josue_lubaki.kmmexperiments.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterImage: String,
    val releaseDate: String,
)
