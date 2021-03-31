package com.github.jteuber.tengwesta

val nominativeSingular = object : Inflection() {
    override val name = "nominative singular (all)"
    override fun inflect(word: Word) = word
    override fun unInflect(morpheme: Morpheme): Word = Word(morpheme, emptyList())
}

val commonVocalic = listOf(
    nominativeSingular,
    SimpleForm("dative singular (voc)", "n"),
    FormWithProsodicLengthening("possessive singular (voc)", "va"),
    SimpleForm("allative singular (voc)", "nna"),
    SimpleForm("locative singular (voc)", "sse"),
    SimpleForm("ablative singular (voc)", "llo"),
    FormWithProsodicLengthening("instrumental singular (voc)", "nen"),

    SimpleForm("possessive singular (voc) elided", "v"),
    SimpleForm("allative singular (voc) elided", "nn"),
    SimpleForm("locative singular (voc) elided", "ss"),
    SimpleForm("ablative singular (voc) elided", "ll"),

    FormWithProsodicLengthening("nominative partitive-plural (voc)", "li"),
    FormWithProsodicLengthening("dative partitive-plural (voc)", "lin"),
    SimpleForm("genitive partitive-plural (voc)", "lion"),
    SimpleForm("possessive partitive-plural (voc)", "líva"),
    SimpleForm("allative partitive-plural (voc)", "linnar"),
    SimpleForm("locative partitive-plural (voc)", "lissen"),
    SimpleForm("ablative partitive-plural (voc)", "lillon"),
    SimpleForm("instrumental partitive-plural (voc)", "línen"),

    SimpleForm("allative partitive-plural (voc)", "linna"),
    SimpleForm("locative partitive-plural (voc)", "lisse"),
    SimpleForm("ablative partitive-plural (voc)", "lillo"),

    SimpleForm("nominative partitive-plural (voc) elided", "l"),
    SimpleForm("allative partitive-plural (voc) elided", "linn"),
    SimpleForm("locative partitive-plural (voc) elided", "liss"),
    SimpleForm("ablative partitive-plural (voc) elided", "lill"),

    SimpleForm("nominative dual (voc)", "t"),
    SimpleForm("dative dual (voc)", "nt"),
    SimpleForm("possessive dual (voc)", "twa"),
    FormWithProsodicLengthening("genitive dual (vocalic)", "to"),
    SimpleForm("allative dual (voc)", "nta"),
    SimpleForm("locative dual (voc)", "tse"),
    SimpleForm("ablative dual (voc)", "lto"),
    SimpleForm("instrumental dual (voc)", "nten"),

    SimpleForm("possessive dual (voc) elided", "tw"),
    FormWithProsodicLengthening("genitive dual (voc) elided", "t"),
    SimpleForm("allative dual (voc) elided", "nt"),
    SimpleForm("locative dual (voc) elided", "ts"),
    SimpleForm("ablative dual (voc) elided", "lt"),
)

val standardVocalicPlural = listOf(
    SimpleForm("nominative plural (voc-not-e)", "r"),
    SimpleForm("dative plural (voc-not-e)", "in"),
    SimpleForm("possessive plural (voc-not-e)", "iva"),
    FormWithProsodicLengthening("genitive plural (voc-not-e)", "ron"),
    SimpleForm("allative plural (voc-not-e)", "nnar"),
    SimpleForm("locative plural (voc-not-e)", "ssen"),
    SimpleForm("ablative plural (voc-not-e)", "llon"),

    SimpleForm("possessive plural (voc-not-e) elided", "iv"),
)

val standardVocalicGenitive = SimpleForm("genitive singular (voc-not-a)", "o")
val aGenitive = SimpleStem("genitive singular (a)", "o")

