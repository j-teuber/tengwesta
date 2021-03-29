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
    "ld", "mb", "mp", "nc", "nd", "ngw", "ng", "nqu", "nt", "nw", "ps", "qu", "ts", "x",
    "cc", "hty", "ht", "lc", "ll", "lm", "lp", "lqu", "lt", "lv", "lw", "ly",
    "mm", "mn", "my", "nn", "nty", "nt", "ny", "pt", "rc", "rd", "rm", "rn", "rp", "rqu",
    "rr", "rty", "rt", "rs", "rw", "ry", "sc", "squ", "ss", "sty", "st", "sw", "tt", "tw", "ty")
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
    "q" to "qu",
    "cw" to "qu",
    "kw" to "qu"
)

fun regularize(word: String): String {
    var result = word.toLowerCase()
    for ((old, new) in regularisation) {
        result = result.replace(old, new)
    }
    return result
}

fun tokenizer(word: String): List<String> {
    val tokens = mutableListOf<String>()
    var remaining = word
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

fun pseudoSyllables(word: String): List<String> {
    val syllables = mutableListOf(StringBuilder())
    var isFirstVowel = true
    for (token in tokenizer(word)) {
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

fun String.isHeavy(): Boolean = longVowels.any { this.contains(it) }
        || diphthongs.any { this.contains(it) }
        || consonantClusters.any { this.contains(it) }

fun String.countSyllables() = pseudoSyllables(this).let { syllables ->
    if (syllables.size == 1 && (vowels + diphthongs).none { syllables.first().contains(it) }) {
        0
    } else {
        syllables.size
    }
}

fun String.lengthen(): String = tokenizer(this)
    .map { if(it in longVowelMap.keys)  longVowelMap[it] else it }
    .joinToString(separator = "")
