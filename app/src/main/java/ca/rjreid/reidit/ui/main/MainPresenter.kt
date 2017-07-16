package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.model.TimeFilters
import io.reactivex.disposables.CompositeDisposable

class MainPresenter constructor(var delegate: MainDelegate, var dataManager: DataManager) {
    //region Variables
    private val compositeDisposable = CompositeDisposable()
    //endregion

    //region Commands
    fun init() {
        delegate.initRecyclerView()
        delegate.initRefreshLayout()

        fetchFrontPage()
    }

    fun fetchFrontPage() {
        dataManager
                .fetchFrontPage(FrontPageTypes.TOP, TimeFilters.DAY)
                .subscribe(
                        {
                            response ->
                            displayPosts(response)
                        },
                        {
                            error ->
                            showError(error)
                        }
                )
    }

    fun refresh() {
        delegate.clearPosts()
        fetchFrontPage()
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