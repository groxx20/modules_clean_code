package com.insomnia.example.custommodules.mapper

/**
 * Created by pparrado on 21/06/2018.
 */
interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V

}