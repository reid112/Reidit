package ca.rjreid.reidit.ui.main

class MainPresenter constructor(var delegate: MainDelegate) {

    fun test() {
        delegate.test("delegate")
    }

}