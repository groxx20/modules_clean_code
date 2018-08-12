package com.insomnia.example.data.source

import com.insomnia.example.data.repository.PersonDataStore
import javax.inject.Inject

/**
 * Created by pparrado on 20/06/2018.
 */
open class PersonDataStoreFactory @Inject constructor(private val personRemoteDataStore: PersonRemoteDataStore){

    open fun retrievePersonRemoteData() : PersonDataStore {

        return personRemoteDataStore
    }
}