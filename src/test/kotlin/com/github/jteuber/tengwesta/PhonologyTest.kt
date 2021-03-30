package com.github.jteuber.tengwesta

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PhonologyTest {

    @Test
    fun test_regularize() {
        assertEquals("nóle feanáro, aran noldoiva inqe", Morpheme("ñōle Fëanáro, aran Ŋoldoiva inkwe").regularized)
    }

    @Test
    fun test_tokenizer() {
        assertIterableEquals(listOf("f", "e", "a", "n", "á", "r", "o"), Morpheme("feanáro").tokens)
        assertIterableEquals(listOf("a", "sty", "e"), Morpheme("astye").tokens)
        assertIterableEquals(listOf("a", "mb", "a", "rm", "e", "tt", "ai", "v", "a"), Morpheme("ambarmettaiva").tokens)
    }

    @Test
    fun test_pseudoSyllables() {
        assertIterableEquals(listOf("fe", "an", "ár", "o"), Morpheme("feanáro").pseudoSyllables)
        assertIterableEquals(listOf("inq", "e"), Morpheme("inqe").pseudoSyllables)
        assertIterableEquals(listOf("amb", "arm", "ett", "aiv", "a"), Morpheme("ambarmettaiva").pseudoSyllables)
    }

    @Test
    fun test_isHeavy() {
        Morpheme("láélinquattuir").heavySyllables.forEach { assertTrue(it) }
        Morpheme("atanatar").heavySyllables.forEach { assertFalse(it) }
    }

    @Test
    fun test_lengthen() {
        assertEquals("lá", Morpheme("la").lengthenedLast)
        assertEquals("lá", Morpheme("lá").lengthenedLast)
        assertEquals("ér", Morpheme("er").lengthenedLast)
        assertEquals("uir", Morpheme("uir").lengthenedLast)
    }
}