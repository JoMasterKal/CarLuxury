package com.example.carluxury.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carluxury.R
import com.example.carluxury.ui.theme.CarLuxuryTheme
import com.example.carluxury.ui.theme.Shapes
import com.example.carluxury.ui.theme.mallow1
import com.example.carluxury.ui.theme.orange1
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController



@Composable
fun SplashScreen() {

    val systemUiController: SystemUiController = rememberSystemUiController()

    systemUiController.isStatusBarVisible = false

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxSize()
        .background(color = mallow1)) {
        Box(modifier = Modifier
            .padding(top = 10.dp)
            .width(230.dp)
            .height(230.dp)
            .background(color = orange1)
        ) {
            Image(painter = painterResource(id = R.drawable.lucar), contentDescription = null,
                modifier = Modifier
                    .size(220.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(50)),
            )
        }
        
        Text(text = "Car selling app",
            color = MaterialTheme.colors.background,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
        )

        Text(text = "Order your favorite desert Here!",
            color = MaterialTheme.colors.background,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(163.dp)
                .padding(top = 8.dp)

        )

        Button(
            onClick = { },
            shape = Shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp, top = 128.dp)
        ) {
            Text(text = "Get Started",
                style = MaterialTheme.typography.h5,
            )
        }
    }
}

@Preview()
@Composable
fun SplashPreview() {
    CarLuxuryTheme(darkTheme = false) {
        SplashScreen()
    }
}

