package com.curiousapps.composefood.network.model

import android.text.format.DateUtils
import com.curiousapps.composefood.domain.model.Recipe
import com.curiousapps.composefood.util.DomainMapper

class RecipeDtoMapper: DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            ingredients = model.ingredients,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            dateAdded = model.longDateAdded,
            dateUpdated = model.longDateUpdated,
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            ingredients = domainModel.ingredients,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            longDateAdded = domainModel.dateAdded,
            longDateUpdated = domainModel.dateUpdated,
            )
    }

    fun toDomainList(initial: List<RecipeDto>): List<Recipe>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}