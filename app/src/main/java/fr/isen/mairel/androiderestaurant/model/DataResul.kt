package fr.isen.mairel.androidrestaurant.model

import com.google.gson.annotations.SerializedName


data class DataResul (

  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

)