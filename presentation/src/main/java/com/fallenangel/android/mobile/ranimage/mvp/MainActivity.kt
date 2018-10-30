package com.fallenangel.android.mobile.ranimage.mvp

import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.ActivityCompat
import android.view.View
import android.widget.Toast
import com.fallenangel.android.mobile.domain.model.ImageFile
import com.fallenangel.android.mobile.ranimage.R
import com.fallenangel.android.mobile.ranimage.di.scope.ActivityScope
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import javax.inject.Inject

@ActivityScope
class MainActivity : AppCompatActivity(), MainContract.View, View.OnClickListener {

    @Inject lateinit var presenter: MainContract.Presenter<MainContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        init()
        presenter.attachView(this)
        presenter.onViewReady(savedInstanceState)
    }

    private fun init(){
        setContentView(R.layout.activity_main)
        main_image.setOnClickListener(this)
    }

    override fun showErrorMsg(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View?) {
        when (view!!.id){
            R.id.main_image -> presenter.onImageClicked()
        }
    }

    override fun setImageToView(img: ImageFile) {
        main_image.setImageURI(Uri.fromFile(File(img.path)))
        main_image.invalidate()
        image_size_tv.text = getText(R.string.image_size).toString().format(img.size)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        presenter.onDestroy()
    }

    override fun showLoadingView() {
        loading_view.visibility = View.VISIBLE
    }

    override fun hideLoadingView() {
        loading_view.visibility = View.GONE
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        if(newConfig?.orientation == Configuration.ORIENTATION_LANDSCAPE)
            main_image.rotation = 90F
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        onSaveInstanceState(outState)
    }


    override fun askPermission(permision: String) {
        ActivityCompat.requestPermissions(this, arrayOf(permision), 1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            presenter.onPermissionGranted(requestCode, permissions, grantResults)
        }
    }

}
