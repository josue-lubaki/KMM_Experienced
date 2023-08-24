package ca.josue_lubaki.kmmexperiments.domain.model

data class MovieVideo(
    val id: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val site: String,
    val size: Int,
    val type: String
)
