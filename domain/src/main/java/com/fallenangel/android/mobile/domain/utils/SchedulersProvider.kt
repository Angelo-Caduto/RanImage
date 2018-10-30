package com.fallenangel.android.mobile.domain.utils

import io.reactivex.Scheduler

/**
 * Created by NineB on 10/29/2018.
 */
interface SchedulersProvider {

    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
    fun newThread(): Scheduler
    fun trampoline(): Scheduler

}