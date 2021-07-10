package com.example.mvvm_retrofit.network.retrofit

import com.example.mvvm_retrofit.network.response.PostResponse
import com.example.mvvm_retrofit.network.response.UserResponse
import com.example.mvvm_retrofit.network.response.UserResponseItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("posts")
    fun getPosts() : Single<PostResponse>

    @GET("users")
    fun getUsers() : Single<UserResponse>

    @GET("users/{id}")
    fun getUser(@Path("id") id : String) : Single<UserResponseItem>
}