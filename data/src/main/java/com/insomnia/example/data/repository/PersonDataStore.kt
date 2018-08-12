package com.insomnia.example.data.repository

import com.insomnia.example.data.models.PersonEntity
import io.reactivex.Single

/**
 * Created by pparrado on 19/06/2018.
 */
interface PersonDataStore {

    fun getPersons(): Single<List<PersonEntity>>
}