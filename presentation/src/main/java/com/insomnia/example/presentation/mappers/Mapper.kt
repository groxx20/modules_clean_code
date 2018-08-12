package com.insomnia.example.presentation.mappers

/**
 * Created by pparrado on 21/06/2018.
 */

interface Mapper<out V, in D> {

    fun mapToView(type: D): V

}