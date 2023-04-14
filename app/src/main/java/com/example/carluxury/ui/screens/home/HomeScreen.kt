package com.example.carluxury.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carluxury.data.categoryList
import com.example.carluxury.ui.theme.*

@Composable
fun HomeScreen(modifier:Modifier = Modifier) {
    var itemValue by remember { mutableStateOf(0) }
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(topBar = {TopBarHome()}) {padding ->
        Box(
            modifier
                .padding(padding)
                .fillMaxSize()
                .background(color = orange1)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                OutlinedTextField(
                    value = text,
                    trailingIcon = {
                        Icon(
                            imageVector =Icons.Filled.Search ,
                            tint = MaterialTheme.colors.background,
                            contentDescription = ""
                        )
                    },
                    onValueChange = {newText -> text = newText},
                    shape = Shapes.medium,
                    placeholder = { Text(text = "search")},
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f),
                        focusedBorderColor = MaterialTheme.colors.surface.copy(alpha = 0.3f),
                        unfocusedBorderColor = MaterialTheme.colors.surface.copy(alpha = 0.3f))
                        ,
                    modifier = Modifier.fillMaxWidth()
                )
                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp), horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        ButtonMenu(onClick = {itemValue = 0}, label = "all", itemMenu = itemValue, index = 0)
                    }
                    // Add 5 items
                    itemsIndexed(categoryList) { index,item ->
                        ButtonMenu(onClick = {itemValue = index + 1}, label = item.name, itemMenu = itemValue,index = index + 1)
                    }
                }

            }

            Card(
                shape = RoundedCornerShape(
                    topEnd = 50.dp,
                    topStart = 50.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                ),
                elevation = 16.dp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 240.dp)
                    .background(color = MaterialTheme.colors.primary),

            ){}

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(top = 200.dp, end = 30.dp, start = 30.dp, bottom = 32.dp)){
                items(5){
                    index ->  CardProduct(
                    Car(image = "https://images.pexels.com/photos/3802510/pexels-photo-3802510.jpeg?auto=compress&cs=tinysrgb&w=800",
                        name = "lamborghini",
                        description = "this is a car for your life and your all",
                        price = 600000.0,
                        about = ""
                    ))
                }
            }
            
            Spacer(
                modifier = Modifier
                    .height(4.dp).width(190.dp)
                    .background(color = orange2)
                    .padding(32.dp)
                    .align(Alignment.BottomCenter)

            )
        }
    }


}

@Composable
fun TopBarHome() {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(color = orange1)) {
        IconButton(onClick = {  }) {
            Icon(
                imageVector =Icons.Filled.Menu ,
                tint = MaterialTheme.colors.background,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {  }) {
            Icon(
                imageVector =Icons.Filled.ShoppingCart ,
                tint = MaterialTheme.colors.background,
                contentDescription = ""
            )

        }
    }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_NO)
fun HomePreview() {
    CarLuxuryTheme {
        HomeScreen()
    }
}