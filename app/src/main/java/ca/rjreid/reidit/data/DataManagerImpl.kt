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
internal class DataManagerImpl @Inject constructor(val redditService: RedditService) : DataManager {
    override fun fetchFrontPage(frontPageType: FrontPageTypes, timeFilter: TimeFilters, after: String): Observable<PostsHolder> {
        return redditService.fetchFrontPage(frontPageType, frontPageType, timeFilter, after)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}