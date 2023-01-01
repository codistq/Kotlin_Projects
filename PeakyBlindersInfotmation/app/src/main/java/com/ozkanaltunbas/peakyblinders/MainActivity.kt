package com.ozkanaltunbas.peakyblinders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //isim bölümü.
        var names = ArrayList<String>()
        names.add("Tommy Michael Shelby")
        names.add("Arthur Shelby")
        names.add("John Michael Shelby")
        names.add("Michael Gray")
            //description bölümü.
        var descr = ArrayList<String>()
        descr.add("Thomas Michael Shelby was born in 1890, " +
                "to Arthur and Mrs. Shelby. He was born on a " +
                "boat, in a barge called ‘The January’ and had " +
                "an elder brother, Arthur Shelby, who he was extremely " +
                "close with as a child. Over the years, Thomas’ parents welcomed " +
                "three more children, John, Ada and Finn Shelby.")

        descr.add("Arthur Shelby is the eldest son of Arthur and Mrs Shelby," +
                " older brother of Thomas, John, Ada and Finn Shelby, " +
                "as well as being the father of Billy Shelby. ")

        descr.add("John Michael Shelby was the third son of Arthur Shelby Sr, brother of Arthur, Thomas, " +
                "Ada and Finn Shelby, as well as being the husband of Esme Shelby.")

        descr.add("Michael Gray, introduced in the second season, the son of Polly Shelby, the cousin of the Shelby siblings, " +
                "and a former powerful and high ranking member of the Peaky Blinders.")

        //fotoğrafları int türünde değişken atadım.
        val tommyDrawableID = R.drawable.tommy
        val arthurDrawableID = R.drawable.arthur
        val johnDrawableID = R.drawable.john
        val michaelDrawableID = R.drawable.michael

        //fotoğraf bölümü

        val photos = ArrayList<Int>()
        photos.add(tommyDrawableID)
        photos.add(arthurDrawableID)
        photos.add(johnDrawableID)
        photos.add(michaelDrawableID)

        //MainActicy de görünecek olan arayüz alt alta olacak şekilde belirledik
        val layoutManager = LinearLayoutManager(this)
        //MainActivityde arayüze ki recyclerView a layout manageri bağladık
        recyclerView.layoutManager  = layoutManager


        val adapter = RecyclerAdapter(names,photos,descr)
        //işte burada tüm içeriği aldık ve bağladık.
        recyclerView.adapter = adapter










    }
}