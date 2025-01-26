package com.kolu.learningkobweb.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.silk.components.forms.Button
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
                        winner = checkWin(playerSelected)
                    },
                ){
                    Text("Rock")
                }
                Button(
                    modifier = Modifier
                        .size(100.px)
                        .margin(leftRight = 10.px),
                    onClick = { playerSelected = 1
                        winner = checkWin(playerSelected) },
                ){
                    Text("Paper")
                }
                Button(
                    modifier = Modifier
                        .size(100.px)
                        .margin(leftRight = 10.px),
                    onClick = {
                        playerSelected = 2
                        winner = checkWin(playerSelected) },
                ){
                    Text("Scissor")
                }
            }
            Text(
                value = if (winner) "You selected $playerSelected Winner!" else "you selected $playerSelected Looser!"
            )
        }


    }
}

fun checkWin(selected: Int): Boolean{
    val winner = Random.nextInt(0,3)
    return winner == selected
}