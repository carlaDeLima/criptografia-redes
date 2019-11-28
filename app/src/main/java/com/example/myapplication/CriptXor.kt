package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.Color

class CriptXor {

    fun decript(photo: Bitmap, cifra: Int): Bitmap {
        val bmp = Bitmap.createBitmap(photo.width, photo.height, Bitmap.Config.ARGB_8888)
        for (x in 0 until photo.width) {
            for (y in 0 until photo.height) {

                val pixel = photo.getPixel(x, y)

                val red = cifra xor Color.red(pixel)
                val blue = cifra xor Color.blue(pixel)
                val green = cifra xor Color.green(pixel)

                //OBS: CIFRA MAXIMA DE 256

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

                val red = Color.red(pixel) xor cifra
                val blue = Color.blue(pixel) xor cifra
                val green = Color.green(pixel) xor cifra

                //OBS: CIFRA MAXIMA DE 256

                bmp.setPixel(x, y, Color.rgb(red, green, blue))
            }
        }

        return bmp
    }
}