package com.fallenangel.android.mobile.ranimage.di.module

import com.fallenangel.android.mobile.ranimage.mvp.MainContract
import com.fallenangel.android.mobile.ranimage.mvp.MainPresenter
import com.fallenangel.android.mobile.ranimage.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

/**
 * Created by NineB on 10/29/2018.
 */
@Module abstract class MainModule {

    @Binds
    @ActivityScope
    internal abstract fun providesMianPresenter(main: MainPresenter): MainContract.Presenter<MainContract.View>




}