package com.example.mvvm_retrofit.network.repoistory

import com.example.mvvm_retrofit.network.response.PostResponse
import com.example.mvvm_retrofit.network.retrofit.RetrofitClient
import io.reactivex.ObservableSource
import io.reactivex.SingleSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object MainRepository {
    private val apiServices = RetrofitClient.apiServices
    fun getPostsDataWithName() {
        var disposable = apiServices.getPosts()
            .subscribeOn(Schedulers.io())
            .flatMap { response ->
                SingleSource<PostResponse> {

                }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }


    //    fun getPostsDataWithName(): LiveData<PostResponse> {
    //        var response = MutableLiveData<PostResponse>()
    //        apiServices.getPosts()
    //            .subscribeOn(Schedulers.io())
    //            .observeOn(AndroidSchedulers.mainThread())
    //            .subscribe(object: DisposableSingleObserver<PostResponse>(){
    //                override fun onSuccess(res: PostResponse) {
    //                    response.postValue(res)
    //                    dispose()
    //                }
    //
    //                override fun onError(e: Throwable) {
    //                    e.printStackTrace()
    //                }
    //            })
    //        return response
    //    }

}