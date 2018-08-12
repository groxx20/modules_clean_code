package com.insomnia.example.custommodules.mapper

import com.insomnia.example.custommodules.models.Person
import com.insomnia.example.presentation.models.PersonView
import javax.inject.Inject

/**
 * Created by pparrado on 21/06/2018.
 */
open class PersonMapper @Inject constructor(): Mapper<Person, PersonView> {

    /**
     * Map a [BufferooView] instance to a [BufferooViewModel] instance
     */
    override fun mapToViewModel(type: PersonView): Person {
        return Person(type.name, type.title, type.avatar)
    }

}