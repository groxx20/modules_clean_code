package com.insomnia.example.data.remote.impl

import com.insomnia.example.data.mappers.PersonMapper
import com.insomnia.example.data.models.PersonEntity
import com.insomnia.example.data.remote.apiservice.PersonService
import com.insomnia.example.data.repository.PersonRemote
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by pparrado on 19/06/2018.
 */
class PersonRemoteImpl @Inject constructor(private val bufferooService: PersonService,
        private val entityMapper: PersonMapper) :
        PersonRemote {

    /**
     * Retrieve a list of [PersonEntity] instances from the [PersonService].
     */
    override fun getPersons(): Single<List<PersonEntity>> {
        return bufferooService.getBufferoos()
                .map {
                    it.team.map { listItem ->
                        entityMapper.mapToEntity(listItem)
                    }
                }
    }
}