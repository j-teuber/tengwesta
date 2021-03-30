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
): Inflection() {

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
): Inflection() {

    override fun inflect(word: Word) = Word(
        compoundWithLengthening(word.stem, Morpheme(ending)),
        newInflections
    )

    override fun unInflect(morpheme: Morpheme): Word {
        TODO("Not yet implemented")
    }

}