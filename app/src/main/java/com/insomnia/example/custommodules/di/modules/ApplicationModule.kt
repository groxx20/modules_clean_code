package com.insomnia.example.custommodules.di.modules

import android.app.Application
import android.content.Context
import com.insomnia.example.custommodules.di.scopes.PerApplication
import com.insomnia.example.custommodules.BuildConfig
import com.insomnia.example.custommodules.UiThread
import com.insomnia.example.data.PersonDomainRepository
import com.insomnia.example.data.executor.JobExecutor
import com.insomnia.example.data.mappers.PersonMapper
import com.insomnia.example.data.preferences.PreferencesUtil
import com.insomnia.example.data.remote.apiservice.PersonService
import com.insomnia.example.data.remote.impl.PersonRemoteImpl
import com.insomnia.example.data.remote.servicefactory.PersonServiceFactory
import com.insomnia.example.data.repository.PersonRemote
import com.insomnia.example.data.source.PersonDataStoreFactory
import com.insomnia.example.domain.executor.PostExecutionThread
import com.insomnia.example.domain.executor.ThreadExecutor
import com.insomnia.example.domain.repository.PersonRepository
import dagger.Module
import dagger.Provides

/**
 * Created by pparrado on 20/06/2018.
 */

@Module
open class ApplicationModule {


    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferences(context: Context): PreferencesUtil {
        return PreferencesUtil(context)
    }

    @Provides
    @PerApplication
    internal fun providePersonRemoteImpl(service: PersonService, factory: PersonMapper): PersonRemote {
        return PersonRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun providePersonRepository(factory: PersonDataStoreFactory, mapper: PersonMapper): PersonRepository {
        return PersonDomainRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun providePersonService(): PersonService {
        return PersonServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}