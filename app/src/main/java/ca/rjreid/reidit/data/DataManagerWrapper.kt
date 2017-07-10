package ca.rjreid.reidit.data

import ca.rjreid.reidit.data.remote.RedditService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DataManagerWrapper @Inject constructor(val redditService: RedditService) : DataManager {

//    override fun getRandomJokes(count: Int): Observable<List<Joke>> {
//        return jokesService
//                .fetchRandomJokes(count)
//                .flatMap { Observable.just(it.value) }
//    }

}