package ca.rjreid.reidit.di.component


import ca.rjreid.reidit.di.module.ApplicationModule
import ca.rjreid.reidit.di.module.DataModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        DataModule::class
))
interface ApplicationComponent {

}
