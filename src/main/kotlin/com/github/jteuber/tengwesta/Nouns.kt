package com.github.jteuber.tengwesta

object NounA : Class() {
    override val inflections = listOf(
        BasicInflection("nominative singular", "a"),
        BasicInflection("dative singular", "an"),
        BasicInflection("genitive singular", "o"),
        BasicInflection("possessive singular", "ava"),
    )
}

