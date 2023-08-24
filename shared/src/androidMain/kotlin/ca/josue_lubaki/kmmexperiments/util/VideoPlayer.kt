package ca.josue_lubaki.kmmexperiments.util

import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

/**
 * created by Josue Lubaki
 * date : 2023-08-01
 * version : 1.0.0
 */

@Composable
actual fun VideoPlayer(modifier: Modifier, url: String){
    AndroidView(
        modifier = modifier,
        factory = { context ->
            VideoView(context).apply {
                setVideoPath(url)
                setMediaController(null)
                setOnCompletionListener {
                    start()
                }
                start()
            }
        },
        update = {}
    )
}