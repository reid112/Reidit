package ca.rjreid.reidit.di.module

import ca.rjreid.reidit.di.scope.ActivityScope
import ca.rjreid.reidit.ui.main.MainActivity
import ca.rjreid.reidit.ui.main.MainActivityModule
import ca.rjreid.reidit.ui.post.PostActivity
import ca.rjreid.reidit.ui.post.PostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    internal abstract fun postActivity(): PostActivity
}