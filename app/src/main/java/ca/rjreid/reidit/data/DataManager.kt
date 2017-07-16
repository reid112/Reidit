package ca.rjreid.reidit.data

import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.model.TimeFilters
import io.reactivex.Observable


interface DataManager {
    fun fetchFrontPage(frontPageType: FrontPageTypes, timeFilter: TimeFilters): Observable<PostsHolder>
}