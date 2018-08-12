package com.insomnia.example.custommodules.di.modules

import com.insomnia.example.custommodules.di.scopes.PerActivity
import com.insomnia.example.custommodules.ui.MainActivity
import com.insomnia.example.domain.interactor.browse.GetPersons
import com.insomnia.example.presentation.mappers.PersonMapper
import com.insomnia.example.presentation.presenters.PersonsContract
import com.insomnia.example.presentation.presenters.PersonsPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by pparrado on 21/06/2018.
 */

@Module
class MainActivityModule {

    @PerActivity
    @Provides
    internal fun provideMainView(mainActivity: MainActivity): PersonsContract.View {
        return mainActivity
    }

    @PerActivity
    @Provides
    internal fun providePersonPresenter(mainView: PersonsContract.View, getPersons: GetPersons,
            mapper: PersonMapper): PersonsContract.Presenter {
        return PersonsPresenter(mainView, mapper, getPersons)
    }
}