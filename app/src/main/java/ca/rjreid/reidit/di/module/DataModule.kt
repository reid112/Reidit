package ca.rjreid.reidit.di.module

import android.content.Context
import ca.rjreid.reidit.BuildConfig
import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.data.DataManagerWrapper
import ca.rjreid.reidit.data.remote.RedditService
import ca.rjreid.reidit.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    companion object {
        const val REDDIT_BASE_URL = "https://www.reddit.com"
    }

    @Provides @Singleton
    fun provideCache(@ApplicationContext context: Context) = Cache(context.cacheDir, 10 * 1024 * 1024.toLong())

    @Provides @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient =
            OkHttpClient().newBuilder()
                    .cache(cache)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()

    @Provides @Singleton
    fun provideRestAdapter(client: OkHttpClient, converterFactory: GsonConverterFactory, callAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(REDDIT_BASE_URL)
                .client(client)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
    }

    @Provides @Singleton
    fun providesRedditService(retrofit: Retrofit): RedditService = retrofit.create(RedditService::class.java)

    @Provides @Singleton
    fun providesDataManger(redditService: RedditService): DataManager = DataManagerWrapper(redditService)
}