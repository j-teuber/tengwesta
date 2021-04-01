package com.github.jteuber.tengwesta

val nominativeSingular = object : Inflection() {
    override val name = "nominative singular (all)"
    override fun inflect(word: Word) = word
    override fun unInflect(morpheme: Morpheme): Word = Word(morpheme, emptyList())
}.eldamo(2867812551)

val possessiveAdjectivePlural = listOf(
    FormWithRemoval("adjectival plural for possessive", "a", "e").eldamo(3983087533)
)

val commonVocalic = listOf(
    nominativeSingular,
    SimpleForm("dative singular (voc)", "n").eldamo(1853042105),
    FormWithProsodicLengthening("possessive singular (voc)", "va", possessiveAdjectivePlural).eldamo(3983087533),
    SimpleForm("allative singular (voc)", "nna").eldamo(488436569),
    SimpleForm("locative singular (voc)", "sse").eldamo(988788179),
    SimpleForm("ablative singular (voc)", "llo").eldamo(3384394593),
    FormWithProsodicLengthening("instrumental singular (voc)", "nen").eldamo(1605931301),


    FormWithProsodicLengthening("nominative partitive-plural (voc)", "li").eldamo(1164934417),
    FormWithProsodicLengthening("dative partitive-plural (voc)", "lin").eldamo(1853042105),
    SimpleForm("genitive partitive-plural (voc)", "lion").eldamo(2537177661),
    SimpleForm("possessive partitive-plural (voc)", "líva", possessiveAdjectivePlural).eldamo(3983087533),
    SimpleForm("allative partitive-plural (voc)", "linnar").eldamo(488436569),
    SimpleForm("locative partitive-plural (voc)", "lissen").eldamo(988788179),
    SimpleForm("ablative partitive-plural (voc)", "lillon").eldamo(3384394593),
    SimpleForm("instrumental partitive-plural (voc)", "línen").eldamo(1605931301),

    SimpleForm("allative partitive-plural (voc)", "linna").eldamo(488436569),
    SimpleForm("locative partitive-plural (voc)", "lisse").eldamo(988788179),
    SimpleForm("ablative partitive-plural (voc)", "lillo").eldamo(3384394593),


    SimpleForm("nominative dual (voc)", "t").eldamo(1147827707),
    SimpleForm("dative dual (voc)", "nt").eldamo(1853042105),
    SimpleForm("possessive dual (voc)", "twa", possessiveAdjectivePlural).eldamo(3983087533),
    FormWithProsodicLengthening("genitive dual (vocalic)", "to").eldamo(2537177661),
    SimpleForm("allative dual (voc)", "nta").eldamo(488436569),
    SimpleForm("locative dual (voc)", "tse").eldamo(988788179),
    SimpleForm("ablative dual (voc)", "lto").eldamo(3384394593),
    SimpleForm("instrumental dual (voc)", "nten").eldamo(1605931301),
    )

val standardVocalicPlural = listOf(
    SimpleForm("nominative plural (voc-not-e)", "r").eldamo(2870822299),
    SimpleForm("dative plural (voc-not-e)", "in").eldamo(1853042105),
    SimpleForm("possessive plural (voc-not-e)", "iva", possessiveAdjectivePlural).eldamo(3983087533),
    FormWithProsodicLengthening("genitive plural (voc-not-e)", "ron").eldamo(2537177661),
    SimpleForm("allative plural (voc-not-e)", "nnar").eldamo(488436569),
    SimpleForm("locative plural (voc-not-e)", "ssen").eldamo(988788179),
    SimpleForm("ablative plural (voc-not-e)", "llon").eldamo(3384394593),
    )

val standardVocalicGenitive = SimpleForm("genitive singular (voc-not-a)", "o").eldamo(2537177661)
val aGenitive = FormWithRemoval("genitive singular (a)", "a", "o").eldamo(2537177661)

