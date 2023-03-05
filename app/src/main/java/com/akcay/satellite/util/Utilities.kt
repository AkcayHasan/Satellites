package com.akcay.satellite.util

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object Utilities {

    fun loadJSONFromAsset(context: Context, fileName: String): String? {
        val json: String? = try {
            val input: InputStream = context.assets.open("${fileName}.json")
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            val charset = Charset.forName("UTF-8")
            String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}