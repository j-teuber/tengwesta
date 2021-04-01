package com.github.jteuber.tengwesta

val aAdjectives: List<Inflection> = listOf(
    FormWithRemoval("plural (a)", "a", "e"),
    SimpleForm("adjective as noun (a)", "", aNoun),
    FormWithProsodicLengthening("adverb (a-ea)", "ve")
)

val eaAdjectives = listOf(
    FormWithRemoval("plural (ie)", "ea", "ie"),
    SimpleForm("adjective as noun (a)", "", vocalicNoun),
    FormWithProsodicLengthening("adverb (a-ea)", "ve")
)

val eAdjectives = listOf(
    FormWithRemoval("plural (e)", "e", "i"),
    SimpleForm("adjective as noun (e)", "", eNoun),
    FormWithRemoval("adverb (e)", "e", "ive")
)

val nAdjectives = listOf(
    FormWithProsodicLengthening("plural (n)", "i"),
    SimpleForm("adjective as noun (n)", "", nNouns),
    SimpleForm("adverb (n)", "we")
)