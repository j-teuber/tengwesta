package com.github.jteuber.tengwesta

fun compoundWithLengthening(prefix: Morpheme, suffix: Morpheme): Morpheme {
    val noLengthening = suffix.heavySyllables.any { it }
            || suffix.syllableCount < 1
            || prefix.syllableCount < 3
            || prefix.heavySyllables.secondToLast()
            || prefix.heavySyllables.last()
    return Morpheme(
        if (noLengthening) {
            prefix.regularized + suffix.regularized
        } else {
            prefix.lengthenedLast + suffix.regularized
        }
    )
}
