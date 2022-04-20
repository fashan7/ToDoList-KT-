package fr.epita.finalexam_old

import retrofit2.Call
import retrofit2.http.GET

interface WSTodo {
    @GET("todos")
    fun getAllTodo():Call<List<ToDoObject>>
}