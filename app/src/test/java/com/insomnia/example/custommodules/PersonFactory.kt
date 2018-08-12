package com.insomnia.example.custommodules

import com.insomnia.example.custommodules.DataFactory.Factory.randomUuid
import com.insomnia.example.presentation.models.PersonView

/**
 * Created by pparrado on 25/06/2018.
 */

class PersonFactory {

    companion object Factory {

        fun makeBufferooView(): PersonView {
            return PersonView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}