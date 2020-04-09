package com.deepak.daggerexamplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deepak.daggerexamplemvvm.repository.Repository1
import com.deepak.daggerexamplemvvm.repository.Repository2

import javax.inject.Inject

class ViewModel2 @Inject constructor(private val repository2: Repository2) : ViewModel() {
    var resultData = MutableLiveData<String>()
    fun getDataViewModel(): String {
        val mydagger = repository2.getData()
        return mydagger
    }

    fun callLiveData() {
        repository2.getMutableData()
    }

    fun getMutableDataString(): MutableLiveData<String> {
        resultData = repository2.getMutableDataString()
        return resultData
    }
}
