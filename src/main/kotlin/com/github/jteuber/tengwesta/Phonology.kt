package com.github.jteuber.tengwesta

val shortVowels = listOf( "a", "e", "i", "o", "u" )
val longVowels = listOf( "á", "é", "í", "ó", "ú" )
val longVowelMap = (shortVowels zip longVowels).toMap()
val vowels = shortVowels + longVowels
val diphthongs = listOf( "ai", "au", "oi", "ui", "eu", "iu" )
val vowelClusters = listOf("ea")
val vowelAssimilation = mapOf(
    "aa" to "a",
    "aá" to "a",
    "ee" to "e",
    "eé" to "e",
    "ii" to "i",
    "ií" to "i",
    "oo" to "o",
    "oó" to "o",
    "uu" to  "u"
)
val consonants = listOf("b", "c", "f", "h", "l", "m", "n", "p", "q", "r", "s",
    "t", "v", "w", "x", "y")
val consonantClusters = listOf(
    "ld", "mb", "mp", "nc", "nd", "ngw", "ng", "nq", "nt", "nw", "ps", "q", "ts", "x",
    "cc", "hty", "ht", "lc", "ll", "lm", "lp", "lq", "lt", "lv", "lw", "ly",
    "mm", "mn", "my", "nn", "nty", "nt", "ny", "pt", "rc", "rd", "rm", "rn", "rp", "rq",
    "rr", "rty", "rt", "rs", "rw", "ry", "sc", "sq", "ss", "sty", "st", "sw", "tt", "tw", "ty")
val consonantAssimilation = mapOf(
    "ln" to "ld",
    "lr" to "ll",
    "ls" to "ld",
    "nl" to "ll",
    "ns" to "ss",
    "nr" to "rr",
    "nm" to "mm",
    "np" to "mp",
    "rl" to "ll",
    "sn" to "ss",
    "sm" to "rm",
    "sr" to "rr",
    "sl" to "ll",
    "sv" to "rv",
    "sf" to "ff",
    "sh" to "sc",
    "tn" to "nt",
    "tl" to "lt",
    "tr" to "rt",
    "tc" to "cc",
    "tf" to "ff",
    "th" to "h"
)
val regularisation = mapOf(
    "ñ" to "n",
    "ŋ" to "n",
    "ā" to "á",
    "ē" to  "é",
    "ī" to  "í",
    "ō" to "ó",
    "ū" to "ú",
    "Ë" to "e",
    "ë" to "e",
    "ä" to "a",
    "ö" to "o",
    "qu" to "q",
    "cw" to "q",
    "kw" to "q"
)

