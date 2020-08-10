package com.ismail.retrofitdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

     private fun retrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val albumAPi: AlbumApi by lazy {
        retrofitInstance().create(AlbumApi::class.java)
    }
}
