package io.rotlabs.asynctaskloaderbomber

import android.content.AsyncTaskLoader
import android.content.Context
import android.util.Log


class ChaapLoader(context: Context) : AsyncTaskLoader<String>(context) {

    init {
        onContentChanged()
    }

    override fun onStartLoading() {
        super.onStartLoading()
        if (takeContentChanged()){
            forceLoad()
        }
    }

    override fun loadInBackground(): String {
        Log.d("PUI","loader loadInBackground")
        return RestClient.loadChaaps()
    }

    override fun onStopLoading() {
        super.onStopLoading()
        cancelLoad()
    }
}