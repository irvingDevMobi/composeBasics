package dev.irving.layoutscompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.irving.layoutscompose.ui.theme.LayoutComposeTheme

@Composable
fun TwoText(modifier: Modifier = Modifier, text1: String, text2: String) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        Text(
            text = text1,
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
                .wrapContentWidth(Alignment.Start)
        )
        Divider(
            color = Color.Black, modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
        )
        Text(
            text = text2,
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
                .wrapContentWidth(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TwoTextsPreview() {
    LayoutComposeTheme {
        Surface {
            TwoText(text1 = "Hi", text2 = "Dev!!!")
        }
    }
}
