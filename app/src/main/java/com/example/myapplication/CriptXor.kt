package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.Color
import kotlin.experimental.xor

class CriptXor {
    fun decript(photo: Bitmap, cifra: Int): Bitmap {
        val bmp = Bitmap.createBitmap(photo.width, photo.height, Bitmap.Config.ARGB_8888)
        for (x in 0 until photo.width) {
            for (y in 0 until photo.height) {
                val pixel = photo.getPixel(x, y)

                var red =   cifra xor Color.red(pixel)
                var blue =  cifra xor Color.blue(pixel)
                var green = cifra xor Color.green(pixel)
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
                var red = Color.red(pixel) xor cifra
                var blue = Color.blue(pixel) xor cifra
                var green = Color.green(pixel) xor cifra

                //OBS: CIFRA MAXIMA DE 256

                bmp.setPixel(x, y, Color.rgb(red, green, blue))
            }
        }
        return bmp

    }
}