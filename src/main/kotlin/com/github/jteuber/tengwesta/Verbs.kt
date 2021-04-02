package com.github.jteuber.tengwesta

val objectMarking = listOf(
    SimpleForm("3-sg object", "s").eldamo(4071776673),
    SimpleForm("3-pl object", "t").eldamo(4071776673)
)

val subjectMarking = listOf(
    SimpleForm("1-sg subject", "nye", objectMarking).eldamo(1020286637),
    SimpleForm("2-sg informal subject", "tye", objectMarking).eldamo(1020286637),
    SimpleForm("2-sg formal subject", "lye", objectMarking).eldamo(1020286637),
    SimpleForm("3-sg subject", "sse", objectMarking).eldamo(1020286637),

    SimpleForm("1-sg subject short", "n").eldamo(1020286637),
    SimpleForm("2-sg informal subject short", "t").eldamo(1020286637),
    SimpleForm("2-sg formal subject short", "l").eldamo(1020286637),
    SimpleForm("3-sg subject short", "s").eldamo(1020286637),

    SimpleForm("1-pl exclusive subject", "lme", objectMarking).eldamo(1020286637),
    SimpleForm("1-pl inclusive subject", "lve", objectMarking).eldamo(1020286637),
    SimpleForm("2-pl subject", "lde", objectMarking).eldamo(1020286637),
    SimpleForm("3-pl subject", "nte", objectMarking).eldamo(1020286637),
    SimpleForm("3-pl subject variant", "lte", objectMarking).eldamo(1020286637),

    SimpleForm("dual subject agreement", "t").eldamo(1421037119),
    SimpleForm("plural subject agreement", "r").eldamo(1421037119)
)

val basicVerbs = listOf(
    SimpleForm("aorist stand-alone (basic)", "e").eldamo(2025078257),
    SimpleForm("aorist with suffixation (basic)", "i", subjectMarking).eldamo(2025078257),
    SimpleForm("future (basic)", "uva", subjectMarking).eldamo(2817430301),
    SimpleForm("particular infinitive (basic)", "ita", aNoun + objectMarking).eldamo(3918305785),
    SimpleForm("gerund (basic)", "ie", vocalicNoun).eldamo(2279685699),
    SimpleForm("aorist active participle (basic)", "ila").eldamo(2328346087),
    SimpleForm("future active participle (basic)", "uvaila").eldamo(2328346087),
    SimpleForm("aorist passive participle (basic)", "ina", aAdjectives).eldamo(2744508917),
    SimpleForm("future passive participle (basic)", "uvaina", aAdjectives).eldamo(2744508917),
    SimpleForm("perfective adjective (basic)", "enwa", aAdjectives).eldamo(2654254973),

    FormWithLengthenedStem("present (basic)", "a", subjectMarking).eldamo(4095499405),
)

val uVerbs = listOf(
    SimpleForm("aorist (u)", "", subjectMarking).eldamo(2025078257),
    SimpleForm("past (u)", "ne", subjectMarking).eldamo(3224058975),
    FormWithRemoval("future (u)", "u", "úva", subjectMarking).eldamo(2817430301),
    SimpleForm("particular infinitive (u)", "ta", aNoun + objectMarking).eldamo(3918305785),
    SimpleForm("gerund (u)", "ye", vocalicNoun).eldamo(2279685699),
    SimpleForm("aorist active participle (u)", "ila").eldamo(2328346087),
    SimpleForm("future active participle (u)", "vaila").eldamo(2328346087),
    SimpleForm("aorist passive participle (u)", "na", aAdjectives).eldamo(2744508917),
    SimpleForm("future passive participle (u)", "vaina", aAdjectives).eldamo(2744508917),
    SimpleForm("perfective adjective (u)", "nwa", aAdjectives).eldamo(2654254973),

    FormWithLengthenedStem("present (u)", "a", subjectMarking).eldamo(4095499405),
)

val aVerbs = listOf(
    SimpleForm("aorist (a)", "", subjectMarking).eldamo(2025078257),
    SimpleForm("past (a)", "ne", subjectMarking).eldamo(3224058975),
    FormWithRemoval("future (a)", "a", "uva", subjectMarking).eldamo(2817430301),
    SimpleForm("particular infinitive (a)", "ta", aNoun + objectMarking).eldamo(3918305785),
    FormWithRemoval("gerund (a)", "a", "ie", vocalicNoun).eldamo(2279685699),
    SimpleForm("aorist active participle (a)", "ila").eldamo(2328346087),
    FormWithRemoval("future active participle (a)", "a", "uvaila").eldamo(2328346087),
    FormWithRemoval("aorist passive participle (a)", "a", "ina", aAdjectives).eldamo(2744508917),
    FormWithRemoval("future passive participle (a)", "a", "uvaina", aAdjectives).eldamo(2744508917),
    SimpleForm("perfective adjective (a)", "nwa", aAdjectives).eldamo(2654254973),

    ChainInflection(
        "present (a)",
        subjectMarking,
        FormWithRemoval("step I", "a", ""),
        FormWithLengthenedStem("step II", "ea")
    ).eldamo(4095499405)
)

val causativeVerbs = listOf(
    SimpleForm("future (causative)", "uva", subjectMarking).eldamo(2817430301),
    SimpleForm("future active participle (causative)", "uvaila").eldamo(2328346087),
    SimpleForm("aorist passive participle (causative)", "ina", aAdjectives).eldamo(2744508917),
    SimpleForm("future passive participle (causative)", "uvaina", aAdjectives).eldamo(2744508917),
)

val taFormatives = listOf(
    ChainInflection(
        "strong intransitive past (ta-formatives)", subjectMarking,
        FormWithRemoval("step I", "ta", ""),
        FormWithAssimilationSuffix("step II", "ne")
    ).eldamo(3224058975),
    FormWithRemoval("particular infinitive (ta-formatives)", "ta", "ita", aNoun + objectMarking).eldamo(3918305785),
    FormWithRemoval("aorist passive participle (ta-formatives)", "ta", "ina", aAdjectives).eldamo(2744508917),
    FormWithRemoval("future passive participle (ta-formatives)", "ta", "uvaina", aAdjectives).eldamo(2744508917),

    FormWithRemoval("present (ta-formative)", "ta", "tya", subjectMarking).eldamo(4095499405),
    FormWithRemoval("present (ta-formative)", "ta", "tia", subjectMarking).eldamo(4095499405),
    FormWithRemoval("present (ta-formative)", "ta", "tea", subjectMarking).eldamo(4095499405),
)

val yaFormatives = listOf(
    ChainInflection(
        "strong intransitive past (ya-formatives)", subjectMarking,
        FormWithRemoval("step I", "ya", ""),
        FormWithAssimilationSuffix("step II", "ne")
    ).eldamo(3224058975),
    FormWithRemoval("particular infinitive (ya-formatives)", "ya", "ita", aNoun + objectMarking).eldamo(3918305785),
    FormWithRemoval("aorist passive participle (ya-formatives)", "ya", "ina", aAdjectives).eldamo(2744508917),
    FormWithRemoval("future passive participle (ya-formatives)", "ya", "uvaina", aAdjectives).eldamo(2744508917),

    ChainInflection(
        "present (ya-formative)", subjectMarking,
        FormWithRemoval("step I", "ya", ""),
        FormWithLengthenedStem("step II", "ia")
    ).eldamo(4095499405),
    ChainInflection(
        "present (ya-formative)", subjectMarking,
        FormWithRemoval("step I", "ya", ""),
        FormWithLengthenedStem("step II", "ea")
    ).eldamo(4095499405)
)