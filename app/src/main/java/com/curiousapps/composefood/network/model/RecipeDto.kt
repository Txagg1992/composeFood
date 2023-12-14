package com.curiousapps.composefood.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @SerializedName("pk")
    var pk: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("publisher")
    var publisher: String,
    @SerializedName("featured_image")
    var featuredImage: String,
    @SerializedName("rating")
    var rating: Int = 0,
    @SerializedName("source_url")
    var sourceUrl: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("cooking_instructions")
    var cookingInstructions: String,
    @SerializedName("ingredients")
    var ingredients: List<String> = emptyList(),
    @SerializedName("long_date_added")
    var longDateAdded: String,
    @SerializedName("long_date_updated")
    var longDateUpdated: String,

)
