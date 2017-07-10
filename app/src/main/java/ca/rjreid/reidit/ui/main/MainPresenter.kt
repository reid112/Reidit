package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(val dataManager: DataManager) : BasePresenter<MainDelegate>() {


}