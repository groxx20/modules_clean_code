package com.insomnia.example.data.mappers

/**
 * Created by pparrado on 19/06/2018.
 */
interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}