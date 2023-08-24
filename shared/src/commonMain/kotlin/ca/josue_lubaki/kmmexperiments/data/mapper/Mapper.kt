package ca.josue_lubaki.kmmexperiments.data.mapper

import ca.josue_lubaki.kmmexperiments.data.model.MovieRemote
import ca.josue_lubaki.kmmexperiments.data.model.MovieVideoResponse
import ca.josue_lubaki.kmmexperiments.domain.model.Movie
import ca.josue_lubaki.kmmexperiments.domain.model.MovieVideo

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

internal fun MovieVideoResponse.toDomain() : MovieVideo {
    val video = this.results.first()
    return MovieVideo(
        id = video.id,
        key = video.key,
        name = video.name,
        official = video.official,
        site = video.site,
        size = video.size,
        type = video.type
    )
}

private fun getImageUrl(posterImage: String): String = "https://image.tmdb.org/t/p/w500/$posterImage"
