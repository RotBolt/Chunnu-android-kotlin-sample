package io.rot.labs.asynctaskloaderexample

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

object NetworkUtils {

    fun getHttpResponse(urlString:String):String{
        var url: URL? = null
        var result = ""
        try {
            url = URL(urlString)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
        var connection: HttpURLConnection?

        try {
            connection = url!!.openConnection() as HttpURLConnection
            val netInputStream: InputStream = connection.getInputStream()
            val isr = InputStreamReader(netInputStream)
            val br = BufferedReader(isr)
            val sb = StringBuilder()
            var buffer:String? = ""
            do {
                sb.append(buffer)
                buffer = br.readLine()
            } while (buffer != null)
            result = sb.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }


        return result
    }

}