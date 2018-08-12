package com.insomnia.example.custommodules.di.modules

import com.insomnia.example.custommodules.di.scopes.PerActivity
import com.insomnia.example.custommodules.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by pparrado on 21/06/2018.
 */
@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}