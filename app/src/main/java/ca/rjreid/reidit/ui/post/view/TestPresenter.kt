package ca.rjreid.reidit.ui.post.view

import javax.inject.Inject

class TestPresenter @Inject constructor(private val testDelegate: TestDelegate) {
    //region Initialization
    fun init() {
        testDelegate.setTestText("Text from custom view's presenter")
    }
    //endregion
}