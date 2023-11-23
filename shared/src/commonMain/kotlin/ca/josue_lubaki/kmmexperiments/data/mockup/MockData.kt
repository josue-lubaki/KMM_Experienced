package ca.josue_lubaki.kmmexperiments.data.mockup

/**
 * created by Josue Lubaki
 * date : 2023-08-24
 * version : 1.0.0
 */

fun customVideo(key : String) : String {
    return when (key) {
        "_JUxMulBL38" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/Elemental+_+Our+Blue+Flame.mp4"
        "2CRR_yWYO0c" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/Heart+of+Stone+_+Blooper+Reel+_+Netflix.mp4"
        "ijvjAzPPafA" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/SPIDER-MAN_+ACROSS+THE+SPIDER-VERSE+%E2%80%93+Live+Your+Truth.mp4"
        "2-u1H4DEoNI" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/Don't+miss+_the+best+Transformers+movie+yet._.mp4"
        "h_y8-295IB8", "_s0EOTN1XfU" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/Barbie+_+Blow+My+Mind+_+Now+Playing.mp4"
        "8YV2hzjGjJw" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/THE+FLASH+-+FINAL+TRAILER.mp4"
        "UhS-GJRPhw8", "GwRDWsIIlI0" -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/Meg+2_+The+Trench+-+Magic+-+Warner+Bros.+UK+%26+Ireland.mp4"
        else -> "https://movies-youtube.s3.ca-central-1.amazonaws.com/tmdb/Youtube+Logo+Animation.mp4"
    }
}