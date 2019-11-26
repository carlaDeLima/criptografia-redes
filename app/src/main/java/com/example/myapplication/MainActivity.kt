package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val RESULT_LOAD_IMAGE = 1
    }

    private var cesarClick = false
    private var cripClick = false
    private var sDesClick = false

    private var teste: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uploadButton.setOnClickListener {
            //cesarClick
            val i = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(i, RESULT_LOAD_IMAGE)
        }

        cesarButton.setOnClickListener {
            cesarClick = if (cesarClick) {
                cripClick = false
                cripButton.isEnabled = true

                sDesClick = false
                s_des_Button.isEnabled = true
                false
            } else {
                cripClick = false
                cripButton.isEnabled = false

                sDesClick = false
                s_des_Button.isEnabled = false

                teste?.let {
                    imageUpload.setImageBitmap(CriptCesar().cript(it, 5))
                }
                true
            }
        }
        cripButton.setOnClickListener {
            cripClick = if (cripClick) {
                cesarClick = false
                cesarButton.isEnabled = true

                sDesClick = false
                s_des_Button.isEnabled = true
                false
            } else {
                cesarClick = false
                cesarButton.isEnabled = false

                sDesClick = false
                s_des_Button.isEnabled = false
                true
            }
        }
        s_des_Button.setOnClickListener {
            sDesClick = if (sDesClick) {
                cesarClick = false
                cesarButton.isEnabled = true

                cripClick = false
                cripButton.isEnabled = true
                false
            } else {
                cesarClick = false
                cesarButton.isEnabled = false

                cripClick = false
                cripButton.isEnabled = false
                true
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            val selectedImage = data.data
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
            cursor!!.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val picturePath = cursor.getString(columnIndex)
            cursor.close()
            imageUpload.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            teste = BitmapFactory.decodeFile(picturePath)

        }
    }
}
