package com.example.kotlincoroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    //Job-->döndürülen işleri kontrol edebiliriz.
    runBlocking {
      val job =   launch {
            println("Job")
          launch {
              println("Job 2")
          }
        }
        //jon bitince şu işi yap demek.
        job.invokeOnCompletion {
            println("When job is finish i called")
        }

        job.cancel()

    }

}