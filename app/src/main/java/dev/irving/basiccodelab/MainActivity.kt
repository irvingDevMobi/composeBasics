package dev.irving.basiccodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.irving.basiccodelab.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("Compose", "Irving Dev")) {
    Column(Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(
                name = name,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview() {
    BasicCodelabTheme {
        MyApp()
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello,")
                Text(text = name)
            }

            OutlinedButton(
                onClick = { expanded.value = !expanded.value },
            ) {
                Text(text = if (expanded.value) "Show Less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicCodelabTheme {
        Greeting("Android")
    }
}
