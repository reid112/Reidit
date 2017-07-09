package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val delegate: MainDelegate) {

    @Provides @ActivityScope
    internal fun provideDelegate(): MainDelegate = delegate

    @Provides @ActivityScope
    internal fun providePresenter(delegate: MainDelegate): MainPresenter = MainPresenter(delegate)
}