package com.kolu.learningkobweb.components.func

fun getDecision(player: Selection, computer: Selection): Decision{
    return if(player == computer) Decision.Draw
    else if(
        (player.isRock() && computer.isScissor()) ||
        (player.isPaper() && computer.isRock()) ||
        (player.isScissor() && computer.isPaper())
    ){
        Decision.Win
    }
    else Decision.Loose
}