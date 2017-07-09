package ca.rjreid.reidit.di.module

import android.content.Context
import ca.rjreid.reidit.App
import ca.rjreid.reidit.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationContext
    fun provideApplicationContext(): Context = app
}