package fr.epita.finalexam_old

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://jsonplaceholder.typicode.com/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
    .build()

object API {
    val service : WSTodo = retrofit.create(WSTodo::class.java)
}