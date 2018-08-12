package com.insomnia.example.custommodules.di.components

import android.app.Application
import com.insomnia.example.custommodules.ModulesApp
import com.insomnia.example.custommodules.di.modules.ActivityBindingModule
import com.insomnia.example.custommodules.di.modules.ApplicationModule
import com.insomnia.example.custommodules.di.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by pparrado on 20/06/2018.
 */

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: ModulesApp)

}
