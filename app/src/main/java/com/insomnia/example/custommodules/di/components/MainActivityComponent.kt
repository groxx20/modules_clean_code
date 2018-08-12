package com.insomnia.example.custommodules.di.components

import com.insomnia.example.custommodules.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by pparrado on 21/06/2018.
 */
@Subcomponent
interface MainActivityComponent  : AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MainActivity>()

}