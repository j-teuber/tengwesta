package com.github.jteuber.tengwesta

abstract class Class {
    abstract val inflections: List<Inflection>
}

abstract class Inflection {
    abstract fun inflect(word: Word): Word
    abstract fun unInflect(word: Word): Word
}

class BasicInflection(
    val ending: String,
    val newClasses: List<Class> = emptyList()
): Inflection() {

    override fun inflect(word: Word) = Word(
        compound(word, Word(ending)),
        newClasses
    )

    override fun unInflect(word: Word): Word {
        TODO("Not yet implemented")
    }

}