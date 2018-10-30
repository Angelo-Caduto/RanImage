package com.fallenangel.android.mobile.ranimage.utils

import com.fallenangel.android.mobile.domain.utils.SchedulersProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by NineB on 10/29/2018.
 */
open class SchedulersProviderImpl : SchedulersProvider {

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
    override fun computation(): Scheduler = Schedulers.computation()
    override fun io(): Scheduler = Schedulers.io()
    override fun newThread(): Scheduler = Schedulers.newThread()
    override fun trampoline(): Scheduler = Schedulers.trampoline()

}