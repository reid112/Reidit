package ca.rjreid.reidit.ui.post

import ca.rjreid.reidit.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class PostModule {
    @Provides
    @ActivityScope
    fun providePostView(activity: PostActivity): PostView = activity
}