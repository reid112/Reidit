package ca.rjreid.reidit.util.extension

import android.content.Context
import android.text.TextUtils
import android.widget.ImageView
import ca.rjreid.reidit.App
import ca.rjreid.reidit.R
import ca.rjreid.reidit.di.component.ApplicationComponent
import com.squareup.picasso.Picasso

fun Context.getAppComponent(): ApplicationComponent = (applicationContext as App).appComponent

fun ImageView.loadImg(picasso: Picasso, imageUrl: String) {
    if (TextUtils.isEmpty(imageUrl)) {
        picasso.load(R.mipmap.ic_launcher).into(this)
    } else {
        picasso.load(imageUrl).into(this)
    }
}