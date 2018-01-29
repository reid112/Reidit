package ca.rjreid.reidit.di.module

import ca.rjreid.reidit.di.scope.ViewScope
import ca.rjreid.reidit.ui.post.view.TestModule
import ca.rjreid.reidit.ui.post.view.TestView
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBindingModule {

    @ViewScope
    @ContributesAndroidInjector(modules = [TestModule::class])
    abstract fun bindTestView(): TestView

}