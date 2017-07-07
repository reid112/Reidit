package ca.rjreid.reidit.ui.main

import android.os.Bundle
import ca.rjreid.reidit.R
import ca.rjreid.reidit.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    //endregion

    //region BaseActivity Implementation
    override fun getLayout(): Int {
        return R.layout.activity_main
    }
    //endregion
}
