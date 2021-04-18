package com.rossi.coroutineslab

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val url = URL("https://www.stickaz.com/6235-7166-large/bugdroid-android.png")

        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.doInput = true
        urlConnection.connect()

        val inputStream = urlConnection.inputStream
        val bitMap = BitmapFactory.decodeStream(inputStream)
        image.setImageBitmap(bitMap)

    }
}