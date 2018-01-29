package ca.rjreid.reidit.ui.post.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ca.rjreid.reidit.R
import com.ivianuu.contributer.view.ViewInjection
import kotlinx.android.synthetic.main.view_test.view.*
import javax.inject.Inject

class TestView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle), TestDelegate {

    //region Variables
    @Inject internal lateinit var presenter: TestPresenter
    //endregion

    //region Init
    init {
        LayoutInflater.from(context).inflate(R.layout.view_test, this, true)
        ViewInjection.inject(this)

        presenter.init()
    }
    //endregion

    //region Delegate Implementations
    override fun setTestText(s: String) {
        testTextView.text = s
    }
    //endregion

}