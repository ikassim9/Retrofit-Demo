package com.ismail.retrofitdemo

import retrofit2.Call
import retrofit2.http.GET
interface AlbumApi {

    @GET("albums")
    fun getAlbums() : Call<Album>

}