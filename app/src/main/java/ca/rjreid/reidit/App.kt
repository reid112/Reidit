package ca.rjreid.reidit

import android.app.Activity
import android.app.Application
import android.view.View
import ca.rjreid.reidit.di.component.DaggerAppComponent
import com.ivianuu.contributer.view.HasViewInjector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : DaggerApplication(), HasViewInjector {
    @Inject lateinit var viewInjector: DispatchingAndroidInjector<View>

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun viewInjector() = viewInjector
}