package com.insomnia.example.custommodules

import com.insomnia.example.custommodules.mapper.PersonMapper
import org.junit.*
import org.junit.runner.*
import org.junit.runners.*
import kotlin.test.assertEquals

/**
 * Created by pparrado on 25/06/2018.
 */

@RunWith(JUnit4::class)
class PersonMapperTest {

    private lateinit var personMapper: PersonMapper

    @Before
    fun setUp() {
        personMapper = PersonMapper()
    }

    @Test
    fun mapToViewMapsData() {
        val bufferooView = PersonFactory.makeBufferooView()
        val bufferooViewModel = personMapper.mapToViewModel(bufferooView)

        assertEquals(bufferooView.name, bufferooViewModel.name)
        assertEquals(bufferooView.title, bufferooViewModel.title)
        assertEquals(bufferooView.avatar, bufferooViewModel.avatar)
    }

}