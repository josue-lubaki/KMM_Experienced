package ca.josue_lubaki.kmmexperiments.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material.*
import ca.josue_lubaki.kmmexperiments.MainView
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}
