package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    @ActivityScope
    fun provideMainView(activity: MainActivity): MainView = activity
}