package com.example.myapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi


class CriptCesar {


    fun decript(photo: Bitmap, cifra: Int): Bitmap {
        var x = 0
        var y = 0
        val bitmap = photo
        for (x in 0 until bitmap.height) {
            for (y in 0 until bitmap.width) {
                var pixel = bitmap.getPixel(x, y)
                var red = Color.red(pixel) - cifra

                var blue = Color.blue(pixel) - cifra
                var green = Color.green(pixel) - cifra
                if (blue < 0) {
                    blue = 255 + blue
                }
                if (green < 0) {
                    green = 255 + green
                }
                if (red < 0) {
                    red = 255 + red
                }
                bitmap.setPixel(x, y, Color.rgb(red, green, blue))
            }
        }

        return bitmap

    }

    fun cript(photo: Bitmap, cifra: Int): Bitmap {
        var x = 0
        var y = 0

        val bitmap = photo

        for (x in 0 until bitmap.width) {
            for (y in 0 until bitmap.height) {

                var pixel = bitmap.getPixel(x, y)

                var red = Color.red(pixel) + cifra
                var blue = Color.blue(pixel) + cifra
                var green = Color.green(pixel) + cifra

                if (blue > 255) {
                    blue = blue % 255
                }
                if (green > 255) {
                    green = green % 255
                }
                if (red > 255) {
                    red = red % 255
                }
                Log.d("red", "$red")
                Log.d("green", "$green")
                Log.d("blue", "$blue")
                bitmap.setPixel(x, y, Color.argb(0, red, green, blue))
            }
        }
        return bitmap

    }

}