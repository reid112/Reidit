package ca.rjreid.reidit.ui.main

import javax.inject.Inject

class MainPresenter {
    //region Variables
    private val delegate: MainDelegate
    //endregion

    //region Constructor
    @Inject constructor(mainDelegate: MainDelegate) {
        this.delegate = mainDelegate
    }
    //endregion
}