package com.github.jteuber.tengwesta

fun main() {
    val word = Word(Form("Annatar"), consonantal)
    val forms1 = word.inflections.map {it to it.inflect(word) }
    for ((i1, f1) in forms1) {
        println("${f1.lexicalForm.regularized} -- ${i1.name}")
        val forms2 = f1.inflections.map { it to it.inflect(f1) }
        for ((i2, f2) in forms2) {
            println("    ${f2.lexicalForm.regularized} -- ${i2.name}")
            val forms3 = f2.inflections.map { it to it.inflect(f2) }
            for ((i3, f3) in forms3) {
                println("        ${f3.lexicalForm.regularized} -- ${i3.name}")
            }
        }
    }
}