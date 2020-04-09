package com.deepak.daggerexamplemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deepak.daggerexamplemvvm.repository.Repository1

import javax.inject.Inject

class ViewModel1 @Inject constructor(private val repository1: Repository1) : ViewModel() {
    var resultData = MutableLiveData<String>()
    fun getDataViewModel(): String {
        val mydagger = repository1.getData()
        return mydagger
    }

    fun callLiveData() {
        repository1.getMutableData()
    }

    fun getMutableDataString(): MutableLiveData<String> {
        resultData = repository1.getMutableDataString()
        return resultData
    }
}
