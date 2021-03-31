package com.github.jteuber.tengwesta

val aAdjectives = listOf(
    FormWithRemoval("plural (a)", "a", "e"),
    SimpleForm("adjective as noun (a)", "", aNoun)
)

val eaAdjectives = listOf(
    FormWithRemoval("plural (ie)", "ea", "ie"),
    SimpleForm("adjective as noun (a)", "", vocalicNoun)
)

val eAdjectives = listOf(
    FormWithRemoval("plural (e)", "e", "i"),
    SimpleForm("adjective as noun (e)", "", eNoun)
)

val nAdjectives = listOf(
    FormWithProsodicLengthening("plural (n)", "i"),
    SimpleForm("adjective as noun (n)", "", nNouns)
)