val commonConsonantal = listOf(
    nominativeSingular,
    StemWithProsodicLengthening("dative singular (cons)", "en"),
    SimpleStem("possessive singular (cons)", "wa"),
    StemWithProsodicLengthening("genitive singular (cons)", "o"),

    SimpleStem("possessive singular (cons) elided", "w"),

    SimpleStem("nominative partitive-plural (cons)", "éli"),
    SimpleStem("dative partitive-plural (cons)", "élin"),
    SimpleStem("genitive partitive-plural (cons)", "élion"),
    SimpleStem("possessive partitive-plural (cons)", "elíva"),
    SimpleStem("allative partitive-plural (cons)", "linnar"),
    SimpleStem("locative partitive-plural (cons)", "lissen"),
    SimpleStem("ablative partitive-plural (cons)", "lillon"),
    SimpleStem("instrumental partitive-plural (cons)", "línen"),

    SimpleStem("allative partitive-plural (cons)", "linna"),
    SimpleStem("locative partitive-plural (cons)", "lisse"),
    SimpleStem("ablative partitive-plural (cons)", "lillo"),

    SimpleStem("nominative partitive-plural (cons) elided", "l"),
    SimpleStem("allative partitive-plural (cons) elided", "linn"),
    SimpleStem("locative partitive-plural (cons) elided", "liss"),
    SimpleStem("ablative partitive-plural (cons) elided", "lill"),

    StemWithProsodicLengthening("nominative dual (cons)", "u"),
    StemWithProsodicLengthening("dative dual (cons)", "un"),
    SimpleStem("possessive dual (cons)", "úwa"),
    SimpleStem("genitive dual (cons)", "uo"),
    SimpleStem("allative dual (cons)", "unna"),
    SimpleStem("locative dual (cons)", "usse"),
    SimpleStem("ablative dual (cons)", "ullo"),
    SimpleStem("instrumental dual (cons)", "únen"),

    SimpleStem("possessive dual (cons) elided", "úv"),
    SimpleStem("genitive dual (cons) elided", "u"),
    SimpleStem("allative dual (cons) elided", "unn"),
    SimpleStem("locative dual (cons) elided", "uss"),
    SimpleStem("ablative dual (cons) elided", "ull"),

    StemWithProsodicLengthening("nominative plural (cons)", "i")
)

val standardConsonantalAllative = listOf(
    SimpleStem("allative plural (cons-not-n)", "enna"),
    SimpleStem("allative plural (cons-not-n) elided", "enn"),
)
val standardConsonantalLocative = listOf(
    SimpleStem("locative plural (cons-not-s)", "esse"),
    SimpleStem("locative plural (cons-not-s) elided", "ess")
)
val standardConsonantalAblative = listOf(
    SimpleStem("ablative plural (cons-not-l)", "ello"),
    SimpleStem("ablative plural (cons-not-l) elided", "ell")
)
val standardConsonantalInstrumental = listOf(
    SimpleStem("allative plural (cons-not-n)", "anen"),
)

val nAllative = listOf(
    SimpleStem("allative plural (cons-n)", "na"),
    SimpleStem("allative plural (cons-n) elided", "n"),
)
val sLocative = listOf(
    SimpleStem("locative plural (cons-s)", "se"),
    SimpleStem("locative plural (cons-s) elided", "s")
)
val lAblative = listOf(
    SimpleStem("ablative plural (cons-l)", "lo"),
    SimpleStem("ablative plural (cons-l) elided", "l")
)
val nInstrumental = listOf(
    SimpleStem("allative plural (cons-not-n)", "nen"),
)

val nominativePluralE = SimpleStem("nominative plural (cons)", "i")

val pluralConsonantalAndE = listOf(
    StemWithProsodicLengthening("dative plural (cons-and-e)", "in"),
    SimpleStem("possessive plural (cons-and-e)", "íva"),
    SimpleStem("genitive plural (cons-and-e)", "ion"),
    SimpleStem("allative plural (cons-and-e)", "innar"),
    SimpleStem("locative plural (cons-and-e)", "issen"),
    SimpleStem("ablative plural (cons-and-e)", "illon"),

    SimpleStem("possessive plural (cons-and-e) elided", "ív"),
)

val aNounsFromPossessives = commonVocalic + aGenitive + standardVocalicPlural

val vocalicPossessive = listOf(
    SimpleForm("1-sg possessive (voc)", "nya", aNounsFromPossessives),
    SimpleForm("2-sg informal possessive (voc)", "tya", aNounsFromPossessives),
    SimpleForm("2-sg formal possessive (voc)", "lya", aNounsFromPossessives),
    SimpleForm("3-sg possessive (voc)", "rya", aNounsFromPossessives),

    SimpleForm("1-pl inclusive possessive (voc)", "lva", aNounsFromPossessives),
    SimpleForm("1-pl exclusive possessive (voc)", "lma", aNounsFromPossessives),
    SimpleForm("2-pl possessive (voc)", "lda", aNounsFromPossessives),
    SimpleForm("3-pl possessive (voc)", "nta", aNounsFromPossessives),
    SimpleForm("3-pl possessive (voc) variant", "lta", aNounsFromPossessives),

    SimpleForm("1-du exclusive possessive (voc)", "mma", aNounsFromPossessives),
    SimpleForm("1-du inclusive possessive (voc)", "nqa", aNounsFromPossessives),
    SimpleForm("2-du possessive (voc)", "sta", aNounsFromPossessives),
    SimpleForm("3-du possessive (voc)", "tta", aNounsFromPossessives),

    SimpleForm("1-sg possessive (voc) elided", "ny"),
    SimpleForm("2-sg informal possessive (voc) elided", "ty"),
    SimpleForm("2-sg formal possessive (voc) elided", "ly"),
    SimpleForm("3-sg possessive (voc) elided", "ry"),

    SimpleForm("1-pl inclusive possessive (voc) elided", "lv"),
    SimpleForm("1-pl exclusive possessive (voc) elided", "lm"),
    SimpleForm("2-pl possessive (voc) elided", "ld"),
    SimpleForm("3-pl possessive (voc) elided", "nt"),
    SimpleForm("3-pl possessive (voc) variant elided", "lt"),

    SimpleForm("1-du exclusive possessive (voc) elided", "mm"),
    SimpleForm("1-du inclusive possessive (voc) elided", "nq"),
    SimpleForm("2-du possessive (voc) elided", "st"),
    SimpleForm("3-du possessive (voc) elided", "tt"),
    )

