package com.jay.mvvmhiltkotlin.utils.extensions

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.view.ViewAnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.jay.mvvmhiltkotlin.R
import kotlin.math.max

fun checkIsMaterialVersion() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP

fun Activity.circularRevealedAtCenter(view: View) {
  val cx = (view.left + view.right) / 2
  val cy = (view.top + view.bottom) / 2
  val finalRadius = max(view.width, view.height)

  if (checkIsMaterialVersion() && view.isAttachedToWindow) {
    val anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, finalRadius.toFloat())
    view.visible()
    view.setBackgroundColor(ContextCompat.getColor(this, R.color.preview))
    anim.duration = 550
    anim.start()
  }
}

fun Activity.requestGlideListener(view: View): RequestListener<Drawable> {
  return object : RequestListener<Drawable> {
    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
      return false
    }

    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
      circularRevealedAtCenter(view)
      return false
    }
  }
}

fun AppCompatActivity.simpleToolbarWithHome(toolbar: Toolbar, title_: String = "") {
  setSupportActionBar(toolbar)
  supportActionBar?.run {
    setDisplayHomeAsUpEnabled(true)
    //setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
    title = title_
  }
}

fun AppCompatActivity.applyToolbarMargin(toolbar: Toolbar) {
  if (checkIsMaterialVersion()) {
    toolbar.layoutParams = (toolbar.layoutParams as CollapsingToolbarLayout.LayoutParams).apply {
      topMargin = getStatusBarSize()
    }
  }
}

private fun AppCompatActivity.getStatusBarSize(): Int {
  val idStatusBarHeight = resources.getIdentifier("status_bar_height", "dimen", "android")
  return if (idStatusBarHeight > 0) {
    resources.getDimensionPixelSize(idStatusBarHeight)
  } else 0
}
