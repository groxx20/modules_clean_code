package com.insomnia.example.domain.repository

import com.insomnia.example.domain.models.Person
import io.reactivex.Single

/**
 * Created by pparrado on 20/06/2018.
 */
interface PersonRepository {

    fun getPersons(): Single<List<Person>>
}