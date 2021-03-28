package com.github.jteuber.tengwesta

import com.gitlab.jteuber.tengwesta.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PhonologyTest {

    @Test
    fun test_regularize() {
        assertEquals("nóle feanáro, aran noldoiva inque", regularize("ñōle Fëanáro, aran Ŋoldoiva inkwe"))
    }

    @Test
    fun test_tokenizer() {
        assertIterableEquals(listOf("f", "e", "a", "n", "á", "r", "o"), tokenizer("feanáro"))
        assertIterableEquals(listOf("i", "nqu", "e"), tokenizer("inque"))
        assertIterableEquals(listOf("a", "mb", "a", "rm", "e", "tt", "ai", "v", "a"), tokenizer("ambarmettaiva"))
    }

    @Test
    fun test_pseudoSyllables() {
        assertIterableEquals(listOf("fe", "an", "ár", "o"), pseudoSyllables("feanáro"))
        assertIterableEquals(listOf("inqu", "e"), pseudoSyllables("inque"))
        assertIterableEquals(listOf("amb", "arm", "ett", "aiv", "a"), pseudoSyllables("ambarmettaiva"))
    }

    @Test
    fun test_isHeavy() {
        listOf("lá", "él", "inqu", "att", "uir").forEach { assertTrue(it.isHeavy()) }
        listOf("la", "el", "if", "at", "ur").forEach { assertFalse(it.isHeavy()) }
    }

    @Test
    fun test_lengthen() {
        assertEquals("lá", "la".lengthen())
        assertEquals("lá", "lá".lengthen())
        assertEquals("ér", "er".lengthen())
        assertEquals("úr", "úr".lengthen())
    }
}