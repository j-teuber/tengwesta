package com.gitlab.jteuber.tengwesta

fun compound(vararg parts: String): String =
    parts.reduceRight { suffix, prefix -> compoundTwo(prefix, suffix) }

fun compoundTwo(prefix: String, suffix: String): String = when {
    consonants.any { prefix.endsWith(it) } && consonants.any { suffix.startsWith(it) }
    -> compoundConsonantAssimilation(prefix, suffix)
    vowels.any { prefix.endsWith(it) } && vowels.any { suffix.startsWith(it) }
    -> compoundVowelAssimilation(prefix, suffix)
    else -> compoundLengthening(prefix, suffix)
}

fun compoundVowelAssimilation(prefix: String, suffix: String): String {
    // TODO research
    return prefix.substring(0, prefix.length-1) + suffix
}

fun compoundConsonantAssimilation(prefix: String, suffix: String): String {
    return prefix.substring(0, prefix.length-1) +
            consonantAssimilation[ prefix.last().toString() + suffix.first() ] +
            suffix.substring(1)

}

fun compoundLengthening(prefix: String, suffix: String): String {
    val prefixSyllables = pseudoSyllables(prefix)
    val suffixSyllables = pseudoSyllables(suffix)
    val noLengthening = suffixSyllables.any { it.isHeavy() }
            || prefixSyllables.size > 2
            || prefixSyllables[prefixSyllables.size - 2].isHeavy()
            || prefixSyllables.last().isHeavy()
    return if (noLengthening) {
        prefix + suffix
    } else {
        (prefixSyllables.subList(0, prefixSyllables.size - 1).joinToString("")
                + prefixSyllables.last().lengthen()
                + suffix)
    }
}
