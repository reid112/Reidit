package ca.rjreid.reidit.data.remote

import ca.rjreid.reidit.data.model.Response
import io.reactivex.Observable
import retrofit2.http.GET


interface RedditService {

    @GET(".json")
    fun fetchFrontPage(): Observable<Response>
}