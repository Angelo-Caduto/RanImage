package com.fallenangel.android.mobile.ranimage.utils

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build

/**
 * Created by NineB on 10/29/2018.
 */
open class PermissionManager (private val context: Context){

    fun checkPermission(): Boolean{
        return if (Build.VERSION.SDK_INT >= 23) {
            context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

}