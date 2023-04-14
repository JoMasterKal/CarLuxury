package com.example.carluxury.ui.screens.home
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.carluxury.ui.theme.*

@Composable
fun ButtonMenu(onClick:()->Unit,label:String,itemMenu: Int,index:Int) {
    TextButton(
        onClick = onClick,
        shape = Shapes.large,
        colors = if(itemMenu == index) ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3f),
            contentColor = MaterialTheme.colors.background,
        )else ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = orange3
        ),
    ) {
        Text(text = label,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun CardProduct(car: Car) {
    Card(elevation = 8.dp, shape = Shapes.small,modifier = Modifier.padding(8.dp),) {
       Row(modifier = Modifier
           .fillMaxWidth()
           .padding(8.dp)) {

           Column(modifier = Modifier
               .padding(8.dp)
               .weight(2f)) {
               Text(
                   text = car.name,style = MaterialTheme.typography.h4,
                   modifier = Modifier.padding(8.dp)
               )
               Text(text = car.description, style = MaterialTheme.typography.body1,color = grey2,
                   modifier = Modifier.padding(bottom = 8.dp, start = 8.dp)
               )
               Text(
                   text = "$${car.price}", style = MaterialTheme.typography.h4,color = green1,
                   modifier = Modifier.padding(start = 8.dp)
               )

           }

           Column(modifier = Modifier
               .fillMaxHeight()
               .weight(1f)
               .padding(top = 32.dp), verticalArrangement = Arrangement.Center) {
               Box(modifier = Modifier
                   .width(120.dp)
                   .height(80.dp),
                   contentAlignment = Alignment.Center,

                   ) {

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
                   )
               }
           }

           IconButton(onClick = {  }, modifier = Modifier.weight(0.5f)) {
               Icon(
                   imageVector = Icons.Filled.Favorite ,
                   tint = orange1,
                   contentDescription = "",

               )
           }
       }
    }
}

data class Car(
    val image : String,
    val name: String,
    val description: String,
    val price: Double,
    val about: String
)

@Composable
@Preview
fun CardProductPreview() {
    CardProduct(car =
    Car(image = "https://images.pexels.com/photos/3802510/pexels-photo-3802510.jpeg?auto=compress&cs=tinysrgb&w=800",
        name = "lamborghini",
        description = "this is a car for your life",
        price = 600000.0,
        about = ""
    ))
}