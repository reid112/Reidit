package ca.rjreid.reidit.ui.main

import android.os.Bundle
import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.Post
import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.model.TimeFilters
import com.evernote.android.state.State
import com.evernote.android.state.StateSaver
import io.reactivex.disposables.CompositeDisposable

class MainPresenter constructor(private var view: MainView, private var dataManager: DataManager) {
    //region Variables
    val compositeDisposable = CompositeDisposable()
    //endregion

    //region State Variables
    @State var after: String = ""
    @State var currentFrontPageType = FrontPageTypes.TOP
    @State var currentTimeFilter = TimeFilters.DAY
    //endregion

    //region Commands
    fun saveInstanceState(outState: Bundle?) {
        outState?.let {
            StateSaver.saveInstanceState(this, it)
        }
    }

    fun restoreInstanceState(savedInstanceState: Bundle?) {
        StateSaver.restoreInstanceState(this, savedInstanceState)
    }

    fun fetchFrontPage() {
        fetchFrontPage(currentFrontPageType, currentTimeFilter)
    }

    fun fetchFrontPage(frontPageType: FrontPageTypes, timeFilter: TimeFilters) {
        currentFrontPageType = frontPageType
        currentTimeFilter = timeFilter

        dataManager
                .fetchFrontPage(frontPageType, timeFilter, after)
                .subscribe(
                        { displayPosts(it) },
                        { showError(it) }
                )
    }

    fun refresh() {
        view.isRefreshing(true)
        view.clearPosts()
        after = ""
        fetchFrontPage(currentFrontPageType, currentTimeFilter)
    }

    fun destroy() =
        compositeDisposable.clear()
    //endregion

    //region Click Helpers
    fun postClick(post: Post) =
            view.showPostDetails(post)

    fun upVoteClick(post: Post) {

    }

    fun downVoteClick(post: Post) {

    }


    fun commentClick(post: Post) =
            view.showPostComments(post)

    //endregion

    //region Helpers
    private fun displayPosts(response: PostsHolder) {
        after = response.postsData.after ?: ""
        view.updatePosts(response.postsData.postHolders)
    }


    private fun showError(throwable: Throwable) =
            view.showError(throwable.localizedMessage)
    //endregion


}