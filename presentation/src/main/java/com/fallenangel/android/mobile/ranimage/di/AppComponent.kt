package com.fallenangel.android.mobile.ranimage.di

import android.content.Context
import com.fallenangel.android.mobile.ranimage.App
import com.fallenangel.android.mobile.ranimage.di.module.ActivityBinder
import com.fallenangel.android.mobile.ranimage.di.module.MainModule
import com.fallenangel.android.mobile.ranimage.di.module.UtilsModule
import com.fallenangel.android.mobile.ranimage.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by NineB on 10/29/2018.
 */
@ApplicationScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,
    ActivityBinder::class,
    UtilsModule::class,
    MainModule::class
])
interface AppComponent: AndroidInjector<App> {

    override fun inject(app: App)

    @Component.Builder interface Builder{
        @BindsInstance
        fun attachApplicationContext(app: Context): AppComponent.Builder
        fun build(): AppComponent
    }

}