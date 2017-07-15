package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.remote.RedditService
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity): MainDelegate {
        return mainActivity
    }

    @Provides
    internal fun provideMainPresenter(mainView: MainDelegate, redditService: RedditService): MainPresenter {
        return MainPresenter(mainView, redditService)
    }
}