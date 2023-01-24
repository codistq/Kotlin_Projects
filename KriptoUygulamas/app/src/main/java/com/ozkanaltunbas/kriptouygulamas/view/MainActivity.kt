package com.ozkanaltunbas.kriptouygulamas.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozkanaltunbas.kriptouygulamas.R
import com.ozkanaltunbas.kriptouygulamas.adapter.RecyclerViewAdapter
import com.ozkanaltunbas.kriptouygulamas.databinding.ActivityMainBinding
import com.ozkanaltunbas.kriptouygulamas.model.CryptoModel
import com.ozkanaltunbas.kriptouygulamas.service.CryptoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() , RecyclerViewAdapter.Listener {
    private lateinit var binding : ActivityMainBinding
    private val BASE_URL = "https://raw.githubusercontent.com/"
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    //Disposable //->bir defa kullanıp atar.
    private var compositeDisposable : CompositeDisposable? = null

    //gelen verileri alcağımız liste
    private var cryptoModels: ArrayList<CryptoModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
        compositeDisposable = CompositeDisposable()

        //recyclerView tanımlama
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        loadData()

    }

    private fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CryptoAPI::class.java)

        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe())







        /*
        //burada retrofit ile API yi birbirine bağlıyoruz.

                val service = retrofit.create(CryptoAPI::class.java)

        //call oluşturduk --> services içinde getData oluturduk.



    val call = service.getData()

        //hazırladığımız isteği yollar
        call.enqueue(object : Callback<List<CryptoModel>> {
            override fun onResponse(
                call: Call<List<CryptoModel>>,
                response: Response<List<CryptoModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        cryptoModels = ArrayList(it)

                        cryptoModels?.let {

                           recyclerViewAdapter  = RecyclerViewAdapter(it,this@MainActivity)
                            binding.recyclerView.adapter = recyclerViewAdapter
                        }



                        for(crymo : CryptoModel in cryptoModels!!){
                            println(crymo.price)
                            println(crymo.currency)
                        }


                    }
                }


            }

            override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })

         */
    }

    private fun handleResponse(cryptoList: List<CryptoModel>){
        cryptoModels = ArrayList(cryptoList)
        cryptoModels?.let {

            recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
            binding.recyclerView.adapter = recyclerViewAdapter
        }
    }

    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(this,"Clicked-->${cryptoModel.currency}",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
    }
}