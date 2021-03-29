package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PhonologyTest {

    @Test
    fun test_regularize() {
        assertEquals("nóle feanáro, aran noldoiva inqe", Word("ñōle Fëanáro, aran Ŋoldoiva inkwe").regularized)
    }

    @Test
    fun test_tokenizer() {
        assertIterableEquals(listOf("f", "e", "a", "n", "á", "r", "o"), Word("feanáro").tokens)
        assertIterableEquals(listOf("a", "sty", "e"), Word("astye").tokens)
        assertIterableEquals(listOf("a", "mb", "a", "rm", "e", "tt", "ai", "v", "a"), Word("ambarmettaiva").tokens)
    }

    @Test
    fun test_pseudoSyllables() {
        assertIterableEquals(listOf("fe", "an", "ár", "o"), Word("feanáro").pseudoSyllables)
        assertIterableEquals(listOf("inq", "e"), Word("inqe").pseudoSyllables)
        assertIterableEquals(listOf("amb", "arm", "ett", "aiv", "a"), Word("ambarmettaiva").pseudoSyllables)
    }

    @Test
    fun test_isHeavy() {
        Word("láélinquattuir").heavySyllables.forEach { assertTrue(it) }
        Word("atanatar").heavySyllables.forEach { assertFalse(it) }
    }

    @Test
    fun test_lengthen() {
        assertEquals("lá", Word("la").lengthenedLast)
        assertEquals("lá", Word("lá").lengthenedLast)
        assertEquals("ér", Word("er").lengthenedLast)
        assertEquals("uir", Word("uir").lengthenedLast)
    }
}