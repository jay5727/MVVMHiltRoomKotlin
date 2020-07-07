package com.jay.mvvmhiltkotlin.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.jay.mvvmhiltkotlin.utils.extensions.requestGlideListener

/**
 *
 * Data Binding adapters specific to the app.
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("app:errorText")
    fun setError(view: TextInputLayout?, errorMessage: String?) {
        if (!errorMessage.isNullOrBlank())
            view?.error = errorMessage
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        //Glide.with(imageView.context).load(url).into(imageView)
        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context)
                    .load(url)
                    //.circleCrop()
                    //.apply(RequestOptions().circleCrop())
                    .listener(imageView.requestGlideListener())
                    .into(imageView)
        }
    }

    //Add your future BindingAdapters here...

}
