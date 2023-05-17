package ca.josue_lubaki.kmmexperiments.android

import android.app.Application
import ca.josue_lubaki.kmmexperiments.di.initKoin

/**
 * created by Josue Lubaki
 * date : 2023-05-16
 * version : 1.0.0
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}