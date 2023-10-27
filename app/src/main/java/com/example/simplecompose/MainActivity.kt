package com.example.simplecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsAnimationCompat.BoundsCompat
import com.example.simplecompose.ui.theme.SimpleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeTheme {
                // A surface container using the 'background' color from the theme
                    GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TapButton(modifier: Modifier=Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Surface(
            shape = CircleShape,
            color = MaterialTheme.colorScheme.error,
            modifier = modifier
                .size(100.dp)
                .clickable {
                    Log.d("Button", "Clicked")
                }
        ) {
            Text(
                modifier = Modifier.padding(
                    top=40.dp
                ),
                text = "Tap",
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceTint
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$100",
                fontSize = TextUnit(30f, TextUnitType.Sp),
                modifier = Modifier
                    .padding(
                        bottom = 100.dp
                    )
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            TapButton()
            Text(
                text = "Lots of Money",
                modifier=Modifier.alpha(0f).padding(
                    top=30.dp
                )
            )
        }
    }
}