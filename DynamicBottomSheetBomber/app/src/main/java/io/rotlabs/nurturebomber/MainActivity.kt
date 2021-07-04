package io.rotlabs.nurturebomber

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cardInfo =  CardInfo(
            "header 1",
            "credit",
            "Payment options",
            CardInfo(
                "header 2",
                "Payment Options",
                "Proceed"
            )
        )

        findViewById<TextView>(R.id.tvHello).setOnClickListener {
            CustomBottomDialog.newInstance(cardInfo,getWindowHeight()-300).show(supportFragmentManager,"pui")
        }
    }


    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }
}