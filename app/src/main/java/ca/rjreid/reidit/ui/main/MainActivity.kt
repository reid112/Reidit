package ca.rjreid.reidit.ui.main

import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import ca.rjreid.reidit.R
import ca.rjreid.reidit.di.component.ApplicationComponent
import ca.rjreid.reidit.ui.base.BaseActivity
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
        ButterKnife.bind(this)
        presenter.bind(this)
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    //endregion

    //region Click Listeners
    @OnClick(R.id.signin)
    internal fun signinButtonClicked() {

    }
    //endregion

    //region BaseActivity Implementation
    override fun getLayout() = R.layout.activity_main

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent.inject(this)
    }
    //endregion
}
