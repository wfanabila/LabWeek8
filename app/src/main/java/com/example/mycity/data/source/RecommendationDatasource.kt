package com.example.mycity.data.source

import com.example.mycity.R
import com.example.mycity.data.model.Recommendation

class RecommendationDatasource {
    val listOfRecommendations = listOf(
        /* -------------- Coffee Shops -----------------*/
        Recommendation(
            imageId = R.drawable.coffe_shop_title_1,
            titleId = R.string.coffe_shop_title_1,
            desId = R.string.coffe_shop_detail_1,
            categoryId = 1
        ),
        Recommendation(
            imageId = R.drawable.coffe_shop_title_2,
            titleId = R.string.coffe_shop_title_2,
            desId = R.string.coffe_shop_detail_2,
            categoryId = 1
        ),
        Recommendation(
            imageId = R.drawable.coffe_shop_title_3,
            titleId = R.string.coffe_shop_title_3,
            desId = R.string.coffe_shop_detail_3,
            categoryId = 1
        ),
        /* -------------- Restaurants -----------------*/
        Recommendation(
            imageId = R.drawable.restaurant_title_1,
            titleId = R.string.restaurant_title_1,
            desId = R.string.restaurant_detail_1,
            categoryId = 2
        ),
        Recommendation(
            imageId = R.drawable.restaurant_title_2,
            titleId = R.string.restaurant_title_2,
            desId = R.string.restaurant_detail_2,
            categoryId = 2
        ),
        Recommendation(
            imageId = R.drawable.restaurant_title_3,
            titleId = R.string.restaurant_title_3,
            desId = R.string.restaurant_detail_3,
            categoryId = 2
        )
    )
}