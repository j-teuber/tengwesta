package com.github.jteuber.tengwesta

fun compound(prefix: Morpheme, suffix: Morpheme): String = when {
    prefix.endsWith(consonants) && suffix.startsWith(consonants)
    -> compoundConsonantAssimilation(prefix, suffix)
    prefix.endsWith(vowels) && suffix.startsWith(vowels)
    -> compoundVowelAssimilation(prefix, suffix)
    else -> compoundLengthening(prefix, suffix)
}

fun compoundVowelAssimilation(prefix: Morpheme, suffix: Morpheme): String {
    // TODO research
    return prefix.regularized + suffix.regularized
}

fun compoundConsonantAssimilation(prefix: Morpheme, suffix: Morpheme): String {
    return prefix.regularized.substring(0, prefix.regularized.length - 1) +
            (consonantAssimilation[prefix.regularized.last().toString() + suffix.regularized.first()]
                ?: prefix.regularized.last().toString() + suffix.regularized.first()) +
            suffix.regularized.substring(1)
}

fun compoundLengthening(prefix: Morpheme, suffix: Morpheme): String {
    val noLengthening = suffix.heavySyllables.any { it }
            || suffix.syllableCount < 1
            || prefix.syllableCount < 3
            || prefix.heavySyllables.secondToLast()
            || prefix.heavySyllables.last()
    return if (noLengthening) {
        prefix.regularized + suffix.regularized
    } else {
        prefix.lengthenedLast + suffix.regularized
    }
}
