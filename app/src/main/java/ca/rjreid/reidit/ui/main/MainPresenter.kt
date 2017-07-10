package ca.rjreid.reidit.ui.main

import ca.rjreid.reidit.data.DataManager
import ca.rjreid.reidit.di.scope.PerActivity
import ca.rjreid.reidit.ui.base.BasePresenter
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor(val dataManager: DataManager) : BasePresenter<MainDelegate>() {

//    fun fetchJokes() {
//        disposables.add(
//                dataManager.getRandomJokes(100)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(
//                                { onFetchJokesSuccess(it) },
//                                { onFetchJokesError(it) })
//        )
//    }
//
//    fun onFetchJokesSuccess(jokes: List<Joke>) {
//        view?.onFetchJokesSuccess(jokes)
//    }
//
//    fun onFetchJokesError(error: Throwable) {
//        view?.onFetchJokesError(error)
//    }

}