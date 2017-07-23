package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.DataManager
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity): MainDelegate {
        return mainActivity
    }

    @Provides
    internal fun provideMainPresenter(mainView: MainDelegate, dataManager: DataManager): MainPresenter {
        return MainPresenter(mainView, dataManager)
    }
}