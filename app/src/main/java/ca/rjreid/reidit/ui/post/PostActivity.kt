package ca.rjreid.reidit.ui.post

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.Toolbar
import ca.rjreid.reidit.R
import ca.rjreid.reidit.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_post.*
import javax.inject.Inject

class PostActivity : PostView, BaseActivity() {
    //region Intents
    companion object {
        @JvmStatic
        fun createIntent(context: Context) = Intent(context, PostActivity::class.java)
    }
    //endregion

    //region Variables
    @Inject internal lateinit var presenter: PostPresenter
    //endregion

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.init()
    }

    override fun initClickListeners() {
        testView.setOnClickListener { presenter.testViewClicked() }
    }
    //endregion

    //region Delegate Implementations
    override fun showTestView() {
        testView.setTestText("Clicked - text set from activity")
    }
    //endregion

    //region BaseActivity Implementations
    override fun getLayout() = R.layout.activity_post
    //endregion
}