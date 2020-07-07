package com.jay.mvvmhiltkotlin.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * NOTE : Make sure to register BaseApplication in [AndroidManifest]
 */
@HiltAndroidApp
class BaseApplication : Application() {

}