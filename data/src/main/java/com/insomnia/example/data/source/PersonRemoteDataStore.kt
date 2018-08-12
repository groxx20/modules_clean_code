package com.insomnia.example.data.source

import com.insomnia.example.data.models.PersonEntity
import com.insomnia.example.data.repository.PersonDataStore
import com.insomnia.example.data.repository.PersonRemote
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by pparrado on 20/06/2018.
 */
open class PersonRemoteDataStore @Inject constructor(private val bufferooRemote: PersonRemote) :
        PersonDataStore {


    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getPersons(): Single<List<PersonEntity>> {
        return bufferooRemote.getPersons()
    }

}