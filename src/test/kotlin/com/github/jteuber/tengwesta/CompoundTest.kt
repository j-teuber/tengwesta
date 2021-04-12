package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompoundTest {

    @Test
    fun test_compoundWithLengthening() {
        assertEquals("noldor", compoundWithLengthening(Form("noldo"), Form("r")).regularized)
        assertEquals("tyen", compoundWithLengthening(Form("tye"), Form("n")).regularized)
        assertEquals("lindalen", compoundWithLengthening(Form("lindale"), Form("n")).regularized)

        assertEquals("úcarénen", compoundWithLengthening(Form("úcare"), Form("nen")).regularized)
        assertEquals("atanatári", compoundWithLengthening(Form("atanatar"), Form("i")).regularized)
        assertEquals("oroméva", compoundWithLengthening(Form("orome"), Form("va")).regularized)

        assertEquals("oromenna", compoundWithLengthening(Form("orome"), Form("nna")).regularized)
        assertEquals("marielya", compoundWithLengthening(Form("marie"), Form("lya")).regularized)
        assertEquals("nati", compoundWithLengthening(Form("nat"), Form("i")).regularized)


    }
}