val pluralE = listOf(
    FormWithRemoval("dative plural (e)", "e", "in").eldamo(1853042105),
    FormWithRemoval("possessive plural (e)", "e", "íva", possessiveAdjectivePlural).eldamo(3983087533),
    FormWithRemoval("genitive plural (e)", "e", "ion").eldamo(2537177661),
    FormWithRemoval("allative plural (e)", "e", "innar").eldamo(488436569),
    FormWithRemoval("locative plural (e)", "e", "issen").eldamo(988788179),
    FormWithRemoval("ablative plural (e)", "e", "illon").eldamo(3384394593),
    )

val commonConsonantal = listOf(
    nominativeSingular,
    StemWithProsodicLengthening("dative singular (cons)", "en").eldamo(1853042105),
    SimpleStem("possessive singular (cons)", "wa", possessiveAdjectivePlural).eldamo(3983087533),
    StemWithProsodicLengthening("genitive singular (cons)", "o").eldamo(2537177661),


    SimpleStem("nominative partitive-plural (cons)", "éli").eldamo(1164934417),
    SimpleStem("dative partitive-plural (cons)", "élin").eldamo(1853042105),
    SimpleStem("genitive partitive-plural (cons)", "élion").eldamo(2537177661),
    SimpleStem("possessive partitive-plural (cons)", "elíva", possessiveAdjectivePlural).eldamo(3983087533),
    SimpleStem("allative partitive-plural (cons)", "elinnar").eldamo(488436569),
    SimpleStem("locative partitive-plural (cons)", "elissen").eldamo(988788179),
    SimpleStem("ablative partitive-plural (cons)", "elillon").eldamo(3384394593),
    SimpleStem("instrumental partitive-plural (cons)", "elínen").eldamo(1605931301),

    SimpleStem("allative partitive-plural (cons)", "elinna").eldamo(488436569),
    SimpleStem("locative partitive-plural (cons)", "elisse").eldamo(988788179),
    SimpleStem("ablative partitive-plural (cons)", "elillo").eldamo(3384394593),


    StemWithProsodicLengthening("nominative dual (cons)", "u").eldamo(1147827707),
    StemWithProsodicLengthening("dative dual (cons)", "un").eldamo(1853042105),
    SimpleStem("possessive dual (cons)", "úva", possessiveAdjectivePlural).eldamo(3983087533),
    SimpleStem("genitive dual (cons)", "uo").eldamo(2537177661),
    SimpleStem("allative dual (cons)", "unna").eldamo(488436569),
    SimpleStem("locative dual (cons)", "usse").eldamo(988788179),
    SimpleStem("ablative dual (cons)", "ullo").eldamo(3384394593),
    SimpleStem("instrumental dual (cons)", "únen").eldamo(1605931301),


    StemWithProsodicLengthening("nominative plural (cons)", "i").eldamo(2870822299),
    StemWithProsodicLengthening("dative plural (cons)", "in").eldamo(1853042105),
    SimpleStem("possessive plural (cons)", "íva", possessiveAdjectivePlural).eldamo(3983087533),
    SimpleStem("genitive plural (cons)", "ion").eldamo(2537177661),
    SimpleStem("allative plural (cons)", "innar").eldamo(488436569),
    SimpleStem("locative plural (cons)", "issen").eldamo(988788179),
    SimpleStem("ablative plural (cons)", "illon").eldamo(3384394593),
    )
val standardConsonantalAllative = listOf(
    SimpleStem("allative plural (cons-not-n)", "enna").eldamo(488436569),
)
val standardConsonantalLocative = listOf(
    SimpleStem("locative plural (cons-not-s)", "esse").eldamo(988788179)
)
val standardConsonantalAblative = listOf(
    SimpleStem("ablative plural (cons-not-l)", "ello").eldamo(3384394593)
)

