package ca.josue_lubaki.kmmexperiments.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieVideoResponse(
    val id: Int,
    val results: List<MovieVideoContent>
)

@Serializable
data class MovieVideoContent(
    val id: String,
    val iso_3166_1: String,
    val iso_639_1: String,
    val key: String,
    val name: String,
    val official: Boolean,
    val published_at: String,
    val site: String,
    val size: Int,
    val type: String
)