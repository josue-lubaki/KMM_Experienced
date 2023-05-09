package ca.josue_lubaki.kmmexperiments.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieApiResponse(
    val results: List<MovieRemote>,
)
