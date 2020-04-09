package com.deepak.daggermvvmmultibinding.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deepak.daggerexamplemvvm.viewmodel.ViewModel1
import com.deepak.daggerexamplemvvm.viewmodel.ViewModel2
import com.deepak.daggermvvmmultibinding.factory.DaggerViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
internal abstract class MultiBindModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ViewModel1::class)
    abstract fun bindViewModel1(viewModel1: ViewModel1): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModel2::class)
    abstract fun bindViewModel2(viewModel2: ViewModel2): ViewModel
}

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)