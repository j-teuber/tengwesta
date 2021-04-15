package com.github.jteuber.tengwesta

abstract class Inflection {
    abstract val name: String
    abstract fun inflect(word: Word): Word
    abstract fun unInflect(morpheme: Form): Word

    private var eldamo: Long = 0
    fun eldamo(id: Long) = also { eldamo = id }
}

class SimpleForm(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word) = Word(
        Form(word.lexicalForm.regularized + ending),
        newInflections
    )

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }

}

class SimpleStem(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word) = Word(
        Form(word.stem.regularized + ending),
        newInflections
    )

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }

}

class FormWithProsodicLengthening(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {

    override fun inflect(word: Word) = Word(
        compoundWithLengthening(word.lexicalForm, Form(ending)),
        newInflections
    )

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }

}

class StemWithProsodicLengthening(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {

    override fun inflect(word: Word) = Word(
        compoundWithLengthening(word.stem, Form(ending)),
        newInflections
    )

    override fun unInflect(morpheme: Form): Word {
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
        Form(
            word.lexicalForm.regularized.substring(
                0, word.lexicalForm.regularized.length - removal.length
            ) + ending
        ),
        newInflections
    )

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }

}

private class Verb(form: Form, ancientStem: Form) {
    val isSimple = !form.endsWith(listOf("a", "u"))
    val isPossibleFormative = form.endsWith(listOf("ta", "ya"))
    val formWithoutSuffix = if (isPossibleFormative) {
        Verb(Form(form.regularized.substring(0, form.regularized.length - 2)), ancientStem)
    } else {
        null
    }
    val prefix = if (isSimple) {
        form.pseudoSyllables.subList(0, form.syllableCount - 1).joinToString("")
    } else {
        form.pseudoSyllables.subList(0, form.syllableCount - 2).joinToString("")
    }
    val stem = if (isSimple) form.pseudoSyllables.last() else form.pseudoSyllables.secondToLast()
    val stemTokens = Form(stem).tokens
    val stemVowel = stemTokens.first { it in diphthongs || it in vowels }
    val stemOnset = stemTokens.first { it in consonantClusters || it in consonants }
    val stemCoda = stemTokens.last { it in consonantClusters || it in consonants }
    val needsMedialDevelopment = if (isSimple) form.syllableCount < 2 else form.syllableCount < 3

    val lengthenedForm = if (isSimple) {
        form.lengthenedLast
    } else {
        Form(
            form.pseudoSyllables.subList(0, form.syllableCount - 1).joinToString("")
        ).lengthenedLast + form.pseudoSyllables.last()
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
            Form(verb.lengthenedForm + ending),
            newInflections
        )
    }

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }
}

class FormWithAssimilationSuffix(
    override val name: String,
    val ending: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word): Word {
        val end = Form(ending)
        return Word(
            Form(
                word.lexicalForm.tokens.sublist(-1).str() +
                        (word.lexicalForm.tokens.last() + end.tokens.first()).replaceAll(consonantAssimilation) +
                        end.tokens.sublist(1).str()
            ), newInflections
        )
    }

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }
}

class FormWithAssimilationPrefix(
    override val name: String,
    val prefix: String,
    val newInflections: List<Inflection> = emptyList()
) : Inflection() {
    override fun inflect(word: Word): Word {
        val pre = Form(prefix)
        return Word(
            Form(
                pre.tokens.sublist(-1).str() +
                        (pre.tokens.last() + word.lexicalForm.tokens.first()).replaceAll(consonantAssimilation) +
                        word.lexicalForm.tokens.sublist(1).str()
            ),
            newInflections
        )
    }

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }
}

class ChainInflection(
    override val name: String,
    val newInflections: List<Inflection> = emptyList(),
    vararg inflections: Inflection
) : Inflection() {
    val subInflection = inflections

    override fun inflect(word: Word): Word {
        var result = word
        for (inflection in subInflection) result = inflection.inflect(result)
        return Word(result.lexicalForm, newInflections)
    }

    override fun unInflect(morpheme: Form): Word {
        TODO("Not yet implemented")
    }
}