val standardConsonantalInstrumental = listOf(
    SimpleStem("allative plural (cons-not-n)", "anen").eldamo(1605931301),
)
val nAllative = listOf(
    SimpleStem("allative plural (cons-n)", "na").eldamo(488436569),
)
val sLocative = listOf(
    SimpleStem("locative plural (cons-s)", "se").eldamo(988788179)
)
val lAblative = listOf(
    SimpleStem("ablative plural (cons-l)", "lo").eldamo(3384394593)
)

val nInstrumental = listOf(
    SimpleStem("allative plural (cons-not-n)", "nen").eldamo(1605931301),
)

val nominativePluralE = SimpleStem("nominative plural (cons)", "i").eldamo(2870822299)

val aNounsFromPossessives = commonVocalic + aGenitive + standardVocalicPlural

val vocalicPossessive = listOf(
    SimpleForm("1-sg possessive (voc)", "nya", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("2-sg informal possessive (voc)", "tya", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("2-sg formal possessive (voc)", "lya", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("3-sg possessive (voc)", "rya", aNounsFromPossessives).eldamo(4077936885),

    SimpleForm("1-pl inclusive possessive (voc)", "lva", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("1-pl exclusive possessive (voc)", "lma", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("2-pl possessive (voc)", "lda", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("3-pl possessive (voc)", "nta", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("3-pl possessive (voc) variant", "lta", aNounsFromPossessives).eldamo(4077936885),

    SimpleForm("1-du exclusive possessive (voc)", "mma", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("1-du inclusive possessive (voc)", "nqa", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("2-du possessive (voc)", "sta", aNounsFromPossessives).eldamo(4077936885),
    SimpleForm("3-du possessive (voc)", "tta", aNounsFromPossessives).eldamo(4077936885),
    )

val consonantalPossessive = listOf(
    SimpleStem("1-sg possessive (cons)", "inya", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("2-sg informal possessive (cons)", "itya", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("2-sg formal possessive (cons)", "elya", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("3-sg possessive (cons)", "erya", aNounsFromPossessives).eldamo(4077936885),

    SimpleStem("1-pl inclusive possessive (cons)", "elva", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("1-pl exclusive possessive (cons)", "elma", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("2-pl possessive (cons)", "elda", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("3-pl possessive (cons)", "inta", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("3-pl possessive (cons) variant", "elta", aNounsFromPossessives).eldamo(4077936885),

    SimpleStem("1-du exclusive possessive (cons)", "emma", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("1-du inclusive possessive (cons)", "inqa", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("2-du possessive (cons)", "ista", aNounsFromPossessives).eldamo(4077936885),
    SimpleStem("3-du possessive (cons)", "etta", aNounsFromPossessives).eldamo(4077936885),
    )

val vocalicNoun = commonVocalic + standardVocalicGenitive + standardVocalicPlural + vocalicPossessive
val aNoun = commonVocalic + aGenitive + standardVocalicPlural + vocalicPossessive
val eNoun = commonVocalic + standardVocalicGenitive + nominativePluralE +
        pluralE + vocalicPossessive
val consonantal = commonConsonantal + standardConsonantalAblative +
        standardConsonantalAllative + standardConsonantalInstrumental +
        standardConsonantalLocative + consonantalPossessive
val nNouns = commonConsonantal + standardConsonantalAblative +
        nAllative + nInstrumental +
        standardConsonantalLocative + consonantalPossessive

val sNouns = commonConsonantal + standardConsonantalAblative +
        standardConsonantalAllative + standardConsonantalInstrumental +
        sLocative + consonantalPossessive

val lNouns = commonConsonantal + lAblative +
        standardConsonantalAllative + standardConsonantalInstrumental +
        standardConsonantalLocative + consonantalPossessive

val all = commonVocalic + standardVocalicGenitive + aGenitive + vocalicPossessive +
        commonConsonantal + commonConsonantal +
        standardConsonantalAblative + lAblative +
        standardConsonantalAllative + nAllative +
        standardConsonantalInstrumental + nInstrumental +
        standardConsonantalLocative + sLocative