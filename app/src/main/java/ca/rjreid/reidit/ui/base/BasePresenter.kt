package ca.rjreid.reidit.ui.base

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : ViewDelegate> {

    protected val disposables = CompositeDisposable()
    protected var view: T? = null

    fun bind(view: T) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun destroy() {
        disposables.clear()
        unbind()
    }

}