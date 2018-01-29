package ca.rjreid.reidit.ui.post

import javax.inject.Inject

class PostPresenter @Inject constructor(private val postView: PostView) {
    fun init() {
        postView.initClickListeners()
    }

    fun testViewClicked() {
        postView.showTestView()
    }

}