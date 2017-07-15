package ca.rjreid.reidit.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ca.rjreid.reidit.R
import ca.rjreid.reidit.data.model.Response
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
        presenter.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
    //endregion

    //region Click Listeners
    @OnClick(R.id.signin)
    internal fun signinButtonClicked() {
        presenter.fetchFrontPage()
    }
    //endregion

    //region View Delegate Implementation
    override fun displayPosts(response: Response) {
        Log.d("REID", response.toString())
    }
//endregion

    //region BaseActivity Implementation
    override fun getLayout() = R.layout.activity_main
    //endregion
}
