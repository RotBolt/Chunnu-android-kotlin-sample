package io.rotlabs.asynctaskloaderbomber

import android.util.Log

object  RestClient {
    fun loadChaaps():String{
        Log.d("PUI","loading chaaps")
        Thread.sleep(5000)
        return "Malai Chaap + Achaari chaap = Chaap hi chaap yay!!!!!!!!!!!!!"
    }
}