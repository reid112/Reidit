package ca.rjreid.reidit.data

import ca.rjreid.reidit.data.model.PostsHolder
import io.reactivex.Observable


interface DataManager {
    fun fetchFrontPage(): Observable<PostsHolder>
}