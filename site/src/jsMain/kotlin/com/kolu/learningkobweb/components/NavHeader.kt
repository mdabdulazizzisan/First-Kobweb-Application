package com.kolu.learningkobweb.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun NavHeader(){
    val ctx = rememberPageContext()
    var colorMode by ColorMode.currentState
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(top = 10.px)
    ){
        P(
            attrs = Modifier
                .fontSize(20.px)
                .toAttrs(),
        ) {
            Row {
                SpanText(
                    text = "Developed with "
                )
                FaHeart(
                    style = IconStyle.FILLED,
                    modifier = Modifier.color(Colors.Red)
                )
                SpanText(
                    text = " by "
                )
                A(href = "https://www.github.com/mdabdulazizzisan"){
                    Text("Md Abdul Aziz Zisan")
                }

            }
        }
        Spacer()
        Row {
            Button(
                modifier = Modifier
                    .background(Colors.Transparent),
                onClick = {
                    ctx.router.navigateTo("https://github.com/mdabdulazizzisan/First-Kobweb-Application")

                },
            ){
                FaGithub()
            }
            Button(
                modifier = Modifier
                    .background(Colors.Transparent),
                onClick = {
                    colorMode = colorMode.opposite
                }){
                if(colorMode.isLight) FaSun() else FaMoon()
            }
        }
    }
}