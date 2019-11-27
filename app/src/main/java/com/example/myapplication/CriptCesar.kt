package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.Color

class CriptCesar {

    fun decript(photo: Bitmap, cifra: Int): Bitmap {
        val bmp = Bitmap.createBitmap(photo.width, photo.height, Bitmap.Config.ARGB_8888)
        for (x in 0 until photo.width) {
            for (y in 0 until photo.height) {
                val pixel = photo.getPixel(x, y)

                var red = Color.red(pixel) - cifra
                var blue = Color.blue(pixel) - cifra
                var green = Color.green(pixel) - cifra

                if (blue < 0) {
                    blue += 255
                }
                if (green < 0) {
                    green += 255
                }
                if (red < 0) {
                    red += 255
                }

                bmp.setPixel(x, y, Color.rgb(red, green, blue))
            }
        }

        return bmp

    }

    fun cript(photo: Bitmap, cifra: Int): Bitmap {
        val bmp = Bitmap.createBitmap(photo.width, photo.height, Bitmap.Config.ARGB_8888)
        for (x in 0 until photo.width) {
            for (y in 0 until photo.height) {

                val pixel = photo.getPixel(x, y)

                var red = Color.red(pixel) + cifra
                var blue = Color.blue(pixel) + cifra
                var green = Color.green(pixel) + cifra

                if (blue > 255) {
                    blue %= 255
                }
                if (green > 255) {
                    green %= 255
                }
                if (red > 255) {
                    red %= 255
                }

                bmp.setPixel(x, y, Color.rgb(red, green, blue))
            }
        }
        return bmp

    }

}