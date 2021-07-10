package com.example.mvvm_retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit.databinding.ActivityMainBinding
import com.example.mvvm_retrofit.ui.adapters.PostAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var vm : MainViewModel
    lateinit var postAdapter : PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        postAdapter = PostAdapter(emptyList())
        binding.recyclerView.adapter = postAdapter


        vm.getPost()?.observe(this) {
            postAdapter.updateList(it)
        }
    }
}