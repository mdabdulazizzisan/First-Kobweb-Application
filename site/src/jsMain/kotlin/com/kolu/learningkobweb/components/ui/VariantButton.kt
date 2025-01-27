package com.kolu.learningkobweb.components.ui

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun VariantButton(
    onClick: () -> Unit,
    icon: @Composable () -> Unit = {}
){
    Button(
        modifier = Modifier
            .margin(leftRight = 3.px)
            .background(Colors.Transparent)
            .border(
                width = 1.px,
                style = LineStyle.Solid,
                color = Colors.Gray
            ),
        onClick = { onClick() },
        size = ButtonSize.MD
    ){
        icon()
    }
}