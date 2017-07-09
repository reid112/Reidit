package ca.rjreid.reidit.di.module

import android.content.Context
import ca.rjreid.reidit.di.qualifier.ApplicationContext
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PicassoModule {

    @Provides @Singleton
    fun providePicasso(@ApplicationContext context: Context): Picasso = Picasso.Builder(context).build()

}