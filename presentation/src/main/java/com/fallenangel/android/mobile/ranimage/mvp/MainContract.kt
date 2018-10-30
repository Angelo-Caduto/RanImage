package com.fallenangel.android.mobile.ranimage.mvp

import android.os.Bundle
import com.fallenangel.android.mobile.domain.model.ImageFile

/**
 * Created by NineB on 10/29/2018.
 */
interface MainContract {

    interface View{
        fun setImageToView(img: ImageFile)
        fun showErrorMsg(message: String)
        fun askPermission(permision: String)
        fun showLoadingView()
        fun hideLoadingView()
    }

    interface Presenter<T : View>{
        fun attachView(view: T)
        fun detachView()

        fun onViewReady(savedInstanceState: Bundle?)
        fun onDestroy()

        fun onImageClicked()
        fun onPermissionGranted(requestCode: Int, permissions: Array<String>, grantResults: IntArray)

        fun onSaveInstanceState(outState: Bundle?)
    }

}