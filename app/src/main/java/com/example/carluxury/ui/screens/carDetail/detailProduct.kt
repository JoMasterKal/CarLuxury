package com.example.carluxury.ui.screens.carDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.carluxury.R
import com.example.carluxury.ui.theme.orange1


@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    
    Scaffold(topBar = { TopBarDetail()}) { padding ->  
        Column(modifier = Modifier.padding()) {
            
        }
    }
    
}

@Composable
fun TopBarDetail() {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = androidx.compose.ui.Modifier.background(color = MaterialTheme.colors.background)) {
        IconButton(onClick = {  }) {
//            Icon(
//                painter = painterResource(id = R.drawable.arrow_back_ios),
//                tint = orange1,
//                contentDescription = ""
//            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_ios),
                tint = orange1,
                contentDescription = ""
            )
        }
        Spacer(modifier = androidx.compose.ui.Modifier.weight(1f))

        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Filled.MoreVert ,
                tint = MaterialTheme.colors.background,
                contentDescription = ""
            )

        }
    }
}

@Composable
@Preview()
fun DetailPreview() {
    DetailScreen()
}

