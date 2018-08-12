package com.insomnia.example.presentation

/**
 * Created by pparrado on 21/06/2018.
 */


interface BaseView<in T : BasePresenter> {

    fun setPresenter(presenter: T)

}