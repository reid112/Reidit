package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.model.PostsHolder
import ca.rjreid.reidit.data.remote.RedditService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter constructor(var delegate: MainDelegate, var redditService: RedditService) {
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
        redditService.fetchFrontPage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response -> displayPosts(response) }
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
    //endregion
}