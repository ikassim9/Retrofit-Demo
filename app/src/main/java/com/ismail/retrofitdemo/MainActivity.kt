package com.ismail.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service: AlbumApi  = RetrofitClient.albumAPi
        val call : Call<Album>   =  service.getAlbums()

            call.enqueue(object : Callback<Album>{
                override fun onFailure(call: Call<Album>, t: Throwable) {
                    text_view_result.text = t.message
                }
                override fun onResponse(call: Call<Album>, response: Response<Album>) {
                    if(!response.isSuccessful){
                        text_view_result.text = response.code().toString()
                        Log.d("response_fai", "unsuccessful response: ${response.code().toString()}  \n" + "\n")
                        return
                    }
                    val albums  = response.body()
                    val size =albums?.size
                    if (albums != null) {
                        for (item in albums) {
                            var content = ""
                            content += "User ID: ${item.userId} \n"
                            content += "Album ID : ${item.id}  \n"
                            content += "Album Title: ${item.title} \n\n"
                            text_view_result.append(content)
                            Log.i("response_successful", "response is successful")
                        }
                    }
                    }

            })

    }
}