package com.kolu.learningkobweb.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.silk.components.forms.Button
import org.jetbrains.compose.web.dom.P
import kotlin.random.Random

@Page
@Composable
fun HomePage() {
    var playerSelected by remember { mutableStateOf(-1) }
    var computerSelected by remember { mutableStateOf(-1) }
    var winner by remember { mutableStateOf(false) }
    var colorMode by ColorMode.currentState
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End
    ) {
        Button(
            modifier = Modifier
                .margin(top = 10.px, right = 10.px),
            onClick = {
                colorMode = colorMode.opposite
            }){
            if(colorMode.isLight) FaSun() else FaMoon()
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .size(100.px)
                        .margin(leftRight = 10.px),
                    onClick = {
                        playerSelected = 0
                        computerSelected = getComputerSelected()
                        winner = playerSelected == computerSelected
                    },
                ){
                    Text("Rock")
                }
                Button(
                    modifier = Modifier
                        .size(100.px)
                        .margin(leftRight = 10.px),
                    onClick = {
                        playerSelected = 1
                        computerSelected = getComputerSelected()
                        winner = playerSelected == computerSelected },
                ){
                    Text("Paper")
                }
                Button(
                    modifier = Modifier
                        .size(100.px)
                        .margin(leftRight = 10.px),
                    onClick = {
                        playerSelected = 2
                        computerSelected = getComputerSelected()
                        winner = playerSelected == computerSelected },
                ){
                    Text("Scissor")
                }
            }

            P(
                attrs = Modifier
                    .fontSize(40.px)
                    .margin(top = 20.px)
                    .toAttrs()
            ) {
                Text(
                    value = if (winner) "You selected ${selectedToString(playerSelected)} \n" +
                            "and I selected ${selectedToString(computerSelected)} \n" +
                            "You Win!!!" else "You selected ${selectedToString(playerSelected)} \n" +
                            "and I selected ${selectedToString(computerSelected)} \n" +
                            "You Loose!!!",
                )
            }
        }


    }
}


fun getComputerSelected(): Int{
    return Random.nextInt(0,3)
}

fun selectedToString(selected: Int): String{
    return when(selected){
        0 -> "rock"
        1 -> "Paper"
        2 -> "Scissor"
        else -> "Invalid"
    }
}