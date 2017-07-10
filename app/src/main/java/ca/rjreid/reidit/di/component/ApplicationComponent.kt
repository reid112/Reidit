package ca.rjreid.reidit.di.component


import ca.rjreid.reidit.di.module.ApplicationModule
import ca.rjreid.reidit.di.module.DataModule
import ca.rjreid.reidit.di.module.PicassoModule
import ca.rjreid.reidit.ui.main.MainComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, PicassoModule::class))
interface ApplicationComponent {
    fun mainComponent(): MainComponent
}
