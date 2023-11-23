package ca.josue_lubaki.kmmexperiments.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.CValue
import kotlinx.cinterop.readValue
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItemDidPlayToEndTimeNotification
import platform.AVFoundation.AVPlayerLayer
import platform.AVFoundation.pause
import platform.AVFoundation.play
import platform.AVFoundation.seekToTime
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRect
import platform.CoreMedia.kCMTimeZero
import platform.Foundation.NSNotificationCenter
import platform.Foundation.NSURL
import platform.QuartzCore.CATransaction
import platform.QuartzCore.kCATransactionDisableActions
import platform.UIKit.UIView

/**
 * created by Josue Lubaki
 * date : 2023-08-01
 * version : 1.0.0
 */

@Composable
actual fun VideoPlayer(modifier: Modifier, url: String, onCompleted: () -> Unit) {
    val player = remember { AVPlayer(uRL = NSURL.URLWithString(url)!!) }
    val playerLayer = remember { AVPlayerLayer() }
    val avPlayerViewController = remember { AVPlayerViewController() }
    avPlayerViewController.player = player
    avPlayerViewController.showsPlaybackControls = false

    playerLayer.player = player

    // Use a UIKitView to integrate with your existing UIKit views
    UIKitView(
        factory = {
            // Create a UIView to hold the AVPlayerLayer
            val playerContainer = UIView()
            playerContainer.addSubview(avPlayerViewController.view)
            // Return the playerContainer as the root UIView
            playerContainer
        },
        onResize = { view: UIView, rect: CValue<CGRect> ->
            CATransaction.begin()
            CATransaction.setValue(true, kCATransactionDisableActions)
            view.layer.setFrame(rect)
            playerLayer.setFrame(rect)
            avPlayerViewController.view.layer.frame = rect
            CATransaction.commit()
        },
        update = {
            player.play()
            avPlayerViewController.player!!.play()
            loopVideo(player)
        },
        modifier = modifier,
        onRelease = {
            // play video
            player.pause()
            avPlayerViewController.player!!.pause()
        }
    )
}

private fun loopVideo(videoPlayer: AVPlayer) {

    NSNotificationCenter.defaultCenter().addObserverForName(
        AVPlayerItemDidPlayToEndTimeNotification,
        null,
        null
    ) { _ ->

        videoPlayer.seekToTime(kCMTimeZero.readValue())
        videoPlayer.play()
    }
}
