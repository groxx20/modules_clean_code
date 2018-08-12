package com.insomnia.example.data

import com.insomnia.example.data.mappers.PersonMapper
import com.insomnia.example.data.source.PersonDataStoreFactory
import com.insomnia.example.domain.models.Person
import com.insomnia.example.domain.repository.PersonRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by pparrado on 20/06/2018.
 */
class PersonDomainRepository @Inject constructor(private val factory: PersonDataStoreFactory,
        private val personMapper: PersonMapper) : PersonRepository {

    override fun getPersons(): Single<List<Person>> {
        val dataStore = factory.retrievePersonRemoteData()

        return dataStore.getPersons()
                .map { list ->
                    list.map { listItem ->
                        personMapper.mapFromEntity(listItem)
                    }
                }
    }
}