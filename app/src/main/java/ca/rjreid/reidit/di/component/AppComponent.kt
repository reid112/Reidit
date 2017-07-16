package ca.rjreid.reidit.di.component

import android.app.Application
import ca.rjreid.reidit.App
import ca.rjreid.reidit.di.module.ActivityBuilderModule
import ca.rjreid.reidit.di.module.AppModule
import ca.rjreid.reidit.di.module.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        DataModule::class
))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}
