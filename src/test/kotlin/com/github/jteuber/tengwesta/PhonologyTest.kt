package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PhonologyTest {

    @Test
    fun test_regularize() {
        assertEquals("nóle feanáro, aran noldoiva inqe", Form("ñōle Fëanáro, aran Ŋoldoiva inkwe").regularized)
    }

    @Test
    fun test_tokenizer() {
        assertIterableEquals(listOf("f", "e", "a", "n", "á", "r", "o"), Form("feanáro").tokens)
        assertIterableEquals(listOf("a", "sty", "e"), Form("astye").tokens)
        assertIterableEquals(listOf("a", "mb", "a", "rm", "e", "tt", "ai", "v", "a"), Form("ambarmettaiva").tokens)
    }

    @Test
    fun test_pseudoSyllables() {
        assertIterableEquals(listOf("fe", "an", "ár", "o"), Form("feanáro").pseudoSyllables)
        assertIterableEquals(listOf("inq", "e"), Form("inqe").pseudoSyllables)
        assertIterableEquals(listOf("amb", "arm", "ett", "aiv", "a"), Form("ambarmettaiva").pseudoSyllables)
    }

    @Test
    fun test_isHeavy() {
        Form("láélinquattuir").heavySyllables.forEach { assertTrue(it) }
        Form("atanatar").heavySyllables.forEach { assertFalse(it) }
    }

    @Test
    fun test_lengthen() {
        assertEquals("lá", Form("la").lengthenedLast)
        assertEquals("lá", Form("lá").lengthenedLast)
        assertEquals("ér", Form("er").lengthenedLast)
        assertEquals("uir", Form("uir").lengthenedLast)
    }
}