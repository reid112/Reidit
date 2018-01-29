package ca.rjreid.reidit.ui.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    abstract fun getLayout() : Int
}

