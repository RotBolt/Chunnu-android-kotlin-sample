package io.rot.labs.asynctaskloaderexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager
import androidx.loader.content.AsyncTaskLoader
import androidx.loader.content.Loader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<String> {

    companion object {
        val OPERATION_SEARCH_LOADER = 22
        val OPERATION_URL_EXTRA = "https://jsonplaceholder.typicode.com/posts"
        val OPERATION_QUERY_URL_EXTRA = "query"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeOperationSearchQuery(OPERATION_URL_EXTRA)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String> {
        return object : AsyncTaskLoader<String>(this) {

            var resultFromHttp: String? = null

            override fun loadInBackground(): String? {
                Thread.sleep(5000)
                resultFromHttp = NetworkUtils.getHttpResponse(
                    args!!.getString(
                        OPERATION_QUERY_URL_EXTRA, OPERATION_URL_EXTRA
                    )
                )
                return resultFromHttp
            }

            override fun onStartLoading() {
                if (resultFromHttp != null) {
                    deliverResult(resultFromHttp)
                } else {
                    forceLoad()
                }
            }

            override fun deliverResult(data: String?) {
                tvText.text = data
                super.deliverResult(data)
            }


        }
    }

    override fun onLoadFinished(loader: Loader<String>, data: String?) {
    }

    override fun onLoaderReset(loader: Loader<String>) {

    }


    private fun makeOperationSearchQuery(url: String) {

        // Create a bundle called queryBundle
        val queryBundle = Bundle()
        // Use putString with OPERATION_QUERY_URL_EXTRA as the key and the String value of the URL as the value
        //url value here is https://jsonplaceholder.typicode.com/posts
        queryBundle.putString(OPERATION_QUERY_URL_EXTRA, url)
        // Call getSupportLoaderManager and store it in a LoaderManager variable
        val loaderManager = supportLoaderManager
        // Get our Loader by calling getLoader and passing the ID we specified
        val loader =
            loaderManager.getLoader<String>(OPERATION_SEARCH_LOADER)
        // If the Loader was null, initialize it. Else, restart it.
        if (loader == null) {
            loaderManager.initLoader(OPERATION_SEARCH_LOADER, queryBundle, this)
        } else {
            loaderManager.restartLoader(OPERATION_SEARCH_LOADER, queryBundle, this)
        }
    }
}