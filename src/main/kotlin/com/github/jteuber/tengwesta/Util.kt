package com.github.jteuber.tengwesta

fun String.endsWith(vararg soundClasses: List<String>): Boolean {
    for (c in soundClasses) {
        for (option in c) {
            if (this.endsWith(option)) return true
        }
    }
    return false
}

fun String.startsWith(vararg soundClasses: List<String>): Boolean {
    for (c in soundClasses) {
        for (option in c) {
            if (this.startsWith(option)) return true
        }
    }
    return false
}

fun String.contains(vararg soundClasses: List<String>): Boolean {
    for (c in soundClasses) {
        for (option in c) {
            if (this.contains(option)) return true
        }
    }
    return false
}

fun String.replaceAll(map: Map<String, String>): String {
    var result = this
    for ((new, old) in map) result = result.replace(new, old)
    return result
}

fun <E> List<E>.secondToLast() = get(size - 2)

fun <E> List<E>.lastN(n: Int) = if (n >= size) {
    this
} else {
    subList(size-n, size)
}