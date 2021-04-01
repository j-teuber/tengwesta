package com.github.jteuber.tengwesta

val intensive = listOf(
    FormWithAssimilationPrefix("intensive I (an-)", "an").eldamo(772893967),
)

val aAdjectives: List<Inflection> = listOf(
    FormWithRemoval("plural (a)", "a", "e", intensive).eldamo(1562793387),
    SimpleForm("adjective as noun (a)", "", aNoun).eldamo(2610491611),
    FormWithProsodicLengthening("adverb (a-ea)", "ve", intensive).eldamo(1563116357)
)

val eaAdjectives = listOf(
    FormWithRemoval("plural (ie)", "ea", "ie", intensive).eldamo(1562793387),
    SimpleForm("adjective as noun (a)", "", vocalicNoun).eldamo(2610491611),
    FormWithProsodicLengthening("adverb (a-ea)", "ve", intensive).eldamo(1563116357)
)

val eAdjectives = listOf(
    FormWithRemoval("plural (e)", "e", "i", intensive).eldamo(1562793387),
    SimpleForm("adjective as noun (e)", "", eNoun).eldamo(2610491611),
    FormWithRemoval("adverb (e)", "e", "ive", intensive).eldamo(1563116357)
)

val nAdjectives = listOf(
    FormWithProsodicLengthening("plural (n)", "i", intensive).eldamo(1562793387),
    SimpleForm("adjective as noun (n)", "", nNouns).eldamo(2610491611),
    SimpleForm("adverb (n)", "we", intensive).eldamo(1563116357)
)