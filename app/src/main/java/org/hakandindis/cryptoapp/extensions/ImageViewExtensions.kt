package org.hakandindis.cryptoapp.extensions

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load
import org.hakandindis.cryptoapp.BuildConfig

fun ImageView.loadImage(id: String?) = this.load(BuildConfig.BASE_IMAGE_URL.plus("$id.png")) {
    crossfade(true)
    crossfade(500)
    placeholder(createPlaceHolder(context))
}

private fun createPlaceHolder(context: Context) = CircularProgressDrawable(context).apply {
    strokeWidth = 12f
    centerRadius = 40f
    start()
}