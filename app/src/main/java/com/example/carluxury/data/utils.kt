package com.example.carluxury.data

val categoryList = listOf(
    Category(
        1,
        "Lamborghini",
    ),
    Category(
        2,
        "Ferrari",
    ),
    Category(
        3,
        "Bugatti",
    ),
    Category(
        4,
        "GMC",
    ),
    Category(
        5,
        "Tesla",
    ),
    Category(
        6,
        "Mercedes",
    ),



)

data class Category(
    val id:Int,
    val name: String,
)