package com.github.jteuber.tengwesta

class Word(
    val lexicalForm: Morpheme,
    val inflections: List<Inflection>,
    val stem: Morpheme = lexicalForm
)