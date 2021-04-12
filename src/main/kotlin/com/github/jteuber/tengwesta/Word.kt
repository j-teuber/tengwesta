package com.github.jteuber.tengwesta

class Word(
    val lexicalForm: Form,
    val inflections: List<Inflection>,
    val stem: Form = lexicalForm
)