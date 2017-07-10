package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.di.scope.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent
interface MainComponent {
    fun inject(activity: MainActivity)
}