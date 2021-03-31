package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompoundTest {

    @Test
    fun test_compoundWithLengthening() {
        assertEquals("noldor", compoundWithLengthening(Morpheme("noldo"), Morpheme("r")).regularized)
        assertEquals("tyen", compoundWithLengthening(Morpheme("tye"), Morpheme("n")).regularized)
        assertEquals("lindalen", compoundWithLengthening(Morpheme("lindale"), Morpheme("n")).regularized)

        assertEquals("úcarénen", compoundWithLengthening(Morpheme("úcare"), Morpheme("nen")).regularized)
        assertEquals("atanatári", compoundWithLengthening(Morpheme("atanatar"), Morpheme("i")).regularized)
        assertEquals("oroméva", compoundWithLengthening(Morpheme("orome"), Morpheme("va")).regularized)

        assertEquals("oromenna", compoundWithLengthening(Morpheme("orome"), Morpheme("nna")).regularized)
        assertEquals("marielya", compoundWithLengthening(Morpheme("marie"), Morpheme("lya")).regularized)
        assertEquals("nati", compoundWithLengthening(Morpheme("nat"), Morpheme("i")).regularized)


    }
}