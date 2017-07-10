package ca.rjreid.reidit

import android.app.Application
import ca.rjreid.reidit.di.component.ApplicationComponent
import ca.rjreid.reidit.di.component.DaggerApplicationComponent
import ca.rjreid.reidit.di.module.ApplicationModule
import timber.log.Timber

class App : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        initializeDagger()
    }

    fun initializeDagger() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}