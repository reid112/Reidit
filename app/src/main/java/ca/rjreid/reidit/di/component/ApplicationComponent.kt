package ca.rjreid.reidit.di.component

import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.di.module.ApplicationModule
import ca.rjreid.reidit.di.module.DataModule
import ca.rjreid.reidit.di.module.PicassoModule
import ca.rjreid.reidit.ui.main.MainActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, PicassoModule::class))
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun retrofit(): Retrofit
    fun dataManager(): DataManager
}
