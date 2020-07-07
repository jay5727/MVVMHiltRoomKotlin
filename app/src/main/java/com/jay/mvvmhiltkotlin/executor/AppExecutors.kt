package com.jay.mvvmhiltkotlin.executor

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object AppExecutors {

  private val diskIO: Executor = Executors.newSingleThreadExecutor()
  private val mainThread: Executor = MainThreadExecutor()

  fun diskIO(): Executor {
    return diskIO
  }

  fun mainThread(): Executor {
    return mainThread
  }

  private class MainThreadExecutor : Executor {
    private val mainThreadHandler = Handler(Looper.getMainLooper())
    override fun execute(command: Runnable) {
      mainThreadHandler.post(command)
    }
  }
}
