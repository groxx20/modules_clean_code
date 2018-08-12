package com.insomnia.example.data.remote.apiservice

import com.insomnia.example.domain.models.Person
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by pparrado on 19/06/2018.
 */
interface PersonService {

    @GET("team.json")
    fun getBufferoos(): Single<PersonResponse>

    class PersonResponse {
        lateinit var team: List<Person>
    }
}