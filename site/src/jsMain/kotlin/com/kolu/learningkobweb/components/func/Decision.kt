package com.kolu.learningkobweb.components.func

sealed interface Decision {
    data object Win: Decision
    data object Loose: Decision
    data object Draw: Decision
}