package ca.rjreid.reidit.extensions

import android.view.View
import android.widget.ImageView
import ca.rjreid.reidit.R
import com.squareup.picasso.Picasso

fun ImageView.image(url: String) =
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error_placeholder)
                .into(this)

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.show() {
    this.visibility = View.VISIBLE
}