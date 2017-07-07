package ca.rjreid.reidit.ui.main

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ca.rjreid.reidit.R
import ca.rjreid.reidit.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    @BindView(R.id.test_textView) lateinit var testTextView: TextView

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
    }
    //endregion

    //region Click Listeners
    @OnClick(R.id.signin)
    internal fun signinButtonClicked() {

    }

    //endregion

    //region BaseActivity Implementation
    override fun getLayout(): Int {
        return R.layout.activity_main
    }
    //endregion
}
