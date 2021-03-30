package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompoundTest {

    @Test
    fun test_compound() {
        assertEquals("noldor", compound(Morpheme("noldo"), Morpheme("r")))
        assertEquals("tyen", compound(Morpheme("tye"), Morpheme("n")))
        assertEquals("lindalen", compound(Morpheme("lindale"), Morpheme("n")))

        assertEquals("úcarénen", compound(Morpheme("úcare"), Morpheme("nen")))
        assertEquals("atanatári", compound(Morpheme("atanatar"), Morpheme("i")))
        assertEquals("oroméva", compound(Morpheme("orome"), Morpheme("va")))

        assertEquals("oromenna", compound(Morpheme("orome"), Morpheme("nna")))
        assertEquals("marielya", compound(Morpheme("marie"), Morpheme("lya")))
        assertEquals("nati", compound(Morpheme("nat"), Morpheme("i")))


    }
}