package ca.rjreid.reidit.extensions

import android.widget.ImageView
import ca.rjreid.reidit.R
import com.squareup.picasso.Picasso

fun ImageView.image(url: String) {
    Picasso.with(context)
            .load(url)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_placeholder)
            .into(this)
}