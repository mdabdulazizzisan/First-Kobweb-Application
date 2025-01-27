package com.kolu.learningkobweb.components.func

import kotlin.random.Random

fun getComputerVariant(): Variants{
    return when(Random.nextInt(0, 3)){
        0 -> Variants.Rock
        1 -> Variants.Paper
        else -> Variants.Scissor
    }
}