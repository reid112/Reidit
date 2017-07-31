package ca.rjreid.reidit.data.remote

import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.model.TimeFilters
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RedditService {

    @GET("{frontPageType}.json")
    fun fetchFrontPage(@Path("frontPageType") frontPageType: FrontPageTypes,
                       @Query("sort") sort: FrontPageTypes,
                       @Query("t") time: TimeFilters,
                       @Query("after") after: String): Observable<PostsHolder>
}