package ca.rjreid.reidit.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import ca.rjreid.reidit.R
import ca.rjreid.reidit.data.model.PostHolder
import ca.rjreid.reidit.ui.base.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity(), MainDelegate, SwipeRefreshLayout.OnRefreshListener {
    //region Variables
    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var adapter: MainAdapter
    //endregion

    //region Views
    @BindView(R.id.main_swipe_refresh_layout) lateinit var refreshLayout: SwipeRefreshLayout
    @BindView(R.id.main_posts_recycler_view) lateinit var recyclerView: RecyclerView
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
//    @OnClick(R.id.signin)
//    internal fun signinButtonClicked() {
//        presenter.fetchFrontPage()
//    }
    //endregion

    //region View Delegate Implementation
    override fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun initRefreshLayout() {
        refreshLayout.setOnRefreshListener(this)
    }

    override fun updatePosts(postHolders: List<PostHolder>) {
        refreshLayout.isRefreshing = false
        adapter.updatePosts(postHolders)
    }

    override fun clearPosts() {
        adapter.clearPosts()
    }

    override fun showError(localizedMessage: String?) {
        Snackbar.make(refreshLayout, "Oops, there seems to be a problem: $localizedMessage", Snackbar.LENGTH_LONG).show()
    }
    //endregion

    //region OnRefreshListener Implementation
    override fun onRefresh() {
        refreshLayout.isRefreshing = true
        presenter.refresh()
    }
    //endregion

    //region BaseActivity Implementation
    override fun getLayout() = R.layout.activity_main
    //endregion
}
