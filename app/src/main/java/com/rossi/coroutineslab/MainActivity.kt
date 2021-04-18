package com.rossi.coroutineslab

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch {
            val url = URL("https://www.stickaz.com/6235-7166-large/bugdroid-android.png")

            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.doInput = true
            urlConnection.connect()

            val inputStream = urlConnection.inputStream
            val bitMap = BitmapFactory.decodeStream(inputStream)

            /* Para retornar para a MainThread pode ser usado uma das 2 abordagens:
            *runOnUiThread { image.setImageBitmap(bitMap) }
                    *OU*/
            Handler(mainLooper).post{ image.setImageBitmap(bitMap) }

        }

    }
}