package ca.rjreid.reidit.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ca.rjreid.reidit.di.component.ApplicationComponent
import ca.rjreid.reidit.util.extension.getAppComponent


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(getAppComponent())
        setContentView(getLayout())
    }

    abstract fun getLayout() : Int

    abstract fun injectDependencies(applicationComponent: ApplicationComponent)
}

