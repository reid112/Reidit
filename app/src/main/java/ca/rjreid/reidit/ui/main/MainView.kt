package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.model.Post
import ca.rjreid.reidit.data.model.PostHolder
import ca.rjreid.reidit.ui.base.BaseView

interface MainView : BaseView {
    fun updatePosts(postHolders: List<PostHolder>)
    fun clearPosts()
    fun showError(localizedMessage: String?)
    fun isRefreshing(isRefreshing: Boolean)
    fun showPostDetails(post: Post)
    fun showPostComments(post: Post)
}