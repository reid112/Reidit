package ca.rjreid.reidit.ui.main

import dagger.Module
import dagger.Provides

@Module
class MainModule(private val delegate: MainDelegate) {

    @Provides @ActivityScope
    internal fun provideDelegate(): MainDelegate = delegate

    @Provides @ActivityScope
    internal fun providePresenter(delegate: MainDelegate): MainPresenter = MainPresenter(delegate)
}