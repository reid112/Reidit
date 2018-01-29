package ca.rjreid.reidit.di.component

import android.app.Application
import ca.rjreid.reidit.App
import ca.rjreid.reidit.di.module.ActivityBindingModule
import ca.rjreid.reidit.di.module.AppModule
import ca.rjreid.reidit.di.module.DataModule
import ca.rjreid.reidit.di.module.ViewBindingModule
import com.ivianuu.contributer.annotations.AndroidInjectorKeyRegistry
import com.ivianuu.contributer.view.ViewInjectionModule
import com.ivianuu.contributer.view.ViewKey
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@AndroidInjectorKeyRegistry(keys = [ViewKey::class])
@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    ActivityBindingModule::class,
    ViewBindingModule::class,
    AndroidSupportInjectionModule::class,
    ViewInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}