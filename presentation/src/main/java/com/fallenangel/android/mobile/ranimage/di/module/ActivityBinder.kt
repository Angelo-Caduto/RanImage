package com.fallenangel.android.mobile.ranimage.di.module

import com.fallenangel.android.mobile.ranimage.mvp.MainActivity
import com.fallenangel.android.mobile.ranimage.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by NineB on 10/29/2018.
 */
@Module
abstract class ActivityBinder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun injectMain(): MainActivity

}