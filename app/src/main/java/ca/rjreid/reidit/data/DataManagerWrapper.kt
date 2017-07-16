package ca.rjreid.reidit.data


import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.model.TimeFilters
import ca.rjreid.reidit.data.remote.RedditService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DataManagerWrapper @Inject constructor(val redditService: RedditService) : DataManager {
    override fun fetchFrontPage(): Observable<PostsHolder> {
        return redditService.fetchFrontPage(FrontPageTypes.TOP, FrontPageTypes.TOP, TimeFilters.DAY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}