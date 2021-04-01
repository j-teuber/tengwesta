package com.github.jteuber.tengwesta

val intensive = listOf(
    FormWithAssimilationPrefix("intensive I (an-)", "an"),
)

val aAdjectives: List<Inflection> = listOf(
    FormWithRemoval("plural (a)", "a", "e", intensive),
    SimpleForm("adjective as noun (a)", "", aNoun),
    FormWithProsodicLengthening("adverb (a-ea)", "ve", intensive)
)

val eaAdjectives = listOf(
    FormWithRemoval("plural (ie)", "ea", "ie", intensive),
    SimpleForm("adjective as noun (a)", "", vocalicNoun),
    FormWithProsodicLengthening("adverb (a-ea)", "ve", intensive)
)

val eAdjectives = listOf(
    FormWithRemoval("plural (e)", "e", "i", intensive),
    SimpleForm("adjective as noun (e)", "", eNoun),
    FormWithRemoval("adverb (e)", "e", "ive", intensive)
)

val nAdjectives = listOf(
    FormWithProsodicLengthening("plural (n)", "i", intensive),
    SimpleForm("adjective as noun (n)", "", nNouns),
    SimpleForm("adverb (n)", "we", intensive)
)