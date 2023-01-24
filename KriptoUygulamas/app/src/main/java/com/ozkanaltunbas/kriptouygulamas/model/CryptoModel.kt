package com.ozkanaltunbas.kriptouygulamas.model

import com.google.gson.annotations.SerializedName

//data sınıfının amacı-->veri çekeceğimiz gösteriririz
data class CryptoModel(
    //ama internetten gelecek veri ile değişken isimleri aynı ise Serialized yapmama gerek yok.
 //   @SerializedName("currency") //-->internetten bir değer gelecek adı "currency" bunu alltaki değişkene ata
    val currency : String ,
  //  @SerializedName("price") //-->internetten bir değer gelecek adı "currency" bunu alltaki değişkene ata
    val price : String
)
