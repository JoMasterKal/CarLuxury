package com.example.carluxury.ui.screens.carDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.carluxury.R
import com.example.carluxury.ui.screens.home.Car
import com.example.carluxury.ui.theme.orange1
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle


@Composable
fun DetailScreen(car: Car,modifier: Modifier = Modifier) {
    
    Scaffold(topBar = { TopBarDetail()}) { padding ->  
        Column(modifier = Modifier.padding(padding)) {

            SubcomposeAsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(car.image)
                    .crossfade(true)
                    .build(),
                loading = {
                    CircularProgressIndicator()
                },
                //error = painterResource(R.drawable.ic_broken_image),
                //placeholder = painterResource(R.drawable.loading_img),
                contentDescription = "Amphibian Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(250.dp)
                    .padding(start = 16.dp, top = 64.dp, end = 16.dp)
            )

            Row() {
                ProductInfo(car = car)

            }

        }
    }
    
}

@Composable
fun ProductInfo(car: Car) {
    Column() {
        Text(text = car.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(4.dp)
        )
        Text(text = car.description,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(4.dp)
        )

        Row(modifier = Modifier.padding(top = 16.dp)) {
            RatingBar(
                value = 4.0F,
                config = RatingBarConfig()
                    .style(RatingBarStyle.HighLighted),
                onValueChange = {

                },
                onRatingChanged = {
                }
            )

            Text(text = "2.2k",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(start = 8.dp, top = 7.dp)
            )

        }



        Text(text = stringResource(R.string.about_this_product),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(4.dp)
        )
        Text(text = car.about,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun TopBarDetail() {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.background(color = MaterialTheme.colors.background)) {
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
        Spacer(modifier = Modifier.weight(1f))

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
    DetailScreen(
        car = Car(image = "https://images.pexels.com/photos/3802510/pexels-photo-3802510.jpeg?auto=compress&cs=tinysrgb&w=800",
            name = "lamborghini",
            description = "this is a car for your life",
            price = 600000.0,
            about = ""
        )
    )
}

