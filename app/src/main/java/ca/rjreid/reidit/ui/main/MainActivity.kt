package ca.rjreid.reidit.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import ca.rjreid.reidit.R
import ca.rjreid.reidit.data.model.FrontPageTypes
import ca.rjreid.reidit.data.model.PostHolder
import ca.rjreid.reidit.data.model.TimeFilters
import ca.rjreid.reidit.ui.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainDelegate, SwipeRefreshLayout.OnRefreshListener {
    //region Variables
    @Inject lateinit var presenter: MainPresenter
    @Inject lateinit var adapter: MainAdapter

    private val listView by lazy {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView
    }

    private val refreshLayout by lazy {
        swipeRefreshLayout.setOnRefreshListener(this)
        swipeRefreshLayout
    }
    //endregion

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        presenter.fetchFrontPage()

        listView.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        presenter.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.restoreInstanceState(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.front_page_type, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var frontPageType = FrontPageTypes.HOT
        var timeFilter = TimeFilters.DAY

        when (item?.itemId) {
            R.id.front_page_type_hot -> {
                frontPageType = FrontPageTypes.HOT
            }
            R.id.front_page_type_new -> {
                frontPageType = FrontPageTypes.NEW
            }
            R.id.front_page_type_rising -> {
                frontPageType = FrontPageTypes.RISING
            }
            R.id.front_page_type_controversial -> {
                frontPageType = FrontPageTypes.CONTROVERSIAL
            }
            R.id.front_page_type_top -> {
                frontPageType = FrontPageTypes.TOP
            }
        }

        presenter.fetchFrontPage(frontPageType, timeFilter)
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
    //endregion

    //region View Delegate Implementation
    override fun updatePosts(postHolders: List<PostHolder>) {
        refreshLayout.isRefreshing = false
        adapter.updatePosts(postHolders)
    }

    override fun clearPosts() {
        adapter.clearPosts()
    }

    override fun showError(localizedMessage: String?) {
        refreshLayout.isRefreshing = false
        Snackbar.make(refreshLayout, "Oops, there seems to be a problem: $localizedMessage", Snackbar.LENGTH_LONG).show()
    }

    override fun isRefreshing(isRefreshing: Boolean) {
        refreshLayout.isRefreshing = isRefreshing
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
