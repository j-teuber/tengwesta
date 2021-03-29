package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompoundTest {

    @Test
    fun test_compound() {
        assertEquals("noldor", compound("noldo", "r"))
        assertEquals("tyen", compound("tye", "n"))
        assertEquals("lindalen", compound("lindale", "n"))

        assertEquals("úcarénen", compound("úcare", "nen"))
        assertEquals("atanatári", compound("atanatar", "i"))
        assertEquals("oroméva", compound("orome", "va"))

        assertEquals("oromenna", compound("orome", "nna"))
        assertEquals("marielya", compound("marie", "lya"))
    }
}