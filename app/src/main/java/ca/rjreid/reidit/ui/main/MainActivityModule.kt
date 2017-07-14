package ca.rjreid.reidit.ui.main

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity): MainDelegate {
        return mainActivity
    }

    @Provides
    internal fun provideMainPresenter(mainView: MainDelegate): MainPresenter {
        return MainPresenter(mainView)
    }
}