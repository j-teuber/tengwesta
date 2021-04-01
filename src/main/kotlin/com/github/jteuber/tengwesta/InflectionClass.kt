package com.github.jteuber.tengwesta

abstract class Inflection {
    abstract val name: String
    abstract fun inflect(word: Word): Word
    abstract fun unInflect(morpheme: Morpheme): Word
}

class SimpleForm(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word) = Word(
        Morpheme(word.lexicalForm.regularized + ending),
        newInflections
    )

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }

}

class SimpleStem(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word) = Word(
        Morpheme(word.stem.regularized + ending),
        newInflections
    )

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }

}

class FormWithProsodicLengthening(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {

    override fun inflect(word: Word) = Word(
        compoundWithLengthening(word.lexicalForm, Morpheme(ending)),
        newInflections
    )

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }

}

class StemWithProsodicLengthening(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {

    override fun inflect(word: Word) = Word(
        compoundWithLengthening(word.stem, Morpheme(ending)),
        newInflections
    )

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }

}

class FormWithRemoval(
    override val name: String,
    val removal: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word) = Word(
        Morpheme(
            word.lexicalForm.regularized.substring(
                0, word.lexicalForm.regularized.length - removal.length
            )
        ),
        newInflections
    )

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }

}

private class Verb(form: Morpheme, ancientStem: Morpheme) {
    val isSimple = !form.endsWith(listOf("a", "u"))
    val isPossibleFormative = form.endsWith(listOf("ta", "ya"))
    val formWithoutSuffix = if (isPossibleFormative) {
        Verb(Morpheme(form.regularized.substring(0, form.regularized.length - 2)), ancientStem)
    } else {
        null
    }
    val prefix = if (isSimple) {
        form.pseudoSyllables.subList(0, form.syllableCount - 1).joinToString("")
    } else {
        form.pseudoSyllables.subList(0, form.syllableCount - 2).joinToString("")
    }
    val stem = if (isSimple) form.pseudoSyllables.last() else form.pseudoSyllables.secondToLast()
    val stemTokens = Morpheme(stem).tokens
    val stemVowel = stemTokens.first { it in diphthongs || it in vowels }
    val stemOnset = stemTokens.first { it in consonantClusters || it in consonants }
    val stemCoda = stemTokens.last { it in consonantClusters || it in consonants }
    val needsMedialDevelopment = if (isSimple) form.syllableCount < 2 else form.syllableCount < 3

    val lengthenedForm = if (isSimple) {
        form.lengthenedLast
    } else {
        Morpheme(form.pseudoSyllables.subList(0, form.syllableCount - 1).joinToString("")).lengthenedLast
    }
}


class FormWithLengthenedStem(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word): Word {
        val verb = Verb(word.lexicalForm, word.stem)
        return Word(
            Morpheme(verb.lengthenedForm + ending),
            newInflections
        )
    }

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }
}

class FormWithAssimilationSuffix(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word): Word {
        return Word(
            Morpheme((word.lexicalForm.regularized + ending).replaceAll(consonantAssimilation)),
            newInflections
        )
    }

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }
}

class FormWithAssimilationPrefix(
    override val name: String,
    val prefix: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word): Word {
        return Word(
            Morpheme((prefix + word.lexicalForm.regularized).replaceAll(consonantAssimilation)),
            newInflections
        )
    }

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }
}