package com.carlosh.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlosh.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(modifier) {
        BackgroundImage()
        TitleApp()
        Column(modifier = modifier) {
            ContentApp(text = stringResource(R.string.first_fragment), arrayOf(16, 0, 16, 0))
            ContentApp(text = stringResource(R.string.second_fragment), arrayOf(16, 16, 16, 16))
        }
    }
}

@Composable
fun BackgroundImage(modifier: Modifier = Modifier) {
    val painter = painterResource(id = R.drawable.bg_compose_background)
    Image(painter = painter, contentDescription = null)
}

@Composable
fun TitleApp(modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Jetpack Compose Tutorial", fontSize = 24.sp, textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ContentApp(text: String, padding: Array<Int>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(padding[0].dp, padding[1].dp, padding[2].dp, padding[3].dp)) {
        Text(text = text, fontSize = 16.sp, fontFamily = FontFamily.SansSerif)
    }
}

@Preview(
    showBackground = true, showSystemUi = true
)
@Composable
fun LearnTogetherThemePreview(modifier: Modifier = Modifier) {
    App()
}