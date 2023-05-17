package ca.josue_lubaki.kmmexperiments.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * created by Josue Lubaki
 * date : 2023-05-17
 * version : 1.0.0
 */

internal class AndroidAppDispatcher : AppDispatcher {
    override val dispatcher: CoroutineDispatcher
        get() = Dispatchers.IO
}

internal actual fun provideDispatcher(): AppDispatcher = AndroidAppDispatcher()