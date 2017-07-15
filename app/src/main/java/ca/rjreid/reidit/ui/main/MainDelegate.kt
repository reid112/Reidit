package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.model.Response
import ca.rjreid.reidit.ui.base.ViewDelegate

interface MainDelegate : ViewDelegate {
    fun displayPosts(response: Response)

}