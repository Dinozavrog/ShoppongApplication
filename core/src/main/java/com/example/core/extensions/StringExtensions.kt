package com.example.core.extensions

fun String.isValidPassword(): Boolean =
    this.length >= 8
            && this.isContainLetter()
            && this.isContainDigit()

private fun String.isContainLetter(): Boolean {
    this.forEach {
        if (it.isLetter()) return true
    }
    return false
}

private fun String.isContainDigit(): Boolean {
    this.forEach {
        if (it.isDigit()) return true
    }
    return false
}