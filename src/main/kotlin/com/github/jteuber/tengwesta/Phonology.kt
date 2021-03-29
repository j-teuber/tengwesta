package com.github.jteuber.tengwesta

import kotlin.text.StringBuilder

val shortVowels = listOf( "a", "e", "i", "o", "u" )
val longVowels = listOf( "á", "é", "í", "ó", "ú" )
val longVowelMap = (shortVowels zip longVowels).toMap()
val vowels = shortVowels + longVowels
val diphthongs = listOf( "ai", "au", "oi", "ui", "eu", "iu" )
val vowelClusters = listOf("ea")
val vowelAssimilation = mapOf(
    "aa" to "a",
    "aá" to "a",
    "ee" to "e",
    "eé" to "e",
    "ii" to "i",
    "ií" to "i",
    "oo" to "o",
    "oó" to "o",
    "uu" to  "u"
)
val consonants = listOf("b", "c", "f", "h", "l", "m", "n", "p", "q", "r", "s",
    "t", "v", "w", "x", "y")
val consonantClusters = listOf(
    "ld", "mb", "mp", "nc", "nd", "ngw", "ng", "nq", "nt", "nw", "ps", "q", "ts", "x",
    "cc", "hty", "ht", "lc", "ll", "lm", "lp", "lq", "lt", "lv", "lw", "ly",
    "mm", "mn", "my", "nn", "nty", "nt", "ny", "pt", "rc", "rd", "rm", "rn", "rp", "rq",
    "rr", "rty", "rt", "rs", "rw", "ry", "sc", "sq", "ss", "sty", "st", "sw", "tt", "tw", "ty")
val consonantAssimilation = mapOf(
    "ln" to "ld",
    "lr" to "ll",
    "ls" to "ld",
    "nl" to "ll",
    "ns" to "ss",
    "nr" to "rr",
    "nm" to "mm",
    "np" to "mp",
    "rl" to "ll",
    "sn" to "ss",
    "sm" to "rm",
    "sr" to "rr",
    "sl" to "ll",
    "sv" to "rv",
    "sf" to "ff",
    "sh" to "sc",
    "tn" to "nt",
    "tl" to "lt",
    "tr" to "rt",
    "tc" to "cc",
    "tf" to "ff",
    "th" to "h"
)
val regularisation = mapOf(
    "ñ" to "n",
    "ŋ" to "n",
    "ā" to "á",
    "ē" to  "é",
    "ī" to  "í",
    "ō" to "ó",
    "ū" to "ú",
    "Ë" to "e",
    "ë" to "e",
    "ä" to "a",
    "ö" to "o",
    "qu" to "q",
    "cw" to "q",
    "kw" to "q"
)

class Word(input: String, val classes: List<Class> = emptyList()) {
    val regularized = run {
        var result = input.toLowerCase()
        for ((old, new) in regularisation) {
            result = result.replace(old, new)
        }
        result
    }
    val tokens = tokenizer(regularized)
    val pseudoSyllables = pseudoSyllables()
    val syllableCount = if (
        pseudoSyllables.size == 1
        && !pseudoSyllables.first().contains(vowels, diphthongs)
    ) {
        0
    } else {
        pseudoSyllables.size
    }

    val lengthenedLast = pseudoSyllables.subList(0, pseudoSyllables.size - 1).joinToString("") +
            tokenizer(pseudoSyllables.last()).joinToString("") { longVowelMap[it] ?: it }

    val heavySyllables =
        pseudoSyllables.map { it.contains(longVowels, diphthongs, consonantClusters) }

    fun contains(vararg soundClasses: List<String>) = regularized.contains(*soundClasses)
    fun startsWith(vararg soundClasses: List<String>) = regularized.startsWith(*soundClasses)
    fun endsWith(vararg soundClasses: List<String>) = regularized.endsWith(*soundClasses)

    private fun tokenizer(input: String): List<String> {
        val tokens = mutableListOf<String>()
        var remaining = input
        while (remaining.isNotEmpty()) when {
            remaining.length >= 3 && remaining.substring(0, 3) in consonantClusters -> {
                tokens.add(remaining.substring(0, 3))
                remaining = remaining.substring(3)
            }
            remaining.length >= 2 && remaining.subSequence(0, 2) in consonantClusters + diphthongs -> {
                tokens.add(remaining.substring(0, 2))
                remaining = remaining.substring(2)
            }
            else -> {
                tokens.add(remaining.substring(0, 1))
                remaining = remaining.substring(1)
            }
        }
        return tokens
    }

    private fun pseudoSyllables(): List<String> {
        val syllables = mutableListOf(StringBuilder())
        var isFirstVowel = true
        for (token in tokens) {
            val vocalic = token !in consonants && token !in consonantClusters
            when {
                vocalic && !isFirstVowel -> syllables.add(StringBuilder(token))
                vocalic && isFirstVowel -> {
                    syllables.last().append(token)
                    isFirstVowel = false
                }
                else -> syllables.last().append(token)
            }
        }
        return syllables.map { it.toString() }
    }
}
