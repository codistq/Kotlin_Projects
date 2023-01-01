package com.ozkanaltunbas.peakyblinders

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_desciription.*

class DesciriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desciription)

        intent = intent
      val Names =   intent.getStringExtra("Names")
        textView.text = Names
      val Desc  =   intent.getStringExtra("Desc")
        textView2.text = Desc

      val Images  = intent.getIntExtra("Images",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,Images)
        imageView.setImageBitmap(bitmap)


    }
}