package ca.rjreid.reidit.data

import ca.rjreid.reidit.data.remote.RedditService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DataManagerWrapper @Inject constructor(val redditService: RedditService) : DataManager {

}