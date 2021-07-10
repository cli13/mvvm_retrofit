package com.example.mvvm_retrofit.network.repoistory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_retrofit.network.response.*
import com.example.mvvm_retrofit.network.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

object MainRepository {
    private val apiServices = RetrofitClient.apiServices
    fun getPostsDataWithName(): LiveData<List<User>> {
        val response = MutableLiveData<List<User>>()
        getPostsData()
            .subscribeOn(Schedulers.io())
            .flatMap {
                getMainUser(it.body, it.title, apiServices.getUser(it.userId.toString()).toObservable())
            }.toList().subscribeWith(object : Observer<List<User>>,
                SingleObserver<MutableList<User>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: List<User>) {

                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }

                override fun onSuccess(t: MutableList<User>) {
                    response.postValue(t)
                    Log.d("TAG", "onSuccess: ${t.size}")
                }
            })
        return response
    }

    private fun getMainUser(body: String, title: String, toObservable: Observable<UserResponseItem>): Observable<User>? {
        return toObservable?.map { userResponseItem ->
            User(title, body, userResponseItem.name)
        }
    }

    private fun getPostsData(): Observable<PostResponseItem> {
        return apiServices.getPosts().toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { response ->
                Observable.fromIterable(response)
                    .subscribeOn(Schedulers.io())
            }
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