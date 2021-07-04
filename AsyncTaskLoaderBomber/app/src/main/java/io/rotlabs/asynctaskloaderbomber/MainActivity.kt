package io.rotlabs.asynctaskloaderbomber

import android.app.LoaderManager
import android.content.Loader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<String> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loaderManager.initLoader(0, null, this)
        val chaapBtn = findViewById<Button>(R.id.chaapBtn)
        chaapBtn.setOnClickListener {

        }


    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<String> {
        Log.d("PUI","onCreate Loader called")
        return ChaapLoader(this)
    }

    override fun onLoadFinished(loader: Loader<String>?, data: String?) {
        Log.d("PUI","onLoaderFinished")
        Toast.makeText(this,"PUI",Toast.LENGTH_SHORT).show()
        findViewById<TextView>(R.id.tvChaapResult).text = data
    }

    override fun onLoaderReset(loader: android.content.Loader<String>?) {
        Log.d("PUI","loader reset called")

    }
}