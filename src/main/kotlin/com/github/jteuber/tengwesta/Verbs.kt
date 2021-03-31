package com.github.jteuber.tengwesta

val objectMarking = listOf(
    SimpleForm("3-sg object", "s"),
    SimpleForm("3-pl object", "t")
)

val subjectMarking = listOf(
    SimpleForm("1-sg subject", "nye", objectMarking),
    SimpleForm("2-sg informal subject", "tye", objectMarking),
    SimpleForm("2-sg formal subject", "lye", objectMarking),
    SimpleForm("3-sg subject", "sse", objectMarking),

    SimpleForm("1-sg subject short", "n"),
    SimpleForm("2-sg informal subject short", "t"),
    SimpleForm("2-sg formal subject short", "l"),
    SimpleForm("3-sg subject short", "s"),

    SimpleForm("1-pl exclusive subject", "lme", objectMarking),
    SimpleForm("1-pl inclusive subject", "lve", objectMarking),
    SimpleForm("2-pl subject", "lde", objectMarking),
    SimpleForm("3-pl subject", "nte", objectMarking),
    SimpleForm("3-pl subject variant", "lte", objectMarking),

    SimpleForm("1-du exclusive subject", "mme"),
    SimpleForm("1-du inclusive subject", "nqe"),
    SimpleForm("2-du subject", "ste"),
    SimpleForm("3-du subject", "tte"),

    SimpleForm("1-sg subject elided", "ny"),
    SimpleForm("2-sg informal subject elided", "ty"),
    SimpleForm("2-sg formal subject elided", "ly"),
    SimpleForm("3-sg subject elided", "ss"),

    SimpleForm("1-pl exclusive subject elided", "lm"),
    SimpleForm("1-pl inclusive subject elided", "lv"),
    SimpleForm("2-pl subject elided", "ld"),
    SimpleForm("3-pl subject elided", "nt"),
    SimpleForm("3-pl subject variant elided", "lt"),

    SimpleForm("1-du exclusive subject elided", "mm"),
    SimpleForm("1-du inclusive subject elided", "nq"),
    SimpleForm("2-du subject elided", "st"),
    SimpleForm("3-du subject elided", "tt"),

    SimpleForm("dual subject agreement", "t"),
    SimpleForm("plural subject agreement", "r")
    )

val basicVerbs = listOf(
    SimpleForm("aorist stand-alone (basic)", "e"),
    SimpleForm("aorist suffixed (basic)", "i", subjectMarking),
    SimpleForm("future (basic)", "uva", subjectMarking),
    SimpleForm("particular infinitive (basic)", "ita", aNoun + objectMarking),
    SimpleForm("gerund (basic)", "ie", vocalicNoun),
    SimpleForm("aorist active participle (basic)", "ila"),
    SimpleForm("future active participle (basic)", "uvaila"),
    SimpleForm("aorist passive participle (basic)", "ina", aAdjectives),
    SimpleForm("future passive participle (basic)", "uvaina", aAdjectives),
    SimpleForm("perfective adjective (basic)", "enwa", aAdjectives),
)

val uVerbs = listOf(
    SimpleForm("aorist (u)", "", subjectMarking),
    SimpleForm("past (u)", "ne", subjectMarking),
    FormWithRemoval("future (u)", "u", "úva", subjectMarking),
    SimpleForm("particular infinitive (u)", "ta", aNoun + objectMarking),
    SimpleForm("gerund (u)", "ye", vocalicNoun),
    SimpleForm("aorist active participle (u)", "ila"),
    SimpleForm("future active participle (u)", "vaila"),
    SimpleForm("aorist passive participle (u)", "na", aAdjectives),
    SimpleForm("future passive participle (u)", "vaina", aAdjectives),
    SimpleForm("perfective adjective (u)", "nwa", aAdjectives),
)