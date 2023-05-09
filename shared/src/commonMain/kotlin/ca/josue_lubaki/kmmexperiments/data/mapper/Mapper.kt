package ca.josue_lubaki.kmmexperiments.data.mapper

import ca.josue_lubaki.kmmexperiments.data.model.MovieRemote
import ca.josue_lubaki.kmmexperiments.domain.model.Movie

/**
 * created by Josue Lubaki
 * date : 2023-04-27
 * version : 1.0.0
 */

internal fun MovieRemote.toDomain() : Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterImage = getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImage: String): String = "https://image.tmdb.org/t/p/w500/$posterImage"
