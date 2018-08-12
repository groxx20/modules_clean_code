package com.modules.example.presentation.presenters

import com.modules.example.presentation.BasePresenter
import com.modules.example.presentation.BaseView
import com.modules.example.presentation.models.PersonView

/**
 * Created by pparrado on 21/06/2018.
 */
interface PersonsContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showPersons(persons: List<PersonView>)

        fun hidePersons()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()
    }


    interface Presenter : BasePresenter {

        fun retrievePersons()

    }
}