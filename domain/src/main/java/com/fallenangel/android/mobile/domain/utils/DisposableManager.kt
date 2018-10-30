package com.fallenangel.android.mobile.domain.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by NineB on 10/29/2018.
 */
class DisposableManager () {

    private var compositeDisposable: CompositeDisposable? = null

    init {
        compositeDisposable = CompositeDisposable()
    }


    fun add(disposable: Disposable){
        getCompositeDisposable().add(disposable)
    }

    private fun getCompositeDisposable(): CompositeDisposable {
        if (compositeDisposable == null || compositeDisposable!!.isDisposed) {
            compositeDisposable = CompositeDisposable()
        }
        return compositeDisposable!!
    }

    private fun dispose(){
        getCompositeDisposable().dispose()
    }

    fun disposeAndUnRegister(){
        dispose()
        unRegister()
    }

    private fun unRegister(){
        compositeDisposable = null
    }
}