package com.insomnia.example.presentation.mappers

import com.insomnia.example.domain.models.Person
import com.insomnia.example.presentation.models.PersonView
import javax.inject.Inject

/**
 * Created by pparrado on 21/06/2018.
 */
open class PersonMapper @Inject constructor() : Mapper<PersonView, Person> {

    override fun mapToView(type: Person): PersonView {
        return PersonView(type.name, type.title, type.avatar)
    }
}