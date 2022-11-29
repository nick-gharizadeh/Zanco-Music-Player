package com.example.zancomusicplayer

import android.graphics.drawable.Drawable
import android.widget.ImageView


fun ImageView.matchSrc(imageView: ImageView) {
    val drawable: Drawable = this.drawable
    imageView.setImageDrawable(drawable)
}