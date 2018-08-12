package com.insomnia.example.data.mappers

import com.insomnia.example.data.models.PersonEntity
import com.insomnia.example.domain.models.Person
import javax.inject.Inject

/**
 * Created by pparrado on 19/06/2018.
 */
open class PersonMapper @Inject constructor(): Mapper<PersonEntity, Person> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: PersonEntity): Person {
        return Person(type.name, type.title, type.avatar)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Person): PersonEntity {
        return PersonEntity(type.name, type.title, type.avatar)
    }


}