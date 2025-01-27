package com.kolu.learningkobweb.components.func

sealed class Selection(val value: Int) {
    data object Rock: Selection(value = 0)
    data object Paper: Selection(value = 1)
    data object Scissor: Selection(value = 2)
}

fun Selection.toInt(): Int{
    return when(this){
        Selection.Paper -> Selection.Paper.value
        Selection.Rock -> Selection.Rock.value
        Selection.Scissor -> Selection.Scissor.value
    }
}

fun Selection.isRock(): Boolean{
    return this is Selection.Rock
}

fun Selection.isPaper(): Boolean{
    return this is Selection.Paper
}

fun Selection.isScissor(): Boolean{
    return this is Selection.Scissor
}