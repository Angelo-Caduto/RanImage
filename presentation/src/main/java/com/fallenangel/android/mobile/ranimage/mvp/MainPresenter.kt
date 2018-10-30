package com.fallenangel.android.mobile.ranimage.mvp

import android.Manifest
import android.os.Bundle
import com.fallenangel.android.mobile.data.mapper.SavedStateMapper
import com.fallenangel.android.mobile.domain.interactor.RandomImageInteractor
import com.fallenangel.android.mobile.domain.model.ImageFile
import com.fallenangel.android.mobile.domain.utils.DisposableManager
import com.fallenangel.android.mobile.domain.utils.SchedulersProvider
import com.fallenangel.android.mobile.ranimage.di.scope.ActivityScope
import com.fallenangel.android.mobile.ranimage.utils.PermissionManager
import javax.inject.Inject

/**
 * Created by NineB on 10/29/2018.
 */
@ActivityScope
class MainPresenter @Inject constructor(
        private var randomImageInteractor: RandomImageInteractor,
        private var schedulersProvider: SchedulersProvider,
        private var disposableManager: DisposableManager,
        private var permissionManager: PermissionManager
) : MainContract.Presenter<MainContract.View> {

    private var mView: MainContract.View? = null
    private var isLoading: Boolean = false

    private var currentImg: ImageFile? = null

    override fun detachView() {

    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            downloadAndSetNewImage()
        } else {
            currentImg = SavedStateMapper().map(savedInstanceState)
            mView?.hideLoadingView()
            mView?.setImageToView(currentImg!!)
        }
    }

    override fun onDestroy() {
        currentImg = null
        disposableManager.disposeAndUnRegister()
    }

    override fun onImageClicked() {
        downloadAndSetNewImage()
    }

    override fun attachView(view: MainContract.View) {
        this.mView = view
    }

    private fun downloadAndSetNewImage(){
        if (!permissionManager.checkPermission())
            mView?.askPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        else
            startDownload()
    }

    private fun startDownload(){
        if (!isLoading) {
            var disp = randomImageInteractor.executeFetchRandomImage()
                    .observeOn(schedulersProvider.ui())
                    .doOnSubscribe {
                        isLoading = true
                        mView?.showLoadingView()
                    }
                    .doOnSuccess {
                        isLoading = false
                        mView?.hideLoadingView()
                        currentImg = it
                        if (mView != null)
                            mView?.setImageToView(it)
                        disposableManager.disposeAndUnRegister()
                    }
                    .doOnError {
                        isLoading = false
                        mView?.showErrorMsg(it.message!!)
                        disposableManager.disposeAndUnRegister()
                    }
                    .subscribe()
            disposableManager.add(disp)
        }
    }

    override fun onPermissionGranted(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        startDownload()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        if (currentImg != null) {
            outState?.putString(SavedStateMapper.SAVED_IMG_STATE_PATH_KEY, currentImg?.path)
            outState?.putLong(SavedStateMapper.SAVED_IMG_STATE_SIZE_KEY, currentImg!!.size)
        }
    }
}