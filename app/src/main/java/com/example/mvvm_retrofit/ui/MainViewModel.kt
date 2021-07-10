package com.example.mvvm_retrofit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_retrofit.network.repoistory.MainRepository
import com.example.mvvm_retrofit.network.response.User

class MainViewModel() : ViewModel() {

    var userPostData : LiveData<List<User>>? = null

    fun getPost() : LiveData<List<User>>?{
        userPostData = MainRepository.getPostsDataWithName()
        return userPostData
    }
}