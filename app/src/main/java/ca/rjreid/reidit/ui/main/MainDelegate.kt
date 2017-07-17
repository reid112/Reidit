package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.model.PostHolder
import ca.rjreid.reidit.ui.base.ViewDelegate

interface MainDelegate : ViewDelegate {
    fun updatePosts(postHolders: List<PostHolder>)
    fun clearPosts()
    fun showError(localizedMessage: String?)

}