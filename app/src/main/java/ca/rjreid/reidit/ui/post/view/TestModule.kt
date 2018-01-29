package ca.rjreid.reidit.ui.post.view

import ca.rjreid.reidit.di.scope.ViewScope
import dagger.Module
import dagger.Provides

@Module
class TestModule {
    @Provides
    @ViewScope
    fun provideTestDelegate(view: TestView): TestDelegate = view
}