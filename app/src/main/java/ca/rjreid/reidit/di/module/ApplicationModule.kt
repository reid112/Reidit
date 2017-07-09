package ca.rjreid.reidit.di.module

import android.content.Context
import ca.rjreid.reidit.App
import ca.rjreid.reidit.di.ApplicationContext
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationContext
    fun provideApplicationContext(): Context = app

    @Provides @Singleton
    fun providePicasso(@ApplicationContext context: Context): Picasso = Picasso.Builder(context).build()

}