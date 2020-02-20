package com.example.fakedatas.singleton

import com.example.fakedatas.datas.Model
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/users?page=2")
    fun allList(): Call<Model>
}