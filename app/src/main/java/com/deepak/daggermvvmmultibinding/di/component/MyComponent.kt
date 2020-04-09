package com.deepak.daggermvvmmultibinding.di.component

import com.deepak.daggermvvmmultibinding.MainActivity
import com.deepak.daggermvvmmultibinding.di.module.MultiBindModule
import dagger.Component

@Component(modules = [MultiBindModule::class])
interface MyComponent {
    fun inject (activity: MainActivity)
}