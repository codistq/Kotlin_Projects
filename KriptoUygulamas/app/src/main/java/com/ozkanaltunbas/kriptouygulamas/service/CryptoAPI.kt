package com.ozkanaltunbas.kriptouygulamas.service

import com.ozkanaltunbas.kriptouygulamas.model.CryptoModel
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //burada endpointten istek için arayüz oluşturmamız lazım.
    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

    //burada endpoint verilir.
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    //yayınına abone olana bilgi veren obje.
    fun getData() : Observable<List<CryptoModel>>

  //  fun getData() : Call<List<CryptoModel>> //-->fonksiyon ile Cryptolisti bir liste halinde alıyoruz.
}