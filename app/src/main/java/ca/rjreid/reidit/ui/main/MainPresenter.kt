package ca.rjreid.reidit.ui.main

import android.os.Bundle
import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.model.TimeFilters
import com.evernote.android.state.State
import com.evernote.android.state.StateSaver
import io.reactivex.disposables.CompositeDisposable

class MainPresenter constructor(private var delegate: MainDelegate, private var dataManager: DataManager) {
    //region Variables
    val compositeDisposable = CompositeDisposable()
    //endregion

    //region State Variables
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

        delegate.isRefreshing(true)

        dataManager
                .fetchFrontPage(frontPageType, timeFilter)
                .subscribe(
                        { displayPosts(it) },
                        { showError(it) }
                )
    }

    fun refresh() {
        delegate.clearPosts()
        fetchFrontPage(currentFrontPageType, currentTimeFilter)
    }

    fun destroy() {
        compositeDisposable.clear()
    }
    //endregion

    //region Helpers
    private fun displayPosts(response: PostsHolder) {
        delegate.updatePosts(response.postsData.postHolders)
    }

    private fun showError(throwable: Throwable) {
        delegate.showError(throwable.localizedMessage)
    }
    //endregion


}