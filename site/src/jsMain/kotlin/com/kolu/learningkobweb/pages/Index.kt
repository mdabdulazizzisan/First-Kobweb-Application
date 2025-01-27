package com.kolu.learningkobweb.pages

import androidx.compose.runtime.*
import com.kolu.learningkobweb.components.func.Decision
import com.kolu.learningkobweb.components.func.Variants
import com.kolu.learningkobweb.components.func.getComputerVariant
import com.kolu.learningkobweb.components.func.getDecision
import com.kolu.learningkobweb.components.ui.NavHeader
import com.kolu.learningkobweb.components.ui.VariantButton
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.silk.components.icons.fa.*
import org.jetbrains.compose.web.dom.P

@Page
@Composable
fun HomePage() {
    var playerSelected: Variants by remember { mutableStateOf(Variants.Rock) }
    var computerSelected: Variants by remember { mutableStateOf(Variants.Rock) }
    var decision: Decision by remember { mutableStateOf(Decision.Draw) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(leftRight = 20.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavHeader()
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    VariantButton(
                        onClick = {
                            playerSelected = Variants.Rock
                            computerSelected = getComputerVariant()
                            decision = getDecision(playerSelected, computerSelected)
                        }
                    ){
                        FaHandFist(size = IconSize.XXL)
                    }
                    VariantButton(
                        onClick = {
                            playerSelected = Variants.Paper
                            computerSelected = getComputerVariant()
                            decision = getDecision(playerSelected, computerSelected)
                        }
                    ){
                        FaHand(size = IconSize.XXL, style = IconStyle.FILLED)
                    }
                    VariantButton(
                        onClick = {
                            playerSelected = Variants.Scissor
                            computerSelected = getComputerVariant()
                            decision = getDecision(playerSelected, computerSelected)
                        }
                    ){
                        FaHandPeace(size = IconSize.XXL, style = IconStyle.FILLED)
                    }
                }
                P(
                    attrs = Modifier
                        .fontSize(40.px)
                        .margin(top = 20.px)
                        .toAttrs()
                ) {
                    Column {
                        Text(
                            value = "Player: $playerSelected || Computer: $computerSelected."
                        )
                    }
                }
                P(
                    attrs = Modifier
                        .fontSize(40.px)
                        .margin(top = 20.px)
                        .toAttrs()
                ){
                    Text(
                        value = "You $decision!!!"
                    )
                }
            }
        }
    }
}