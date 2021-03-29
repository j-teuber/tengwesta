package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompoundTest {

    @Test
    fun test_compound() {
        assertEquals("noldor", compound(Word("noldo"), Word("r")))
        assertEquals("tyen", compound(Word("tye"), Word("n")))
        assertEquals("lindalen", compound(Word("lindale"), Word("n")))

        assertEquals("úcarénen", compound(Word("úcare"), Word("nen")))
        assertEquals("atanatári", compound(Word("atanatar"), Word("i")))
        assertEquals("oroméva", compound(Word("orome"), Word("va")))

        assertEquals("oromenna", compound(Word("orome"), Word("nna")))
        assertEquals("marielya", compound(Word("marie"), Word("lya")))
        assertEquals("nati", compound(Word("nat"), Word("i")))


    }
}