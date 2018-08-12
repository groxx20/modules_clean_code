package com.insomnia.example.domain.interactor.browse

import com.insomnia.example.domain.executor.PostExecutionThread
import com.insomnia.example.domain.executor.ThreadExecutor
import com.insomnia.example.domain.interactor.SingleUseCase
import com.insomnia.example.domain.models.Person
import com.insomnia.example.domain.repository.PersonRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by pparrado on 21/06/2018.
 */
class GetPersons @Inject constructor( private val personsRepository: PersonRepository, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : SingleUseCase<List<Person>, Void?> (threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Single<List<Person>> {
        return personsRepository.getPersons()
    }
}