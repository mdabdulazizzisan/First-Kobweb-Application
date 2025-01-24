package com.kolu.learningkobweb.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.silk.components.forms.Button
@Page
@Composable
fun HomePage() {
    var name by remember { mutableStateOf("") }
    var colorMode by ColorMode.currentState
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            FaFaceSmile(
                modifier = Modifier.margin(right = 10.px),
                size = IconSize.XXL,
                style = IconStyle.OUTLINE
            )
            P(
                attrs = Modifier
                    .fontSize(40.px)
                    .toAttrs()
            ) {
                Text(
                    value = "Hello $name"
                )
            }

        }
        Input(
            type = InputType.Text,
            attrs = Modifier
                .fontSize(20.px)
                .outline(
                    width = 10.px,
                    style = LineStyle.None,
                    color = Colors.Red
                )
                .padding(leftRight = 20.px, topBottom = 10.px)
                .toAttrs(){
                    placeholder(value = "Enter Your Name: ")
                    onInput { name = it.value }
                }
        )
        Button(
            modifier = Modifier
                .margin(top = 10.px),
            onClick = {
                colorMode = colorMode.opposite
            }){
            if(colorMode.isLight) FaSun() else FaMoon()
        }
    }
}
