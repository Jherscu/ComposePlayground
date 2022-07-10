package com.jherscu.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jherscu.composeplayground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Theme()
        }
    }
}

@Composable
fun Theme() {
    val color = remember {
        mutableStateOf(Color.Blue)
    }

    Surface(
        shape = CircleShape,
        modifier = Modifier
            .padding(32.dp)
            .border(10.dp, Color.Magenta, shape = CircleShape)
            .padding(32.dp)
            .border(10.dp, Color.Magenta, shape = CircleShape)
            .fillMaxSize(),
        color = Color.Cyan
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 32.sp
                    )
                ) {
                    append("H")
                }
                append("ello ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 32.sp
                    )
                ) {
                    append("A")
                }
                append("ndroid")
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 32.sp
                    )
                ) {
                    append("!")
                }
                },
                textDecoration = TextDecoration.Underline
            )
            ImageCard(
                painter = painterResource(id = R.drawable.kermit),
                contentDescription = "Picture of Kermit in the snow",
                title = "Kermit in the snow"
            )
            Surface(modifier = Modifier, shape = RoundedCornerShape(15.dp)) {
                Text(
                    text = "Hello Pie!",
                    color = Color.White,
                    modifier = Modifier
                        .background(color = color.value)
                        .padding(15.dp)
                        .clickable {
                            if (color.value == Color.Blue) {
                                color.value = Color.Magenta
                            } else {
                                color.value = Color.Blue
                            }
                        }
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(0.7f),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewPreview() {
    ImageCard(
        painter = painterResource(id = R.drawable.kermit),
        contentDescription = "Picture of Kermit in the snow",
        title = "Kermit in the snow"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Theme()
}