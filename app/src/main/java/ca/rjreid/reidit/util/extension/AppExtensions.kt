package ca.rjreid.reidit.util.extension

import android.content.Context
import ca.rjreid.reidit.App
import ca.rjreid.reidit.di.component.ApplicationComponent

fun Context.getAppComponent(): ApplicationComponent = (applicationContext as App).appComponent