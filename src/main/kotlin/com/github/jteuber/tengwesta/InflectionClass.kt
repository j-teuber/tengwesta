package com.github.jteuber.tengwesta

abstract class Class {
    abstract val inflections: List<Inflection>
}

abstract class Inflection {
    abstract val name: String
    abstract fun inflect(morpheme: Morpheme): Morpheme
    abstract fun unInflect(morpheme: Morpheme): Morpheme
}

class BasicInflection(
    override val name: String,
    val ending: String,
    val newClasses: List<Class> = emptyList()
): Inflection() {

    override fun inflect(morpheme: Morpheme) = Morpheme(
        compound(morpheme, Morpheme(ending)),
        newClasses
    )

    override fun unInflect(morpheme: Morpheme): Morpheme {
        TODO("Not yet implemented")
    }

}