package com.deepak.daggerexamplemvvm.repository

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class Repository2 @Inject constructor() {
    private val mutableLiveData = MutableLiveData<String>()
    fun getData(): String {
        return "This is dagger mvvm"
    }

    fun getMutableData() {
        mutableLiveData.value = "This is Repository2"
    }

    fun getMutableDataString(): MutableLiveData<String> {
        return mutableLiveData
    }
}