val consonantalPossessive = listOf(
    SimpleStem("1-sg possessive (cons)", "inya", aNounsFromPossessives),
    SimpleStem("2-sg informal possessive (cons)", "itya", aNounsFromPossessives),
    SimpleStem("2-sg formal possessive (cons)", "elya", aNounsFromPossessives),
    SimpleStem("3-sg possessive (cons)", "erya", aNounsFromPossessives),

    SimpleStem("1-pl inclusive possessive (cons)", "elva", aNounsFromPossessives),
    SimpleStem("1-pl exclusive possessive (cons)", "elma", aNounsFromPossessives),
    SimpleStem("2-pl possessive (cons)", "elda", aNounsFromPossessives),
    SimpleStem("3-pl possessive (cons)", "inta", aNounsFromPossessives),
    SimpleStem("3-pl possessive (cons) variant", "elta", aNounsFromPossessives),

    SimpleStem("1-du exclusive possessive (cons)", "emma", aNounsFromPossessives),
    SimpleStem("1-du inclusive possessive (cons)", "inqa", aNounsFromPossessives),
    SimpleStem("2-du possessive (cons)", "ista", aNounsFromPossessives),
    SimpleStem("3-du possessive (cons)", "etta", aNounsFromPossessives),

    SimpleStem("1-sg possessive (cons) elided", "iny"),
    SimpleStem("2-sg informal possessive (cons) elided", "ety"),
    SimpleStem("2-sg formal possessive (cons) elided", "ely"),
    SimpleStem("3-sg possessive (cons) elided", "ery"),

    SimpleStem("1-pl inclusive possessive (cons) elided", "elv"),
    SimpleStem("1-pl exclusive possessive (cons) elided", "elm"),
    SimpleStem("2-pl possessive (cons) elided", "eld"),
    SimpleStem("3-pl possessive (cons) elided", "int"),
    SimpleStem("3-pl possessive (cons) variant elided", "elt"),

    SimpleStem("1-du exclusive possessive (voc) elided", "emm"),
    SimpleStem("1-du inclusive possessive (voc) elided", "inq"),
    SimpleStem("2-du possessive (voc) elided", "ist"),
    SimpleStem("3-du possessive (voc) elided", "ett"),
)

val vocalicNoun = commonVocalic + standardVocalicGenitive + standardVocalicPlural + vocalicPossessive
val aNoun = commonVocalic + aGenitive + standardVocalicPlural + vocalicPossessive
val eNoun = commonVocalic + standardVocalicGenitive + nominativePluralE +
        pluralConsonantalAndE + vocalicPossessive
val consonantal = commonConsonantal + standardConsonantalAblative +
        standardConsonantalAllative + standardConsonantalInstrumental +
        standardConsonantalLocative + pluralConsonantalAndE + consonantalPossessive
val nNouns = commonConsonantal + standardConsonantalAblative +
        nAllative + nInstrumental +
        standardConsonantalLocative + pluralConsonantalAndE + consonantalPossessive

val sNouns = commonConsonantal + standardConsonantalAblative +
        standardConsonantalAllative + standardConsonantalInstrumental +
        sLocative + pluralConsonantalAndE + consonantalPossessive

val lNouns = commonConsonantal + lAblative +
        standardConsonantalAllative + standardConsonantalInstrumental +
        standardConsonantalLocative + pluralConsonantalAndE + consonantalPossessive

val all = commonVocalic + standardVocalicGenitive + aGenitive + vocalicPossessive +
        commonConsonantal + pluralConsonantalAndE + commonConsonantal +
        standardConsonantalAblative + lAblative +
        standardConsonantalAllative + nAllative +
        standardConsonantalInstrumental + nInstrumental +
        standardConsonantalLocative + sLocative