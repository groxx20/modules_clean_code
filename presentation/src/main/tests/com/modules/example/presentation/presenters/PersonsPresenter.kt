package com.modules.example.presentation.presenters

import com.modules.example.domain.interactor.SingleUseCase
import com.modules.example.domain.models.Person
import com.modules.example.presentation.mappers.PersonMapper
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by pparrado on 21/06/2018.
 */

class PersonsPresenter(val personView: PersonsContract.View, val personMapper: PersonMapper,
        val personUseCase: SingleUseCase<List<Person>, Void>) : PersonsContract.Presenter {

    override fun start() {
        retrievePersons()
    }

    override fun stop() {
        personUseCase.dispose()
    }

    override fun retrievePersons() {

        personUseCase.execute(PersonSubscriber())
    }

    internal fun handlePersonSuccess(persons: List<Person>) {

        personView.hideErrorState()
        if (persons.isNotEmpty()) {
            personView.hideEmptyState()
            personView.showPersons(persons.map { personMapper.mapToView(it) })
        } else {
            personView.hidePersons()
            personView.showEmptyState()
        }
    }

    inner class PersonSubscriber : DisposableSingleObserver<List<Person>>() {
        override fun onSuccess(t: List<Person>) {
            handlePersonSuccess(t)
        }

        override fun onError(e: Throwable) {
            personView.hidePersons()
            personView.hideEmptyState()
            personView.showErrorState()
        }
    }
}