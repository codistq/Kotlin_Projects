package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import java.sql.Timestamp
import java.util.Timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            launch(Dispatchers.Main) {
                println("Main-->${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default -->${Thread.currentThread().name}")
            }
            launch(Dispatchers.IO) {
                println("IO -->${Thread.currentThread().name}")
            }
            launch(Dispatchers.Unconfined) {
                println("Unconfined-->${Thread.currentThread().name}")
            }
        }





    }
}