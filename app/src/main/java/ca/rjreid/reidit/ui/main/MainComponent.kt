package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.di.component.ApplicationComponent
import ca.rjreid.reidit.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(delegate: MainDelegate)
    fun presenter(): MainPresenter
}