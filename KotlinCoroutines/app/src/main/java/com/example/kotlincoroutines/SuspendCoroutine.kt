package com.example.kotlincoroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(){
    var name = ""
    var age = 0

    runBlocking {
        val downloadedName = async {
           downloadName()
        }
        val downloadedAge = async {
            downloadAge()
        }

        name = downloadedName.await()
        age = downloadedAge.await()
        println(name)
        println(age)


    }

}



suspend fun downloadName() : String {
  //  println("Download name")
    return "OZKAN"
}
suspend fun downloadAge() : Int {
  //  println("Download Age")
    return 50
}