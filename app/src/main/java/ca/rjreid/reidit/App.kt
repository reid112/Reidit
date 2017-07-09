package ca.rjreid.reidit

import android.app.Application
import ca.rjreid.reidit.di.component.ApplicationComponent
import ca.rjreid.reidit.di.component.DaggerApplicationComponent
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        initializeDagger()
    }

    fun initializeDagger() {
        component = DaggerApplicationComponent.builder().build()
    }
}