package ca.rjreid.reidit.di.component


import ca.rjreid.reidit.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

//    @ApplicationContext fun context() : Context
//    fun application() : Application
}
