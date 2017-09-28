package ca.rjreid.reidit.di.module

import android.app.Application
import android.content.Context
import ca.rjreid.reidit.di.qualifier.ApplicationContext
import ca.rjreid.reidit.ui.main.MainActivityComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = arrayOf(MainActivityComponent::class))
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(application: Application): Context {
        return application
    }
}