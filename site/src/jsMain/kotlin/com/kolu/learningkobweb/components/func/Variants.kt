package com.kolu.learningkobweb.components.func

sealed class Variants {
    data object Rock: Variants()
    data object Paper: Variants()
    data object Scissor: Variants()
}


fun Variants.isRock(): Boolean{
    return this is Variants.Rock
}

fun Variants.isPaper(): Boolean{
    return this is Variants.Paper
}

fun Variants.isScissor(): Boolean{
    return this is Variants.Scissor
}