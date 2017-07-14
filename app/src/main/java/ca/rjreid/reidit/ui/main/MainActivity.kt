package ca.rjreid.reidit.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ca.rjreid.reidit.R
import ca.rjreid.reidit.ui.base.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity(), MainDelegate {
    //region Variables
    @Inject lateinit var presenter: MainPresenter
    //endregion

    //region Views
    @BindView(R.id.test_textView) lateinit var testTextView: TextView
    //endregion

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        ButterKnife.bind(this)
    }
    //endregion

    //region Click Listeners
    @OnClick(R.id.signin)
    internal fun signinButtonClicked() {
        presenter.test()
    }
    //endregion

    //region View Delegate Implementation
    override fun test(s: String) {
        Log.d("REID", s)
    }
    //endregion

    //region BaseActivity Implementation
    override fun getLayout() = R.layout.activity_main
    //endregion
}
