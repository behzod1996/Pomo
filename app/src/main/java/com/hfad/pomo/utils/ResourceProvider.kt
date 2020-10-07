package com.hfad.pomo.utils

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {
    fun getText(@StringRes resId : Int) : String
}

class ResourceProviderImpl(context : Context) : ResourceProvider {

    private val appContext : Context = context.applicationContext

    override fun getText(@StringRes resId: Int): String {
        return appContext.getString(resId)
    }
}