package com.fallenangel.android.mobile.ranimage

import com.fallenangel.android.mobile.ranimage.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by NineB on 10/29/2018.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder()
                .attachApplicationContext(this)
                .build()
        appComponent.inject(this)
        return appComponent
    }

}