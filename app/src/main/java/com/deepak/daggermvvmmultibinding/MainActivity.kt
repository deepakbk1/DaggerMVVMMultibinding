package com.deepak.daggermvvmmultibinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deepak.daggerexamplemvvm.viewmodel.ViewModel1
import com.deepak.daggerexamplemvvm.viewmodel.ViewModel2
import com.deepak.daggermvvmmultibinding.databinding.ActivityMainBinding
import com.deepak.daggermvvmmultibinding.di.component.DaggerMyComponent
import dagger.MapKey
import javax.inject.Inject
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var viewModel1: ViewModel1
    lateinit var viewModel2: ViewModel2
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        DaggerMyComponent.create().inject(this)
        viewModel1 = ViewModelProvider(this, factory).get(ViewModel1::class.java)
        activityMainBinding.viewmodel1 = viewModel1
        viewModel1.callLiveData()
        viewModel1.getMutableDataString().observe(this, Observer {
       
            Log.d("v1", it)
        })
        viewModel2 = ViewModelProvider(this, factory).get(ViewModel2::class.java)
        activityMainBinding.viewmodel2 = viewModel2
        viewModel2.callLiveData()
        viewModel2.getMutableDataString().observe(this, Observer {

            Log.d("v2", it)
        })
    }

}
