package com.github.jteuber.tengwesta

class Morpheme(input: String) {
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