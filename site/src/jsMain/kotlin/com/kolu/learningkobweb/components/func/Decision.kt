package com.kolu.learningkobweb.components.func

sealed interface Decision {
    data object Win
    data object Loose
    data object Draw
}