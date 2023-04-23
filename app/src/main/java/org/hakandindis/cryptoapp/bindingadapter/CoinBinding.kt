package org.hakandindis.cryptoapp.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import org.hakandindis.cryptoapp.extensions.loadImage


@BindingAdapter("load_image")
fun loadImage(imageView: ImageView, id: String) {
    imageView.loadImage(id)
}